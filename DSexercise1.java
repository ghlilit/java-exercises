/*Computes the product of the first k positive integers in an array of integer values*/

import java.util.*;
public class exercise1 {
    public static void main(String[] args) {
        int[] arr = new int[] {
            1,
            -8,
            8,
            4,
            -5,
            8,
        };
        System.out.println(multiplication(arr, 3));
    }

    // takes the array and the number of positive integers that needs to be multiplied
    static int multiplication(int[] arr, int end) {
      /*the base case is when we have found enough positive integers(end==0)
       or when the length of the array is 0*/
        if (end == 0 || arr.length == 0) {
            return 1;
        } else {
          // creates a subarray without the first element
            int[] sub = Arrays.copyOfRange(arr, 1, arr.length);
          // if the first element is positive it multiplies and continues with the subarray
            if (arr[0] > 0) {
                return arr[0] * multiplication(sub, --end);
          //if not positive it just keeps looking for positive numbers in the subarray
            } else {
                return multiplication(sub, end);
            }
        }
    }
}
