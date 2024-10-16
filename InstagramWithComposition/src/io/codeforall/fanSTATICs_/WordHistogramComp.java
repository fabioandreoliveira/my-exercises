package io.codeforall.fanSTATICs_;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogramComp implements Iterable<String> {

    private String name;
    private HashMap<String, Integer> map;
    private String[] nameArray;
    private int count;

    public WordHistogramComp(String name) {
        this.name = name;
        this.map = new HashMap<>();
        this.nameArray = name.split(" ");
        for (int i = 0; i < nameArray.length; i++) {
            if (map.get(nameArray[i]) == null) {
                count = 1;
                map.put(nameArray[i], count++);
            } else {
                map.put(nameArray[i], count++ );
            }
        }
    }

    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    public int size() {
        return this.map.size();
    }

    public Integer get(String word) {
        return map.get(word);
    }
}
