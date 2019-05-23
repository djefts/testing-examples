public class CRExample {
    public static void main(String[] args) {
        CRExample crExample = new CRExample();
        for(int i = 0; i < 20; i++) {
            System.out.println(crExample.foo(i));   //print out first 20 fibbonacci numbers
        }
    }
    
    private int foo(int n) {
        //fibonacci sequence method
        if(n >= 1) {   // should be `if(n <= 1)`
            return n;
        } else {
            return foo(n - 2) - foo(n + 1); //should be `foo(n - 2) + foo(n - 1)`
        }
    }
}
