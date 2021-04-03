public class SortedArrayList<T extends  Comparable<T>> implements SortedList<T> {

    protected int size;
    protected T[] arr;

    public SortedArrayList() /** Constructor for SortedArrayList class **/
    {
        arr = (T[]) new Comparable[0];
        size = 0;
    }

    public String toString() { /** toString method to print as a string **/
        String list = "[ ";
        for (int i = 0; i < size; i++) {
            list += arr[i] + "," ;
        }
        list += " ]";
        return list;
    }

    private void growArray() { /** growArray to increase size of array by needed amount **/
        T [] a;
        if (size == 0) {
            a = (T[]) new Comparable[1];
        } else {
            a = (T[]) new Comparable[arr.length * 2];
        }
        for (int i = 0; i < size; i++) {
            a[i] = arr[i];
        }
        arr = a;
    }

    private void move(int pos) { /** move allows the items to move over by 1 index **/
        if (size + 1 == arr.length) {
            growArray();
        }
        for (int i = size - 1; i >= pos; i--){
            arr[i + 1] = arr[i];
        }
    }

    @Override
    public boolean add(T item) { /** from interface, add method **/
        if (size + 1 >= arr.length)
            growArray(); /** calls growArray when adding to facilitate more space when needed**/
        if (size == 0) {
            arr[0] = item;
        }

        for (int i = 0; i <= size; i++) {
            if (arr[i] == null) {
                growArray();
                arr[i] = item;
                size++;
                return true;
            } else if (arr[i].compareTo(item) > 0) {
                move(i);
                arr[i] = item;
                size++;
                return true;
            }
        }
        size++;
        return false;
    }

    @Override
    public Comparable<T> remove(int pos) { /** from interface, remove method**/
        if (pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Comparable<T> item = arr[pos];
        for (int i = pos; i <= size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public Comparable<T> get(int pos) { /** from interface, get method **/
        if (pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[pos]; /** returns item at that pos**/
    }

    @Override
    public int size() { /** from interface, size method **/
        return size;
    }
}