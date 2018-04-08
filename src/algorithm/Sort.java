package algorithm;

public class Sort {

    static long executionTime = 0;

//Selection Sort
    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[j]<array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }

        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        System.out.println(list);
        return list;
    }

    //Insertion Sort

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here

            int in, out;
            for(out=1; out<array.length; out++) // out is dividing line
            {
                int temp = array[out]; // remove marked item
                in = out; // start shifts at out
                while(in>0 && array[in-1] >= temp) // until one is smaller,
                {
                    array[in] = array[in-1]; // shift item to right
                    --in; // go left one position
                }
                array[in] = temp; // insert marked item
            } // end for

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }  // end insertionSort()

    //Bubble Sort

    public int[] bubbleSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here

            int out, in;
            for(out=array.length-1; out>1; out--) // outer loop (backward)
                for(in=0; in<out; in++) // inner loop (forward)
                    if( array[in] > array[in+1] ) // out of order?
                    {
                        int temp = array[in];
                        array[in] = array[in + 1];
                        array[in + 1] = temp;
                    }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;

    } // end bubbleSort()


//Merge Sort

public  void MergeSort(int[] array) {
    if (array.length > 1) {
        // split array into two halves
        int[] left = leftHalf(array);
        int[] right = rightHalf(array);

        // recursively sort the two halves
        MergeSort(left);
        MergeSort(right);

        // merge the sorted halves into a sorted whole
        merge(array, left, right);
    }

}

    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }


    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public  void merge(int[] result,
    int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }


//Quick Sort

    public int [] quickSort(int [] array, int low, int high){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        if(low < high){
            int next = partition(array, low, high);
            quickSort(array, low, next-1);
            quickSort(array, next+1, high);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int partition(int array[], int p, int r){
        int part = p-1;
        int pivot = array[r];
        for(int i=p; i <= r; i++){
            if(array[i] <= pivot){
                part++;
                if(part != i){
                    array[part] = array[part] ^ array[i];
                    array[i] = array[part] ^ array[i];
                    array[part] = array[part] ^ array[i];
                }
            }
        }
        return part;
    }

    //Heap Sort


    public int [] heapSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        buildHeap(array);
        for(int i = array.length-1; i>=1; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    public void buildHeap(int[] array){
        for(int i=array.length/2-1; i >= 0; i--){
            heapify(array, array.length, i);
        }
    }
    public void heapify(int[] array, int n, int i){
        int max;
        int child;
        child = 2 * i + 1;
        max = i;
        if(child < n){
            if(array[child] > array[max]){
                max = child;
            }
            if(child+1 < n){
                if(array[child + 1] > array[max]){
                    max = child + 1;
                }
            }
            if(max != i){
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
                heapify(array, n, max);
            }
        }
    }

//Bucket Sort


    public int [] bucketSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int maxVal = getMax(array);
        int[] bucket = new int[maxVal+1];
        for(int i=0; i<bucket.length; i++){
            bucket[i] = 0;
        }
        for(int i=0; i<array.length; i++){
            bucket[array[i]]++;
        }
        int outPos = 0;
        for(int i=0; i<bucket.length; i++){
            for(int j=0; j<bucket[i]; j++){
                array[outPos++] = i;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int getMax(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

//Shell Sort

    public int [] shellSort(int [] array){
        int [] list = array;
        //implement here
           int inner, outer;
            int temp;
            int h = 1; // find initial value of h
            while(h <= array.length/3)
                h = h*3 + 1; // (1, 4, 13, 40, 121, ...)
            while(h>0) // decreasing h, until h=1
            {
// h-sort the file
                for(outer=h; outer<array.length; outer++)
                {
                    temp = list[outer];
                    inner = outer;
// one subpass (eg 0, 4, 8)
                    while(inner > h-1 && list[inner-h] >= temp)
                    {
                        list[inner] = list[inner-h];
                        inner -= h;
                    }
                    list[inner] = temp;
                } // end for
                h = (h-1) / 3; // decrease h
            } // end while(h>0)
        return list;
    } // end shellSort()
        



    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);


        }


    }


}
