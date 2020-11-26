package listyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> data) {
        this.list = data;
        if (data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move() {
        if (this.index + 1 < this.list.size()) {
            this.index++;
            return true;
        }
        return false;
    }

    public String print() {
        if (this.index == -1) {
            return ("Invalid Operation!");
        }
        return (this.list.get(this.index));
    }

    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }

    public String printAll() {
        StringBuilder printAll = new StringBuilder();
        this.list.forEach(e -> printAll.append(e).append(" "));
        return printAll.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index<list.size();
            }

            @Override
            public String next() {
                return list.get(this.index++);
            }
        };
    }
}
