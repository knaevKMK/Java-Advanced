import java.io.*;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Serialization
        List<Double> list = List.of(1.1, 2.2, 3.3, 4.4, 5.5);// e t.c.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/list.ser"));
        oos.writeObject(list);
        oos.close();

// De- serialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/list.ser"));
        List<Double> newList = (List<Double>) in.readObject();
        for (Double aDouble : newList) {
            System.out.println(aDouble);// what ever
        }
    }
}
