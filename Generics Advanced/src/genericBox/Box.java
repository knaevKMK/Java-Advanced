package genericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<E> {
    private List<E> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.list.add(element);
    }

    public void getValidate(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void swap(int indexOne, int indexTwo) {
        E swap = this.list.get(indexOne);

        this.list.set(indexOne, this.list.get(indexTwo));
        this.list.set(indexTwo, swap);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        this.list.forEach(e -> print.append(e.getClass().getName()).append(": ").append(e).append(System.lineSeparator()));
        return print.toString();

    }
}



