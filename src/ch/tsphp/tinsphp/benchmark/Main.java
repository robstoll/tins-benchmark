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
        PrintWriter writer = new PrintWriter("tmp/times.txt", "UTF-8");
        ProcessBuilder builder = new ProcessBuilder("java",
                "-cp", "\"D:\\tins-benchmark\\lib\\*\"",
                "ch.tsphp.tinsphp.Main",
                "\"D:\\tins-benchmark\\src\\test.php\"",
                "\"D:\\tins-benchmark\\tmp\\test.tsphp\"");
//        ProcessBuilder builder = new ProcessBuilder("javac",
//                "-d", "\"D:\\tins-benchmark\\tmp\"",
//                "\"D:\\tins-benchmark\\src\\Test.java\"");
        builder.redirectErrorStream(true);
        for (int i = 0; i < 1010; ++i) {
            long start = System.nanoTime();
            Process process = builder.start();
            int errCode = process.waitFor();
            long stop = System.nanoTime();
            if (errCode == 0) {
                if (i >= 10) {
                    writer.println(stop - start);
                    System.out.println(i + ": " + (stop - start));
                }
            } else {
                System.err.println("Error occurred");
                output(process.getInputStream());
                break;
            }
            File file = new File("D:\\tins-benchmark\\tmp\\test.tsphp");
            file.delete();
        }
        writer.close();
        System.out.println("tests done");
    }

    private static void output(InputStream inputStream) throws IOException {
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
