import java.lang.String;

class Dirsort {
    static void sort (String s []) {
        int swaps;
        do {
            swaps = 0;
            for (int i = 1; i < s.length; i++) {
                if (Dirsort.compare(s[i - 1], s[i]) > 0) {
                    String temp = s[i - 1];
                    s[i - 1] = s[i];
                    s[i] = temp;
                    swaps++;
                }
            }
        } while (swaps > 0);
    }
    static int compare (String a, String b) {
        int x = 0, y = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '/') x++;
        }
        for (int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == '/') y++;
        }
        if (x != y) return x - y;
        int j = x;
        for (int i = 0; i < j; i++) {

            x = a.indexOf('/');
            y = b.indexOf('/');

            String u = a.substring(0, x);
            String v = b.substring(0, y);

            int f = u.compareTo(v);

            if(f != 0) return f;

            a = a.substring(x + 1);
            b = b.substring(y + 1);
        }
        return 0;
    }
}

public class DirectorySorter {
    public static void main (String [] args) {
        String test [] = {"/a/b/c/d/e/f/g/h/i/j/k/l/m/n/","/o/p/q/r/s/t/u/v/w/x/y/z/ "};
        System.out.print('[');
        for(int i = 0; i < test.length - 1; i++){
            System.out.print(test[i] + ", ");
        }
        System.out.println(test[test.length - 1] + ']');
        Dirsort.sort(test);
        System.out.print('[');
        for(int i = 0; i < test.length - 1; i++){
            System.out.print(test[i] + ", ");
        }
        System.out.println(test[test.length - 1] + ']');

    }
}
