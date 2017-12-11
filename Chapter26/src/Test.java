import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Tree<Double> BSTree;
        Double[] numbers;
        ArrayList<Double> nums = new ArrayList<>();

        for (int i = 0; i < 500000; i++) {
            nums.add(new Double(random()));
        }


        Collections.shuffle(nums);
        numbers = nums.toArray(new Double[nums.size()]);
        BSTree = new BST<>(numbers);
        Long bstBegin = System.nanoTime();
        BSTree.search(new Double(10));
        Long bstEnd = System.nanoTime();
        System.out.printf("BST search took: %f seconds.", (bstEnd-bstBegin)/100000.0 );

        Collections.shuffle(nums);
        numbers = nums.toArray(new Double[nums.size()]);
        BSTree = new AVLTree<>(numbers);
        Long avlBegin = System.nanoTime();
        BSTree.search(new Double(10));
        Long avlEnd = System.nanoTime();
        System.out.printf("\nAVL search took: %f seconds.", (avlEnd-avlBegin)/100000.0);
    }





    static Double random () {
        Double num;
        do {
            num = Math.random() * Math.pow(10.0, Math.random());
        } while(num > Math.pow(10, 10.0));
        return num;
    }
}
