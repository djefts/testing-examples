public class WBExample {
    private String a = "";
    
    public static void main(String[] args) {
        //generate a random string
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz_0123456789";
        StringBuilder sb = new StringBuilder();
        int l = ( int )(Math.random() * 50);
        for(int i = 0; i <= l; i++) {
            sb.append(chars.charAt(( int )(Math.random() * chars.length())));
        }
        
        WBExample wbExample = new WBExample();
        wbExample.foof(sb);
    }
    
    private void foof(StringBuilder sb) {
        a = sb.toString();
        WBExample wbExample = new WBExample();
        System.out.println(a);
        System.out.println(wbExample.foo(0, 4));
        System.out.println(wbExample.foo(25, 8));
    }
    
    private int foo(int i, int n) {
        if(i >= a.length()) {
            i = ( int )(a.length() / 2.0);
        }
        if(a.length() == 0) {
            a = "oof";
        } else if(a.indexOf(' ') >= 0 || a.indexOf('_') >= 0) {
            System.out.println("Found space!");
            a = a.substring(a.indexOf(' '));
            n -= 100;
            foo(i + 5, n);
        } else if(a.charAt(i) == ' ') {
            a = a.substring(1);
            foo(i + 1, n + 42);
        } else if(Character.isDigit(a.charAt(i))) {
            n += ( int )(a.charAt(i));
            a = a.substring(i);
            System.out.println(a);
            if(n < 50) {
                n += 25;
            }
            foo(i + 1, n);
        } else {
            int h = n;
            if(h > a.length()) h = a.length() - 1;
            for(int j = 0; j < h; j += 2) {
                n += ( int )(a.charAt(j));
            }
        }
        return n;
    }
}
