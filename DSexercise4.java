/* Given an unsorted array A of integers and an integer x, this method/function
finds and returna a pair of integers a, b in A such that a + b = x (if possible). Otherwise, it
function returns null. It O(n lg n)-time complexity.*/

public class exercise4 {
/*this is the main function which performs the operation , takes the array and the goal number
 it first sorts the array, then adds the smallest and biggest elements, if the sum is bigger
 than the goal, it takes the second biggest one, if smaller than the goal,
it takes the second smallest number, it continues until the pointer which points
 where we are at the beginning is smaller than the one which points where we 
are from the end*/
    public static int[] findNums(int[] intArray, int goal) {
        mergeSort(intArray);
        int[] A = new int[2];
        int i = 0, j = intArray.length - 1;
        while (i < j) {
            if (intArray[i] + intArray[j] == goal) {
                A[0] = intArray[i];
                A[1] = intArray[j];
                return A;
            } else if (intArray[i] + intArray[j] < goal)
                i++;
            else
                j--;
        }
//stores the result in an array, if we found it, returns the array, if not returns null
        if (A[0] + A[1] == goal) {
            return A;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        int[] intArray = new int[] {
            1,
            2,
            3,
            4,
            5,
            85,
            7,
            8,
            9,
            10
        };
        int goal = 12;

        int[] A = findNums(intArray, goal);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

/* this is the most classic mergeSort algorithm copied from the Java book
However, I will explain all the steps*/

/*This is the merge step of the MergeSort algorithm, it takes two sorted integers and
merges them, first it compares their first elements, if the one on left is smaller it gets to
be the the first element of the big array, we move the pointer on, if the one on right is the smaller
we move the pointer for the right on, for every comparison we increment the pointer of the big array*/
    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
  /*When we already reach to the point when all comparisons are done, but there are still elements
  in one of the left or right arrays, we simply add the left elements to the big array*/
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
/*This recursively divides the array into left and right sides, until the sides have less than 2 elements,
after which it does the merge operation on each small array. This step is logn time complexity*/
    public static void mergeSort(int[] inputArray) {
        int size = inputArray.length;
        //base case is when the size of the array is smaller than 2
        if (size < 2)
            return;
        //deciding the sizes of the arrays
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        //copying the array to two small ones
        for (int i = 0; i < mid; i++)
            left[i] = inputArray[i];
        for (int i = mid; i < size; i++)
            right[i - mid] = inputArray[i];
        //recursively sorting the the small ones
        mergeSort(left);
        mergeSort(right);
        //merging the sorted small parts
        merge(left, right, inputArray);
    }
}
