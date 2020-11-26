package customList;

import java.util.List;

public class Sorter<E extends Comparable<E>> {
    public static void sort(Data data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i).compareTo(data.get(j)) > 0) {
                    data.swap(i, j);
                }
            }
        }
    }


}
