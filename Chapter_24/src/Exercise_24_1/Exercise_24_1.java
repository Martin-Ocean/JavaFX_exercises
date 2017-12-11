package Exercise_24_1;

import java.util.*;

public class Exercise_24_1 {
    public static void main(String[] args) {
        new Exercise_24_1.Exercise_24_1();
    }

    public Exercise_24_1() {

    String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
    String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
    String[] name3 = {"Tom", "Peter"};

    /*
        Scanner input = new Scanner(System.in);
        String[] name1 = new String[5];
        String[] name2 = new String[5];
        String[] name3 = new String[2];
        System.out.print("Enter five strings for array name1 separated by space: ");
        for (int i = 0; i < 5; i++) {
            name1[i] = input.next();
        }

        System.out.print("Enter five strings for array name2 separated by space: ");
        for (int i = 0; i < 5; i++) {
            name2[i] = input.next();
        }

        System.out.print("Enter two strings for array name2 separated by space: ");
        for (int i = 0; i < 2; i++) {
            name3[i] = input.next();
        }
        */

        MyList<String> list1 = new MyArrayList<>(name1);
        MyList<String> list2 = new MyArrayList<>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.addAll(list2);
        System.out.println("After addAll:" + list1 + "\n");

        list1 = new MyArrayList<>(name1);
        list2 = new MyArrayList<>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.removeAll(list2);
        System.out.println("After removeAll:" + list1 + "\n");

        list1 = new MyArrayList<>(name1);
        list2 = new MyArrayList<>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.retainAll(list2);
        System.out.println("After retainAll:" + list1 + "\n");

       /*
        list1 = new MyArrayList<>(name1);

        list2 = new MyArrayList<>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.retainAll(list2);
        System.out.println("list1 contains all list2? " + list1.containsAll(list2) + "\n");

        list1 = new MyArrayList<>(name1);
        list2 = new MyArrayList<>(name3);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println("list1 contains all list2? " + list1.containsAll(list2) + "\n");

        Object[] name4 = list1.toArray();
        System.out.print("name4: ");
        for (Object e: name4) {
            System.out.print(e + " ");
        }

        String[] name5 = new String[list1.size()];
        String[] name6 = list1.toArray(name5);
        System.out.print("\nname6: ");
        for (Object e: name6) {

            System.out.print(e + " ");
        }
        */
    }

    public abstract static class MyAbstractList<E> implements MyList<E> {
        protected int size = 0;

        /**
         *  Create a default list
         */
        protected MyAbstractList() {
        }

        /**
         * Create a list from an array of objects
         * @param objects
         */
        protected MyAbstractList(E[] objects) {
            for (E object : objects) add(object);
        }


