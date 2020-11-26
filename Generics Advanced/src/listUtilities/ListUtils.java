package listUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <Type extends Comparable<Type>> Type getMin(List<Type> list) {
        return list.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(IllegalAccessError::new);
    }

    public static <Type extends Comparable<Type>> Type getMax(List<Type> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
}
