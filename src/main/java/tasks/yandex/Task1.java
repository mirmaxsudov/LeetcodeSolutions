package tasks.yandex;

public class Task1 {
    public static void main(String[] args) {

    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.replaceAll("\\s+", " ");

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.equals(",")) {
                sb.append(word).append(" ");
                continue;
            }

            sb.append(word);

            if (i < words.length - 1)
                sb.append(words[i + 1].equals(",") ? "" : " ");
        }

        return sb.toString();
    }
}
