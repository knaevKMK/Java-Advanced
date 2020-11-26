package jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T elemnt) {
        this.content.push(elemnt);
    }

    public T remove() {
        return this.content.pop();
    }

}
