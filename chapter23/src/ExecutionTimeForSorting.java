import java.util.ArrayList;

public class ExecutionTimeForSorting {

    void printArray(int[] array) {
        for (int i = 0; i < 20; i++) {
            System.out.print(array[i] + " ");
        }
    }

    long startTime() {
        return System.nanoTime();
    }

    long endTime() {
        return System.nanoTime();
    }

    long calcTime(long time1, long time2) {
        return time2 - time1;
    }



    public static void main(String[] args) {

        int[] oneHundred = new int[100000];
        int[] threeHundred = new int[300000];

        // populate arrays
        for (int i = 0; i < oneHundred.length ; i++) {
            oneHundred[i] = (int) (Math.random() * 99 + 1);
        }

        for (int i = 0; i < threeHundred.length; i++) {
            threeHundred[i] = (int) (Math.random() * 99 + 1);
        }

        ExecutionTimeForSorting bubbleSort = new ExecutionTimeForSorting();
      //  ExecutionTimeForSorting selectionSort = new ExecutionTimeForSorting();
      //  ExecutionTimeForSorting insertionSort = new ExecutionTimeForSorting();
        System.out.println("Original array:");
        bubbleSort.printArray(oneHundred);

        //100,000 bubble

        long startBubbleOne = System.nanoTime();

        System.out.println("\nAfter bubble sort:");
        bubbleSort.printArray(new bubbleSort().sort(oneHundred));

        long endBubbleOne = bubbleSort.endTime();

        System.out.println("\nExecution time for bubble sort: " + bubbleSort.calcTime(startBubbleOne, endBubbleOne) + "\n");


        /*
        //300,000 bubble
        long startBubbleThree = bubbleSort.startTime();

        System.out.println("\nAfter bubble sort:");
        bubbleSort.printArray(new bubbleSort().sort(oneHundred));

        long endBubbleThree = bubbleSort.endTime();

        System.out.println("\nExecution time for bubble sort: " + bubbleSort.calcTime(startBubbleThree, endBubbleThree) + "\n");




        bubbleSort.printArray(new selectionSort().sort(oneHundred));
        bubbleSort.printArray(new insertionSort().sort(oneHundred));

*/
    }
}


//                    <!-- bubble sort algorithm -- >



class bubbleSort {
    int[] sort(int[] array) {

        boolean needNext = true;
        for (int i = 0; i < array.length-1 && needNext; i++) {
            needNext = false;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    needNext = true;
                }
            }

        }
        

        return array;
    }
}

//                    <!-- selection sort algorithm -- >



class selectionSort {
    int[] sort(int[] array)
    {
        for (int i = 0; i < array.length-1; i++) {
            int min_index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[min_index] > array[j]) {
                    min_index = j;
                }
            }

            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}





//                    <!-- insertion sort algorithm -- >

class insertionSort {
    int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            for (int j = i-1; j >= 0 && array[j] > key ; j--) {
                array[j+1] = array[j];
                array[j] = key;
            }
        }
        return array;
    }
}


//                    <!-- merge sort algorithm -- >
class mergeSort {
    void merge(int[] array, int start, int mid,  int end) {

        //stores the starting position of both parts in temporary variables
        int[] tempArray = new int[end-start+1];
        int s = start, e = mid+1, x=0;

        for (int i = start; i <= end ; i++) {

            //checks if first part comes to an end or not
            if (tempArray)
            //checks if second part comes to an end or not
            //checks which part has smaller element.
        }
        /* Now the real array has elements in sorted manner including both
        parts.*/
    }
}
