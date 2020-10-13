package com.gmail.seliverstova.hanna;

import java.io.*;
import java.util.HashSet;

public class App {
    public static void main( String[] args ) {
        HashSet<String> outpuArray = new HashSet<String>();
        File f1 = new File("files/f1.txt");
        File f2 = new File("files/f2.txt");
        File f3 = new File("files/f3.txt");
        String[] strArray1 = getFileBody(f1).split(" ");
        String[] strArray2 = getFileBody(f2).split(" ");

        for(String word1: strArray1) {
            for(String word2: strArray2) {
                if (word1.equalsIgnoreCase(word2)) {
                    outpuArray.add(word1);
                }
            }
        }
        if (outpuArray.isEmpty()) {
            System.out.println("There are no data to write");
        } else {
            saveHashToFile(outpuArray, f3);
        }
    }

    private static String getFileBody(File file) {
        String resultStr = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = "";
            for (;(str = br.readLine()) != null;) {
                resultStr += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultStr.replaceAll(",", "");
        resultStr.replaceAll(".", "");
        return resultStr;
    }

    private static void saveHashToFile(HashSet<String> hs, File file) {
        Object[] array = hs.toArray();
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < array.length; i++) {
                pw.println(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
