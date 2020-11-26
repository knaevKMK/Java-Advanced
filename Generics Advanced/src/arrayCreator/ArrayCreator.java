package arrayCreator;

import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int lenght, T item) {
        T[] array = (T[]) Array.newInstance(item.getClass(), lenght);
        for (int i = 0; i < lenght; i++) {
            array[i] = item;
        }
        return array;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int lenght, T item) {
        T[] array = (T[]) Array.newInstance(clazz, lenght);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}
