class AccessLevel {
    public static String access (int [] rights, int permission) {
        String t = "";
        for (int i = 0; i < rights.length; i++) {
            if (rights[i] >= permission) t += 'A';
            else t += 'D';
        }
        return t;
    }
}

public class Access {
    public static void main (String [] args) {
        int [] rights = {34, 78, 9, 52, 11, 1};
        int minPermission = 49;
        System.out.println(AccessLevel.access(rights, minPermission));
    }
}