        /**
         *
         * @return true if the list is empty
         */
        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int lastIndexOf(E e) {
            return 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void add(E e) {
            add(size, e);
        }

        @Override
        public void add(int index, E e) {

        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(E e) {
            return false;
        }

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public int indexOf(E e) {
            return 0;
        }

        @Override
        public boolean remove(E e) {
            if (indexOf(e) >= 0) {
                remove(indexOf(e));
                return true;
            }
            return false;
        }

        @Override
        public E remove(int index) {
            return null;
        }

        @Override
        public Object set(int index, E e) {
            return null;
        }

        @Override
        public boolean addAll(MyList<E> otherList) {
            boolean change = false;
            otherList.forEach(item -> this.add(item));
            return (size() != size);
        }

        @Override
        public boolean removeAll(MyList<E> otherList) {
            int size = size();
            otherList.forEach(item -> this.remove(item));
            return (size() != size);
        }

        @Override
        public boolean retainAll(MyList<E> otherList) {
            int size = size();
            this.forEach(item -> {
                if (!otherList.contains(item)) remove(item);
            });
            return size() != size;
        }

    }

    public static class MyArrayList<E> extends MyAbstractList<E> {
        public static final int INITIAL_CAPACITY = 16;
        private E[] data = (E[]) new Object[INITIAL_CAPACITY];

        /** Create a defalut list */
        public MyArrayList() {
        }

        /** Create a list from an array of objects */
        public MyArrayList(E[] objects) {
            for (int i = 0; i < objects.length; i++)
                add(objects[i]); // Warning: don't use super(objects)!
        }

        @Override /** Add a new element at the specified index */
        public void add(int index, E e) {
            ensureCapacity();

            // Move the elements to the right after the secified index
            for (int i = size - 1; i >= index; i--)
                data[i + 1] = data[i];

            // Insert new element to data[index]
            data[index] = e;

            // Increase size by 1
            size++;
        }

        /** Create a new larger array, double the current size + 1 */
        private void ensureCapacity() {
            if (size >= data.length) {
                E[] newData = (E[])(new Object[size * 2 + 1]);
                System.arraycopy(data, 0, newData, 0, size);
                data = newData;
            }
        }

        @Override /** Clear the list */
        public void clear() {
            data = (E[])new Object[INITIAL_CAPACITY];
            size = 0;
        }

        @Override /** Return true if this list contains the element */
        public boolean contains(E e) {
            for (int i = 0; i < size; i++)
                if (e.equals(data[i])) return true;

            return false;
        }

        @Override /** Return the element at the specified index */
        public E get(int index) {
            checkIndex(index);
            return data[index];
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException
                        ("index " + index + " out of bounds");
        }

        @Override /** Return the index of the first matching element
         *	in this list. Return -1 if no match. */
        public int indexOf(E e) {
            for (int i = 0; i < size; i++)
                if (e.equals(data[i])) return i;

            return -1;
        }

        @Override /** Return the index of the last matching element
         *	in this list. Return -1 if no match. */
        public int lastIndexOf(E e) {
            for (int i = size - 1; i >= 0; i--)
                if (e.equals(data[i])) return i;

            return -1;
        }

        @Override /** Remove the element at the specified position
         * in this list. Shift any subsequent element to the left.
         * Return the element that was removed from the list. */
        public E remove(int index) {
            checkIndex(index);

            E e = data[index];

            // Shift data to the left
            for (int j = index; j < size - 1; j++)
                data[j] = data[j + 1];

            data[size - 1] = null; // This element is now null

            // Decrement size
            size--;

            return e;
        }

        @Override /** Replace the element at the specified position
         * in this list with the spcified element. */
        public E set(int index, E e) {
            checkIndex(index);
            E old = data[index];
            data[index] = e;
            return old;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[");

            for (int i = 0; i < size; i++) {
                result.append(data[i]);
                if (i < size - 1) result.append(", ");
            }

            return result.toString() + "]";
        }

        /** Trims the capacity to current size */
        public void trimToSize() {
            if (size != data.length) {
                E[] newData = (E[])(new Object[size]);
                System.arraycopy(data, 0, newData, 0, size);
                data = newData;
            } // If size === capacity, no need to trim
        }

        @Override /** Override iterator() defined in Iterable */
        public Iterator<E> iterator() {
            return new ArrayListIterator();
        }

        private class ArrayListIterator
                implements Iterator<E> {
            private int current = 0; // Current index

            @Override
            public boolean hasNext() {
                return (current < size);
            }

            @Override
            public E next() {
                return data[current++];
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(current);
            }
        }
    }

    public static interface MyList<E> extends Iterable<E>{

        /**
         *  Adds a new element at the end of this list
         * @param e
         * @return null
         */
        public void add(E e);

        /**
         *  Adds a new element att he specified index in this list
         * @param index
         * @return null
         */
        public void add(int index, E e);

        /**
         * Clear this list
         */
        public void clear();

        /**
         * Check if item exists in the list
         * @param e
         * @return true if this list contains the element
         */
        public boolean contains(E e);

        /**
         *
         * @param index
         * @return return the element from this list at the specified index
         */
        public E get(int index);

        /**
         *
         * @param e
         * @return the index of the first matching element in this list.
         * return -1 if no match
         */
        public int indexOf(E e);

        /**
         *
         * @return true if the list is empty
         */
        public boolean isEmpty();

        /**
         *
         * @param e
         * @return the index of the last matching element in this list
         * -1 if no match
         */
        public int lastIndexOf(E e);

        /**
         * remove  the first occurrence of the element e from this list.
         * shift any subsequent elements to the left.
         * @param e
         * @return true if the element is removed.
         */
        public boolean remove(E e);

        /**
         * Remove the element at the specified position in this list.
         * Shift any subsequent elements to the left
         * @param index
         * @return the element that was removed from the list
         */
        public E remove(int index);

        /**
         * Replace the element at the specified position in this list with the specified element
         * @param index
         * @param e
         * @return the old element
         */
        public Object set(int index, E e);

        /**
         *
         * @sdfsdfsasdasdreturn the number of elements in this list
         */
        public int size();

        /**
         * Adds the elements in otherList to this list
         * @param otherList
         * @return true if this list changed as a result of the call
         */
        public boolean addAll(MyList<E> otherList);

        /**
         * Removes All the elements in otherList from this list
         * @param otherList
         * @return true of this list changed as a result of the call
         */
        public boolean removeAll(MyList<E> otherList);

        /**
         * Retains the elements in this list that are also in otherList
         * @param otherList
         * @return true if this list changed as a result of the call
         */
        public boolean retainAll(MyList<E> otherList);

    //    /**
    //     *
    //     * @param otherList
    //     * @return true if this list contains all elements from otherList
    //     */
    //    public boolean containsAll(MyList<E> otherList);
    //
    //    public boolean toArray();

    }
}