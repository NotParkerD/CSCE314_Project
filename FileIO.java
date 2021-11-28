import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

public class FileIO {
    public FileIO() { 
    }

    public boolean openTextFile(String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
        } catch (Exception e) {
            System.err.println("Error: Cannot read file");
            return false;
        }
        System.out.println("File exists");
        return true;
    }

    public Vector<String> readTextFile(String filename) {
        Vector<String> tokens = new Vector<String>();
        if (openTextFile(filename)) {
            File file = new File(filename);
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    String token = sc.next().replaceAll("[^a-zA-Z\\-\\']", "").toLowerCase();
                    if (token.equals("") || token.equals("--")) {
                        continue;
                    }
                    tokens.add(token);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(tokens);
        // words.add(new Word(tokens.get(0), 0, 1));

        // for (int i = 1; i < tokens.size(); i++) {
        //     if ((tokens.get(i).equals(tokens.get(i - 1)))) {
        //         int count = words.lastElement().getCountYT();
        //         words.lastElement().setCountYT(count + 1);
        //     } else {
        //         words.add(new Word(tokens.get(i), 0, 1));
        //     }
        // }
        return tokens;
    }

    public void writeData(){
        Vector<String> tokens_YT1 = readTextFile("YT1.txt");
        Vector<String> tokens_PT1 = readTextFile("PT1.txt");
        Vector<Word> words = new Vector<Word>();


        try {
            FileWriter fw = new FileWriter("debug1.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < words.size(); i++) {
                pw.println(words.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Cannot write to file");
        }
    }
}
