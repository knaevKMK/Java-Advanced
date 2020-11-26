package genericScale;

import java.util.Comparator;
import java.util.Scanner;

public class Scale<Type extends Comparable<Type>> {
    private Type left;
    private Type right;

    public Scale(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    public Type getHeavier() {

        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        }
        if (this.left.compareTo(this.right) < 0) {
            return this.right;
        }
        return null;
    }


}
