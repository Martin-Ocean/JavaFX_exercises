package Exercise_19_3;

import java.util.ArrayList;

public class DistinctElementsArrayList {
    public static <E> void print (ArrayList <E> list) {
        System.out.println("");
        for (E item: list) {
            System.out.print(item + "  ");
        }
        System.out.printf("\nThis list contain %d elements\n", list.size());
    }
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> temp = new ArrayList<>();
        for (E item : list) {
            if (!temp.contains(item)) temp.add(item);
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList listTest = new ArrayList();
        listTest.add(2);
        listTest.add(2);
        listTest.add(3);
        listTest.add(2);
        listTest.add(5);
        ArrayList<Integer> list1 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list1.add(new Integer(i));
            for (int j = 0; j < 20; j++) {
                list1.add(new Integer(j));
            }
        }

        ArrayList<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list2.add(new Double(i));
            for (int j = 1; j < 3; j++) {
                list2.add(new Double((double)i/j));
            }
        }

        /** List Test (Integer) **/
        print(listTest);
        print(removeDuplicates(listTest));

        /** list1 (Integer) **/
        print(list1);
        print(removeDuplicates(list1));

        /** list2 (Double) **/
        print(list2);
        print(removeDuplicates(list2));

    }
}
