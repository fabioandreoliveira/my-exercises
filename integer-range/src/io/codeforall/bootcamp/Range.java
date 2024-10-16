package io.codeforall.bootcamp;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Integer range iterator
 */
public class Range implements Iterable<Integer> {

    private int min;
    private int max;
    private boolean forward;

    private boolean[] removed;


    public Range(int min, int max) {
        this.min = min;
        this.max = max;
        this.forward = true;
        //The size of array is +1 to be inclusive of both min and max
        removed = new boolean[max - min + 1];
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }
    public boolean getForward(){
        return this.forward;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (forward) {
            return new Iterator<Integer>() {
                private int current = min - 1;

                @Override
                public boolean hasNext() {
                    while (removedContains(current + 1)) {
                        current++;
                    }

                    return current < max;
                }

                @Override
                public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }

                    current++;
                    return current;
                }

                private boolean removedContains(int current) {
                    // First we need to check if the current number above the max value
                    return current <= max && removed[current - min];
                }

                @Override
                public void remove() {

                    // if you try to remove an element before calling next(), you will get a runtime exception (see Iterable:remove() description)
                    if (current < min) {
                        throw new IllegalStateException("You need to call next() at least once to remove an element.");
                    }

                    // if you try to call remove() consecutively you will get a runtime exception (see Iterable:remove() description)
                    if (removedContains(current)) {
                        throw new IllegalStateException("You cannot call remove() repeatedly");
                    }

                    removed[current - min] = true;
                }
            };
        }
        return new Iterator<Integer>() {
            private int current = max + 1;

            @Override
            public boolean hasNext() {

                while (removedContains(current + 1)) {
                    current--;
                }
                
                return current > min;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current--;
                return current;
            }

            private boolean removedContains(int current) {
                // First we need to check if the current number above the max value
                return current <= min && removed[current - min];
            }

            @Override
            public void remove() {

                // if you try to remove an element before calling next(), you will get a runtime exception (see Iterable:remove() description)
                if (current > min) {
                    throw new IllegalStateException("You need to call next() at least once to remove an element.");
                }

                // if you try to call remove() consecutively you will get a runtime exception (see Iterable:remove() description)
                if (removedContains(current)) {
                    throw new IllegalStateException("You cannot call remove() repeatedly");
                }

                removed[current - max] = true;
            }
        };
    }
}

