public interface SortedList<T extends Comparable<T>> {

    boolean add(T item); /** add declaration in interface **/

    Comparable<T> remove(int pos) throws Exception; /** remove declaration in interface **/

    Comparable<T> get(int pos) throws Exception; /** get declaration in interface **/

    int size(); /** size declaration in interface **/

}