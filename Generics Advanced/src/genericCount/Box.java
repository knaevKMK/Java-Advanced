package genericCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<E extends Comparable<E>> {
    private List<E> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.list.add(element);
    }

    public void compare(E value) {
        if (this.list.isEmpty()) {
            throw new IndexOutOfBoundsException("Empty List");
        }
        this.list = this.list.stream()
                .filter(e -> e.compareTo(value) > 0).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "" + this.list.size();
    }
}
