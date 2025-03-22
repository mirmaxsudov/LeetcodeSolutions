package tasks.rec;

public class FindTheKThCharacterInStringGameI3304 {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5)); // b
        System.out.println(kthCharacter(10)); // c
    }

    public static char kthCharacter(int k) {
        String res = helper(k, "a");
        return res.charAt(k - 1);
    }

    private static String helper(int k, String str) {
        if (str.length() >= k)
            return str;

        return helper(k, str + changer(str));
    }

    private static String changer(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'z')
                chars[i] = 'a';
            else
                chars[i]++;
        }

        return new String(chars);
    }
}