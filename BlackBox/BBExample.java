/* Author: David Jefts
 *
 * Description: This is a merge sort algorithm. It takes in a list of integers as input and returns the list sorted in
 *              numerical order. The highest values will appear last in the list while the lowest values appear first.
 *
 * Equivalency Check Analysis: This program can be used as an example of how to use proper equivalency value checks to
 *                             test. For example, the program can not work properly at all if any part of the input list
 *                             is the wrong type. There are also value checks at each repositioning of an element.
 */
import java.util.Arrays;

public class BBExample {
    public static void main(String[] args) {
        BBExample bbExample = new BBExample();
        int[] A = new int[100];
        for(int i = 0; i < A.length; i++)
            A[i] = ( int )(Math.random() * 400);
        bbExample.merge(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }
    
    private void merge(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            merge(arr, l, m);
            merge(arr, m + 1, r);
            sort(arr, l, m, r);
        }
    }
    
    private void sort(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        
        int i = 0, j = 0;
        int k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
