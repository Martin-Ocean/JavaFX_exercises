package Exercise_19_4;

public class GenericLinearSearch {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String[] strings = new String[]{"Compares","object","negative","the","object","the","zero","integer","positive","integer"};
        Integer[] integers = new Integer[]{new Integer(5),new Integer(8),new Integer(10),new Integer(7),new Integer(2),new Integer(4),new Integer(5),new Integer(9),new Integer(8),new Integer(2)};
        Double[] doubles = new  Double[]{new Double(10.3),new Double(1.3),new Double(6.88),new Double(6.68),new Double(6.66),new Double(6.88),new Double(8.88),new Double(8.88),new Double(1.3),new Double(10.3)};


        System.out.printf("\nMatching string is found at: %d", linearSearch(strings, new String("object")));
        System.out.printf("\nMatching integer is found at: %d", linearSearch(integers, new Integer(2)));
        System.out.printf("\nMatching double is found at: %d", linearSearch(doubles, new Double(1.3)));
    }
}
