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

        ExecutionTimeForSorting Sort = new ExecutionTimeForSorting();


        System.out.println("Original array:");
        Sort.printArray(oneHundred);

        //100,000 bubble

        long startBubbleOne = System.nanoTime();

        System.out.println("\nAfter bubble sort:");
        Sort.printArray(new bubbleSort().sort(oneHundred));

        long endBubbleOne = Sort.endTime();

        System.out.println("\nExecution time for bubble sort: " + Sort.calcTime(startBubbleOne, endBubbleOne) + "\n");

/*

        //300,000 bubble
        long startBubbleThree = Sort.startTime();
        Sort.printArray(new bubbleSort().sort(threeHundred));
        long endBubbleThree = Sort.endTime();

        System.out.println("\nExecution time for bubble sort: " + Sort.calcTime(startBubbleThree, endBubbleThree) + "\n");

*/


        long startSelectOne = System.nanoTime();
        new selectionSort().sort(oneHundred);
        long endSelectOne = System.nanoTime();
        System.out.println("\nExecution time for selection sort: " + Sort.calcTime(startSelectOne, endSelectOne) + "\n");

/*
        long startSelectThree = System.nanoTime();
        new selectionSort().sort(threeHundred);
        long endSelectThree = System.nanoTime();
        System.out.println("\nExecution time for selection sort: " + Sort.calcTime(startSelectThree, endSelectThree) + "\n");
*/

        long strInsOne = System.nanoTime();
        new insertionSort().sort(oneHundred);
        long endInsOne = System.nanoTime();
        System.out.println("\nExecution time for insertion sort: " + Sort.calcTime(strInsOne, endInsOne) + "\n");

/*
        long strInsThree = System.nanoTime();
        new insertionSort().sort(threeHundred);
        long endInsThree = System.nanoTime();
        System.out.println("\nExecution time for insertion sort: " + Sort.calcTime(strInsThree, endInsThree) + "\n");
*/
        long strMerOne = System.nanoTime();
        new mergeSort().mergeSort(oneHundred, 0, oneHundred.length-1);
        long endMerOne = System.nanoTime();
        System.out.println("\nExecution time for merge sort: " + Sort.calcTime(strMerOne, endMerOne) + "\n");
/*
        long strMerThree = System.nanoTime();
        new mergeSort().mergeSort(threeHundred, 0, threeHundred.length-1);
        long endMerThree = System.nanoTime();
        System.out.println("\nExecution time for merge sort: " + Sort.calcTime(strMerThree, endMerThree) + "\n");

        long strQuiOne = System.nanoTime();
        new quickSort().sort(oneHundred, 0, oneHundred.length-1);
        long endQuiOne = System.nanoTime();
        System.out.println("\nExecution time for quick sort: " + Sort.calcTime(strQuiOne, endQuiOne) + "\n");

        long strQuiThree = System.nanoTime();
        new quickSort().sort(threeHundred, 0, threeHundred.length-1);
        long endQuiThree = System.nanoTime();
        System.out.println("\nExecution time for quick sort: " + Sort.calcTime(strQuiThree, endQuiThree) + "\n");
*/
        long strRadOne = System.nanoTime();
        new radixSort().bucketSort(oneHundred, 1);
        long endRadOne = System.nanoTime();
        System.out.println("\nExecution time for radix sort: " + Sort.calcTime(strRadOne, endRadOne) + "\n");
/*
        long strRadThree = System.nanoTime();
        new radixSort().bucketSort(threeHundred, 1);
        long endRadThree = System.nanoTime();
        System.out.println("\nExecution time for radix sort: " + Sort.calcTime(strRadThree, endRadThree) + "\n");
*/
    }
}


//                    <!-- bubble mergeSort algorithm -- >



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

//                    <!-- selection mergeSort algorithm -- >



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





//                    <!-- insertion mergeSort algorithm -- >

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


//                    <!-- merge mergeSort algorithm -- >
class mergeSort {
    void merge(int[] array, int start, int mid,  int end) {

        //stores the starting position of both parts in temporary variables
        int[] tempLeft = new int[mid-start+1];
        int[] tempRight = new int[end-mid];
        for (int i = start ; i < mid-start+1; i++) {
            tempLeft[i] = array[start+i];
        }
        for (int i = mid+1; i < end-mid; i++) {
            tempRight[i] = array[mid+start+i];
        }

        int x=0, y=0, z=start;
        while(x <mid-start+1 && y < end-mid) {
            if (tempLeft[x] <= tempRight[y]) {
                array[z++]=tempLeft[x++];
            } else {
                array[z++]=tempRight[y++];
            }
        }

        while (x < mid-start+1) {
            array[z++] = tempLeft[x++];
        }

        while (y < end-mid) {
            array[z++] = tempRight[y++];
        }
    }

    void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;

            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);

            merge(array,start,mid,end);
        }
    }
}


/**Quick Sort**/

class quickSort {
    int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = low-1;
        for (int j = low; j < high ; j++) {
            if (array[j] <= pivot) {
                int temp = array[++i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int partition = partition(arr, low, high);

            sort(arr, low, partition-1);
            sort(arr, partition+1, high);
        }
    }
}

/**Radix Sort**/
class  radixSort {

    public int max(int[] array) {
        // Find the maximum number in the array
        int maxNum = array[0];
        for (int i=1; i<array.length; i++)
            if (array[i] > maxNum) maxNum = array[i];
        return maxNum;
    }

    public void bucketSort(int[] list, int keyFactor) {
        // list is the original array, bucket is a 10-element array to group by digits 0-9
        int listSize = list.length;
        int[][] bucket = new int[10][listSize];
        int[] bucketSize = new int[10];
        for (int i=0; i<10; i++) bucketSize[i] = 0;

        // Distribute elements from list to buckets
        for (int i=0; i<list.length; i++) {
            //System.out.print("Num = " + list[i] + " ");				// for debugging only
            int key = (list[i] / keyFactor) % (10 * keyFactor);
            //System.out.print("Key = " + key + " ");					// for debugging only
            int index = bucketSize[key];
            bucket[key][index++] = list[i];
            bucketSize[key]++;
        }

        // Now move the elements from the buckets back to list
        int k = 0;
        for (int i=0; i<bucket.length; i++)
            for (int j=0; j<bucketSize[i]; j++)
                list[k++] = bucket[i][j];
    }
}