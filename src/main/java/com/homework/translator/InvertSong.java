package com.homework.translator;

import java.io.*;
import java.util.Stack;

public class InvertSong {
    private File file;
    private String origin;
    private String destiny;
    private static final String base = "src/main/java/com/homework/translator/";

    public InvertSong(String origin, String destiny) {
        this.origin = origin;
        this.destiny = destiny;
        this.file = new File(base + origin);
        try {
            if (!file.createNewFile()) {
                readFile();
            }
        } catch (IOException e) {
            e.printStackTrace();        }
    }

    private void readFile() {
        Stack<String> stack = new Stack<>();
        try {
            String linea;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((linea = bufferedReader.readLine()) != null) {
                stack.push(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(stack);
    }

    private void writeFile(Stack<String> stack) {
        File file = new File(base + destiny);
        try {
            if (!file.createNewFile()) {
                while (!stack.isEmpty()) {
                    FileWriter fileWriter = new FileWriter(file, true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    StringBuilder info = new StringBuilder(stack.peek());
                    printWriter.println(info);
                    printWriter.close();
                    stack.pop();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
