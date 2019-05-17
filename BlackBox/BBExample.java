import java.util.Arrays;

public class BBExample {
    public static void main(String[] args) {
        BBExample bbExample = new BBExample();
        int[] A = new int[100];
        for(int i = 0; i < A.length; i++)
            A[i] = ( int )(Math.random() * 400);
        bbExample.foo(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }
    
    private void foo(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            foo(arr, l, m);
            foo(arr, m + 1, r);
            foo2(arr, l, m, r);
        }
    }
    
    private void foo2(int[] arr, int l, int m, int r) {
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
