package arrayCreator;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(3, "none");
        Integer[] integers = ArrayCreator.create(5, 2);
        Double[] doubles = ArrayCreator.create(5, 2.2);

        String[] string = ArrayCreator.create(String.class, 10, "none");
        Integer[] integer = ArrayCreator.create(Integer.class, 5, 2);
        Double[] doublE = ArrayCreator.create(Double.class, 5, 2.2);

    }

}
