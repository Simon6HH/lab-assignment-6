public class SortedLinkedList<T extends Comparable<T>> implements SortedList {


    class Node<T extends Comparable<T>> { /** Node declaration for linekdlist **/
        Comparable data;
        Node next = null;
        public Node(Comparable data) {
            this.data = data;
        }
    }

    Node head;
    int size;

    public SortedLinkedList() { /** constructor for class **/
        head = null;
        size = 0;
    }

    public String toString() { /** toString method to print string **/
        String list = "[ ";
        Node node = head;
        try {
            while (node != null) { /** checks if null is null **/
                list += node.data + " ";
                node = node.next;
            }
        } catch (Exception e) {
            System.out.println("Null"); /** exception in case the linkedlist is null **/
        }
        list += " ]";
        return list;
    }

    @Override
    public boolean add(Comparable item) { /** from interface, add method **/
        Node node = new Node(item);
        Node previous = head;
        if (head == null) {
            head = node;
            size++;
            return true;
        }
        for (int i = 0; i < size -1; i++) {
            if (previous.next.data.compareTo(item) > 0) {
                node.next = previous.next;
                previous.next = node;
                size++;
                return true;
            }
            previous = previous.next;
        }
        if (size == 1) {
            node.next = head;
            head = node;
        } else {
            previous.next = node;
        }
        size++;
        return true;
    }

    @Override
    public Comparable remove(int pos) { /** from interface, remove method **/
        Node remove;
        Node previous = head;
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            remove = head;
            head = head.next;
            size--;
            return remove.data; /** removes node if pos is 0 **/
        }

        for (int i = 0; i < pos - 1; i++) {
            previous = previous.next;
        }
        remove = previous.next;
        previous.next = remove.next;
        size--;
        return remove.data;
    }

    @Override
    public Comparable get(int pos) { /** from interface, get method **/
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < pos-1; i++) {
            node = node.next;
        }
        return node.next.data;
    }

    @Override
    public int size() { /** from interface, size method **/
        return size;
    }
}