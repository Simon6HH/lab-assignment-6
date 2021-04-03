import java.util.Random;

public class Test {

    SortedList<Integer> list;
    Random r = new Random();

    public Test(int i) {
        if (i == 1) {
            list = new SortedArrayList<>();
        } else if (i == 0){
            list = new SortedLinkedList<Integer>();
        }
    }

    public void Empty() {
        if (list.size() != 0)
            System.out.println(":SIZE IS NOT 0: ");
        try {
            if (list.size() != 0) {
                System.out.println(":CHECKING ERROR HANDLING: ");
            }
            list.get(10);
        } catch (Exception e) {
            System.out.println(":CHECKING EMPTY ERROR: ");
        }
        System.out.println(":EMPTY WORKS: ");
    }

    public void Add(int n) {
        Integer[] integer = new Integer[] {1, 2, 3, 4, 5};
        System.out.println (":ADDING TO LIST: ");
        for (int i = 0; i < n; i++) {
            Integer j = integer[r.nextInt(4)];
            list.add(j);
            System.out.println("SIZE: " + list.size());
        }
        System.out.println(":TESTING LIST: ");
        for (int j = 0; j < list.size(); j++) {
            try {
                System.out.println(list.get(j));
            } catch (Exception e) {
                System.out.println(":OUT OF BOUNDS: ");
            }
        }
        if (list.size() != n) {
            System.out.println(":LIST != SIZE: ");
        }
        System.out.println("LIST: " + list.toString());
        System.out.print(":ADD WORKS: ");
    }

    public void Order() {
        for (int i = 0; i < list.size() - 1; i++) {
            try {
                if (list.get(i).compareTo((Integer) list.get(i + 1)) > 0) {
                    System.out.println(":ORDER DOES NOT WORK: ");
                }
            } catch (Exception e) {
                System.out.println(":OUT OF BOUNDS: ");
            }
        }
        System.out.println(":ORDER WORKS: ");
    }

    public void Positions(int pos) {
        System.out.println(":TESTING WRONG POSITIONS: ");
        try {
            if (pos < 0 || pos >= list.size()) {
                list.get(10);
            }
        } catch (Exception e) {
            System.out.println(":GET OUT OF BOUNDS AT POS: ");
        } try {
            if (pos < 0 || pos >= list.size()) {
                list.remove(10);
            }
        } catch (Exception e) {
            System.out.println(":REMOVE OUT OF BOUNDS AT POS: ");
        }
    }

    public void Remove(int i) {
        SortedList<Integer> tmp = new SortedArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);
        System.out.println("BEFORE REMOVE: " + tmp.toString());
        try {
            System.out.println("RETURN REMOVE ITEM: " + tmp.remove(i));
        } catch (Exception e) {
            // nothing needed
        }
        System.out.println("AFTER REMOVE: " + tmp.toString());
    }

    public static void main(String[] args){
        Test aList = new Test(1);
        Test lList = new Test(0);

        System.out.println(" ------------ ARRAY TEST ------------");
        aList.Empty();
        System.out.println();
        aList.Add(4);
        System.out.println();
        aList.Order();
        System.out.println();
        aList.Positions(10);
        System.out.println();
        aList.Remove(2);

        System.out.println(" ------------ LINKED TEST ------------");
        lList.Empty();
        System.out.println();
        lList.Add(4);
        System.out.println();
        lList.Order();
        System.out.println();
        lList.Positions(10);
        System.out.println();
        lList.Remove(2);
    }
}