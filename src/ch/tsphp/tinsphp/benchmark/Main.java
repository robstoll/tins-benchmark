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
        PrintWriter writer1 = new PrintWriter("tmp/times-tinsphp_" + date + ".txt", "UTF-8");
        PrintWriter writer2 = new PrintWriter("tmp/times-java_" + date + ".txt", "UTF-8");
        PrintWriter writer3 = new PrintWriter("tmp/times-tinsphp2_" + date + ".txt", "UTF-8");
        ProcessBuilder builder1 = new ProcessBuilder("java",
                "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
                "-Xms64m",
                "-Xmx128m",
                "ch.tsphp.tinsphp.Main",
                "\"D:\\tins-benchmark\\src\\test.php\"",
                "\"D:\\tins-benchmark\\tmp\\test.tsphp\"");
        builder1.redirectErrorStream(true);
        ProcessBuilder builder2 = new ProcessBuilder("javac",
                "-d", "\"D:\\tins-benchmark\\tmp\"",
                "\"D:\\tins-benchmark\\src\\Test.java\"",
                "-J-Xms64m",
                "-J-Xmx128m");
        builder2.redirectErrorStream(true);
        ProcessBuilder builder3 = new ProcessBuilder("java",
                "-cp", "\"D:\\tins-benchmark\\parallel_lib\\*\"",
                "-Xms64m",
                "-Xmx128m",
                "ch.tsphp.tinsphp.Main",
                "\"D:\\tins-benchmark\\src\\test.php\"",
                "\"D:\\tins-benchmark\\tmp\\test.tsphp\"");
        builder3.redirectErrorStream(true);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        boolean ok = true;
        for (int i = 0; i < 615; ++i) {
            long start = System.nanoTime();
            final Process process;
            if (i % 3 == 0) {
                process = builder1.start();
            } else if (i % 3 == 1) {
                process = builder2.start();
            } else {
                process = builder3.start();
            }

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
            if (writeOutput(writer1, writer2, writer3, i, start, stop, process, errCode)) {
                ok = false;
                break;
            }
            File file;
            if (i % 2 == 0) {
                file = new File("D:\\tins-benchmark\\tmp\\test.tsphp");
            } else {
                file = new File("D:\\tins-benchmark\\tmp\\Test.class");
            }
            file.delete();
        }
        writer1.flush();
        writer1.close();
        writer2.flush();
        writer2.close();
        writer3.flush();
        writer3.close();
        if (ok) {
            System.out.println("tests done");
        } else {
            System.out.println("test aborted");
        }
    }

    private static boolean writeOutput(
            PrintWriter writer1, PrintWriter writer2, PrintWriter writer3,
            int i, long start, long stop, Process process, int errCode) throws IOException {
        if (errCode == 0) {
            if (i % 3 == 0) {
                if (i >= 15) {
                    writer1.println(stop - start);
                    if (i % 10 == 0) {
                        writer1.flush();
                    }
                }
                System.out.println("tinsphp   " + i + ": " + (stop - start));
            } else if (i % 3 == 1) {
                if (i >= 15) {
                    writer2.println(stop - start);
                    if (i % 10 == 1) {
                        writer2.flush();
                    }
                }
                System.out.println("java      " + i + ": " + (stop - start));
            } else {
                if (i >= 15) {
                    writer3.println(stop - start);
                    if (i % 10 == 2) {
                        writer3.flush();
                    }
                }
                System.out.println("tinsphp 2 " + i + ": " + (stop - start));
            }
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
