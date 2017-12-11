package Exercise_24_4;

public class GenericStack_Prime_Number {
    public static void main(String[] args) {
        GenericStack<Integer> nums = new GenericStack<>();

        for (int i = 2; i < 51 ; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i/2; j++) {
                if (i%j==0) isPrime = false;
            }

            if (isPrime) nums.push(i);
        }


        while (true) {
            if (!nums.isEmpty()) System.out.println(nums.pop());
        }
    }

    public static class GenericStack<E> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();

        public int getSize() {
            return list.size();
        }

        public E peek() {
            return list.get(getSize() - 1);
        }

        public void push(E o) {
            list.add(o);
        }

        public E pop() {
            E o = list.get(getSize() - 1);
            list.remove(getSize() - 1);
            return o;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public String toString() {
            return "stack: " + list.toString();
        }
    }
}
