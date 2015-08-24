package ch.tsphp.tinsphp.benchmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter writer1 = new PrintWriter("tmp/times-tinsphp.txt", "UTF-8");
        PrintWriter writer2 = new PrintWriter("tmp/times-java.txt", "UTF-8");
        ProcessBuilder builder1 = new ProcessBuilder("java",
                "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
                "ch.tsphp.tinsphp.Main",
                "\"D:\\tins-benchmark\\src\\test.php\"",
                "\"D:\\tins-benchmark\\tmp\\test.tsphp\"");
        builder1.redirectErrorStream(true);
        ProcessBuilder builder2 = new ProcessBuilder("javac",
                "-d", "\"D:\\tins-benchmark\\tmp\"",
                "\"D:\\tins-benchmark\\src\\Test.java\"");
        builder2.redirectErrorStream(true);
        for (int i = 0; i < 1; ++i) {
            long start = System.nanoTime();
            Process process;
            if (i % 2 == 0) {
                process = builder1.start();
            } else {
                process = builder2.start();
            }
            int errCode = process.waitFor();
            long stop = System.nanoTime();
            if (writeOutput(writer1, writer2, i, start, stop, process, errCode)) {
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
        writer1.close();
        System.out.println("tests done");
    }

    private static boolean writeOutput(PrintWriter writer1, PrintWriter writer2, int i, long start, long stop, Process process,
            int errCode) throws IOException {
        if (errCode == 0) {
            if (i % 2 == 0) {
                if (i >= 20) {
                    writer1.println(stop - start);
                }
                System.out.println("tinsphp " + i + ": " + (stop - start));
            } else {
                if (i >= 20) {
                    writer2.println(stop - start);
                }
                System.out.println("java " + i + ": " + (stop - start));
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
            String lineSeparator = System.getProperty("line.separator");
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                System.err.println(line + lineSeparator);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
