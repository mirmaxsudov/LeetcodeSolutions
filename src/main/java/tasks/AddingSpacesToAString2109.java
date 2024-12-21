package tasks;

public class AddingSpacesToAString2109 {
    public static void main(String[] args) {
        System.out.println(addSpaces2("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

    public static String addSpaceV3(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);

        for (int space : spaces)
            sb.insert(space, " ");

        return sb.toString();
    }

    public static String addSpaces2(String s, int[] spaces) {
        char[] chars = new char[s.length() + spaces.length];

        int spaceIndex = 0;
        for (int space : spaces) {
            chars[space + spaceIndex] = ' ';
            spaceIndex++;
        }

        int index = 0;

        for (char c : s.toCharArray()) {
            if (chars[index] != ' ') {
                chars[index] = c;
                index++;
            } else {
                chars[index + 1] = c;
                index += 2;
            }
        }

        return new String(chars);
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        for (int space : spaces) {
            sb.insert(space + count, ' ');
            count++;
        }

        return sb.toString();
    }
}