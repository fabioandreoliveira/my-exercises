package io.codeforall.fanSTATICs_;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp extends HashMap<String, Integer> implements Iterable<String> {

    private String string;
    private String[] strings;
    private int count;
    public WordHistogramComp(String string){
        this.string = string;
        this.strings = string.split(" ");
        for (int i = 0; i < strings.length ; i++) {
            if (this.get(strings[i]) == null) {
                count = 1;
                this.put(strings[i], count++);
            }else {
                this.put(strings[i], count++);
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }

}
