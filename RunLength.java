class RunLengthEncode {
    public static String encode (String s) {
        String t = "";
        int n = 0;
        char c = '\n';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) n++;
            else {
                if (n >= 4) {
                    t = t.substring(0, t.length() - ++n);
                    t += "/" + (n / 10) + (n % 10) + c;
                }
                c = s.charAt(i);
                n = 0;
            }
            t += s.charAt(i);
        }
        if (n >= 4) {
            t = t.substring(0, t.length() - ++n);
            t += "/" + (n / 10) + (n % 10) + c;
        }
        return t;
    }
    public static String decode (String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                int n = (10 * (int) s.charAt(i + 1) + (int) s.charAt(i + 2)) - 528;
                for (int j = 0; j < n; j++) t += s.charAt(i + 3);
                i += 3;
            }
            else {
                t += s.charAt(i);
            }
        }
        return t;
    }
}

public class RunLength {
    public static void main (String [] args) {
        String test = "if(a){if(b){if(c){if(d){if(e){5 deeeeeeep}}}}}",
               encoded = RunLengthEncode.encode(test),
               decoded = RunLengthEncode.decode(encoded);
        System.out.println(test);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}
