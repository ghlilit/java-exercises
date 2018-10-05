/* Given a set of strings of equal length this is a hybrid variation of quick-sort and radix-sort
to sort the given set of strings*/
import java.util.*;
public class Exercise6 {

    public static void main(String[] args) {

        //case1, random strings
        ArrayList < String > test1 = new ArrayList <String> ();
        test1.add("aaad");
        test1.add("abda");
        test1.add("ajab");
        test1.add("akaf");
        int l1 = test1.size();
        dictSort(test1, 0, l1);
        System.out.println(test1);

        //case2, very equal strings
        ArrayList < String > test2 = new ArrayList <String> ();
        test2.add("aaak");
        test2.add("aada");
        test2.add("aaaf");
        test2.add("aaaf");
        int l2 = test2.size();
        dictSort(test2, 0, l2);
        System.out.println(test2);


    }
    /* dictSort function sorts the words like in dictionaries, it takes the
      set of the strings, the index of the character which is going to be the
      pivot, and the original length of the string*/
    public static void dictSort(ArrayList <String> unsorted, int j, int iLength) {

        int length = unsorted.size();
        /*2 base cases , first is when the the string length is smaller than 2
        the second is when the index at which is the character is equal
        to the length of the string (nothing to compare left)*/
        if (length < 2) return;
        if (j == iLength) return;
        //pivot is the j-th character of the last string
        char pivot = unsorted.get(length - 1).charAt(j);

        ArrayList < String > small = new ArrayList <String> ();
        ArrayList < String > equal = new ArrayList <String> ();
        ArrayList < String > big = new ArrayList <String> ();
        /*compares the j-th characters of the strings with the pivot, adds to the special ArrayLists */
        for (int i = 0; i < length; i++) {
            if (unsorted.get(i).charAt(j) < pivot) {
                small.add(unsorted.get(i));
            } else if (unsorted.get(i).charAt(j) == pivot) {
                equal.add(unsorted.get(i));
            } else {
                big.add(unsorted.get(i));
            }

        }
        //now recursively sorts the partitioned ArrayLists
        dictSort(small, j, iLength);
        //for the equal part, now it compares (j+1)-th character
        dictSort(equal, ++j, iLength);
        dictSort(big, j, iLength);

        /*now we clear the old array and add the elements of the sorted parts*/
        unsorted.clear();
        int k = 0;
        for (int i = 0; i < small.size(); i++) {
            unsorted.add(k, small.get(i));
            k++;
        }
        for (int i = 0; i < equal.size(); i++) {
            unsorted.add(k, equal.get(i));
            k++;
        }
        for (int i = 0; i < big.size(); i++) {
            unsorted.add(k, big.get(i));
            k++;
        }

    }

}
