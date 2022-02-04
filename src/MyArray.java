import java.lang.reflect.Array;

public class MyArray<T> {

    private Object[] array;
    private int size = 0;

    public MyArray() {
        this.array = new Object[10];
    }

    public void add(T element) {
        if (size >= array.length) {
            increaseArray();
        }
        array[size] = element;
        size++;
    }

    public void add(int index, T element) {
        if (size >= array.length) {
            increaseArray();
        }

        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void increaseArray() {
        Object[] array2 = new Object[array.length + 10];

        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public static void main(String[] args) {
        MyArray<Integer>  array = new MyArray<>();

        for (int i = 0; i < 1000; i++) {
            array.add(i);
        }

        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

        array.add(1, 5);

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

    }
}
