package customList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Data<E extends Comparable<E>> {
    private List<E> list;

    public Data() {
        this.list = new ArrayList<>();
    }

    public void add(E elemnt) {
        this.list.add(elemnt);
    }

    public void remove(int index) {
        checkvalid(index);
        this.list.remove(index);
    }

    public boolean contains(E element) {
        return this.list.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        checkvalid(indexOne);
        checkvalid(indexTwo);
        E temp = this.list.get(indexOne);
        this.list.set(indexOne, this.list.get(indexTwo));
        this.list.set(indexTwo, temp);
    }

    public int countGreaterThan(E element) {
        return (int) this.list.stream()
                .filter(e -> e.compareTo(element) > 0).count();
    }

    public E getMax() {
        valiDList();
        return this.list.stream().max(Comparator.naturalOrder()).get();
    }

    private void valiDList() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
    }

    public E getMin() {
        valiDList();
        return this.list.stream().min(Comparator.naturalOrder()).get();
    }

    private void checkvalid(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        this.list
                // .stream()
                //.sorted(Comparator.reverseOrder())
                .forEach(e -> print.append(e).append(System.lineSeparator()));
        return print.toString();
    }

    public int size() {
        return this.list.size();
    }

    public E get(int i) {
        return this.list.get(i);
    }
}
