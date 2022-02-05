public class MyArray<T> {

    private Object[] array;
    private int size = 0;

    public MyArray() {
        this.array = new Object[10];
    }

    public void add(T element) {
        // check if there is space for the element, increase length if not
        if (size >= array.length) {
            increaseArray();
        }

        // copy into array, and increment the size
        array[size] = element;
        size++;
    }

    public void add(int index, T element) {
        if (index > size) throw new IndexOutOfBoundsException("You cannot add an element beyond the current size");
        if (index < 0) throw new IndexOutOfBoundsException("You cannot add an element to a negative index");

        // check if there is space for the element, increase length if not
        if (size >= array.length) {
            increaseArray();
        }

        // move the elements one back, to make space for the new element,
        // at the given index
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }

        // copy into array, and increment the size
        array[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index > size) throw new IndexOutOfBoundsException("You cannot remove an element from beyond the current size");
        if (index < 0) throw new IndexOutOfBoundsException("You cannot remove an element from a negative index");

        // move the elements one forward from the index, overwriting the element.
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        // decrement the size
        size--;
    }

    public void clear() {
        // reset the array and size, effectively clearing the array
        this.array = new Object[10];
        this.size = 0;
    }

    public void increaseArray() {
        // create new array, larger than the old
        Object[] array2 = new Object[array.length + 10];

        // copy the old array into the new array
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }

        // move pointer to new array
        array = array2;
    }

    public T get(int index) {
            return (T) array[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        //make and populate array
        MyArray<Integer>  array = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        // print original array
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

        // add element and print again
        array.add(1, 5);

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

        // remove element and print
        array.remove(5);

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }

        // clear the array and print (should be empty line)
        array.clear();

        System.out.println();
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i));
        }
    }
}
