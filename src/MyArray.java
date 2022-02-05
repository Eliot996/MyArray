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
        if (index > size) throw new IndexOutOfBoundsException("You cannot add an element beyond the current size");
        if (index < 0) throw new IndexOutOfBoundsException("You cannot add an element to a negative index");

        if (size >= array.length) {
            increaseArray();
        }

        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index > size) throw new IndexOutOfBoundsException("You cannot remove an element from beyond the current size");
        if (index < 0) throw new IndexOutOfBoundsException("You cannot remove an element from a negative index");

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void clear() {
        this.array = new Object[10];
        this.size = 0;
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

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyArray<Integer>  array = new MyArray<>();

        for (int i = 0; i < 10; i++) {
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

        array.remove(5);

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

        array.clear();

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }
    }
}
