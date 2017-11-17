package Exercise_19_5;

public class MaximumElementInAnArray {
    public static <E extends Comparable<E>> E max(E[] list) {
        int temp = 0;
        if (list.length != 0) {
            for (int i = 0; i < list.length; i++) {
                if (list[temp].compareTo(list[i])<0)temp = i;
            }
        }

        return list[temp];
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"Compares","object","negative","the","object","the","zero","integer","positive","integer"};
        Integer[] integers = new Integer[]{new Integer(5),new Integer(8),new Integer(10),new Integer(7),new Integer(2),new Integer(4),new Integer(5),new Integer(9),new Integer(8),new Integer(2)};
        Double[] doubles = new  Double[]{new Double(10.3),new Double(1.3),new Double(6.88),new Double(6.68),new Double(6.66),new Double(6.88),new Double(8.88),new Double(8.88),new Double(1.3),new Double(10.3)};

        System.out.printf("\nMax string is: %s", max(strings));
        System.out.printf("\nMax integer is: %d", max(integers));
        System.out.printf("\nMax double is: %f", max(doubles));

    }
}
