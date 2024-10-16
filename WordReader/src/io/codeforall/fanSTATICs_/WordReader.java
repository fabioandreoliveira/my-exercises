package io.codeforall.fanSTATICs_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    private String text;
    private String[] words;

    public WordReader(String text) {
        this.text = text;
        try {
            this.readFile(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String readFile(String file) throws IOException {

        FileReader fReader = new FileReader(file);

        BufferedReader bReader = new BufferedReader(fReader);

        String line = "";
        String result = "";

        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

        bReader.close();
        this.words= result.split(" ");
        return result;
    }

    @Override
    public Iterator<String> iterator() {
      return Arrays.stream(this.words).iterator();
    }
}
