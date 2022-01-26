#include <stdio.h>
#include <string.h>

// Does not work, I don't know much C

char encode (char s []) {
    //int length = 0;
    //while (s[length] != '\0') length++;
    char t[strlen(s)] = "";
    
    printf("Length:  %d\n", length);
        /*int n = 0;
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
        }*/
        return t;
}

int main () {
    printf("Hello World");
    
    encode("what");

    return 0;
}
