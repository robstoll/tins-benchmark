package ch.tsphp.tinsphp.benchmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String date = dateFormat.format(new Date());
        String[] names = new String[]{
                "t0_java",
                "t0_sequential",
                "t0_parallel_32",
//                "t1_java",
//                "t1_sequential",
//                "t1_parallel_32",
//                "t2_java",
//                "t2_sequential",
//                "t2_parallel_32",
        };
        PrintWriter[] writers = new PrintWriter[]{
                new PrintWriter("tmp/t0_java_" + date + ".txt", "UTF-8"),
                new PrintWriter("tmp/t0_sequential_" + date + ".txt", "UTF-8"),
                new PrintWriter("tmp/t0_parallel_32_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t1_java_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t1_sequential_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t1_parallel_32_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t2_java_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t2_sequential_" + date + ".txt", "UTF-8"),
//                new PrintWriter("tmp/t2_parallel_32_" + date + ".txt", "UTF-8"),
        };
        ProcessBuilder[] builders = new ProcessBuilder[]{
                new ProcessBuilder("javac",
                        "-d", "\"D:\\tins-benchmark\\tmp\"",
                        "\"D:\\tins-benchmark\\src\\Test0.java\"",
                        "-J-Xms64m",
                        "-J-Xmx128m"),
                new ProcessBuilder("java",
                        "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
                        "-Xms64m",
                        "-Xmx128m",
                        "ch.tsphp.tinsphp.Main",
                        "\"D:\\tins-benchmark\\src\\test0.php\"",
                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
                new ProcessBuilder("java",
                        "-cp", "\"D:\\tins-benchmark\\parallel_lib\\*\"",
                        "-Xms64m",
                        "-Xmx128m",
                        "ch.tsphp.tinsphp.Main",
                        "\"D:\\tins-benchmark\\src\\test0.php\"",
                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
                //
//                new ProcessBuilder("javac",
//                        "-d", "\"D:\\tins-benchmark\\tmp\"",
//                        "\"D:\\tins-benchmark\\src\\Test1.java\"",
//                        "-J-Xms64m",
//                        "-J-Xmx128m"),
//                new ProcessBuilder("java",
//                        "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
//                        "-Xms64m",
//                        "-Xmx128m",
//                        "ch.tsphp.tinsphp.Main",
//                        "\"D:\\tins-benchmark\\src\\test1.php\"",
//                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
//                new ProcessBuilder("java",
//                        "-cp", "\"D:\\tins-benchmark\\parallel_lib\\*\"",
//                        "-Xms64m",
//                        "-Xmx128m",
//                        "ch.tsphp.tinsphp.Main",
//                        "\"D:\\tins-benchmark\\src\\test1.php\"",
//                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
//                //
//                new ProcessBuilder("javac",
//                        "-d", "\"D:\\tins-benchmark\\tmp\"",
//                        "\"D:\\tins-benchmark\\src\\Test2.java\"",
//                        "-J-Xms64m",
//                        "-J-Xmx128m"),
//                new ProcessBuilder("java",
//                        "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
//                        "-Xms64m",
//                        "-Xmx128m",
//                        "ch.tsphp.tinsphp.Main",
//                        "\"D:\\tins-benchmark\\src\\test2.php\"",
//                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
//                new ProcessBuilder("java",
//                        "-cp", "\"D:\\tins-benchmark\\parallel_lib\\*\"",
//                        "-Xms64m",
//                        "-Xmx128m",
//                        "ch.tsphp.tinsphp.Main",
//                        "\"D:\\tins-benchmark\\src\\test2.php\"",
//                        "\"D:\\tins-benchmark\\tmp\\test.tsphp\""),
        };
        for (ProcessBuilder builder : builders) {
            builder.redirectErrorStream(true);
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();

        boolean ok = true;
        int numberOfTests = builders.length * 302;
        for (int i = 0; i < numberOfTests; ++i) {
            ProcessBuilder builder = builders[i % builders.length];
            long start = System.nanoTime();
            final Process process = builder.start();
            Future<Integer> future = executor.submit(new Callable<Integer>()
            {
                @Override
                public Integer call() throws Exception {
                    return process.waitFor();
                }
            });
            int errCode;
            int timeout = 15;
            try {
                errCode = future.get(timeout, TimeUnit.SECONDS);
            } catch (TimeoutException ex) {
                future.cancel(true);
                process.destroy();
                errCode = 0;
                System.out.println("Run number " + i + " was not completed within " + timeout + " seconds.");
            } catch (ExecutionException e) {
                errCode = -1;
            }
            long stop = System.nanoTime();
            if (writeOutput(writers, names, i, stop - start, process, errCode)) {
                ok = false;
                break;
            }
            File file;
            if (i % 3 == 0){
                file = new File("D:\\tins-benchmark\\tmp\\Test0.class");
//            }else if (i % 8 == 4) {
//                file = new File("D:\\tins-benchmark\\tmp\\Test2.class");
            }else {
                file = new File("D:\\tins-benchmark\\tmp\\test.tsphp");
            }
            file.delete();
        }

        for (PrintWriter writer : writers) {
            writer.flush();
            writer.close();
        }

        if (ok) {
            System.out.println("tests done");
        } else {
            System.out.println("test aborted");
        }
        executor.shutdown();
    }

    private static boolean writeOutput(
            PrintWriter[] writers, String[] names, int i, long time, Process process, int errCode) throws IOException {

        if (errCode == 0) {
            PrintWriter writer = writers[i % writers.length];
            if (i >= writers.length * 2) {
                writer.println(time);
                if (i % 10 == i % writers.length) {
                    writer.flush();
                }
            }
            System.out.println(names[i % writers.length] + " " + i + ": " + time);
        } else {
            System.err.println("Error occurred");
            writeToErr(process.getInputStream());
            return true;
        }
        return false;
    }

    private static void writeToErr(InputStream inputStream) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                System.err.println(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
