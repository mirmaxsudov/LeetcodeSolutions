package tasks;

public class GenerateTagForVideoCaption3582 {
    public static void main(String[] args) {
        System.out.println(generateTag("Leetcode daily streak achieved"));
    }

    public static String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        int i = 0;
        boolean isUpper = true;

        while (sb.length() < 100 && i < caption.length()) {
            char ch = caption.charAt(i);

            if (!Character.isLetter(ch) && ch != ' ') {
                i++;
                continue;
            }

            if (isUpper) {
                if (ch == ' ') {
                    if (i == 0)
                        isUpper = false;
                    i++;
                    continue;
                }

                if (i == 0) {
                    if (ch >= 97)
                        sb.append(ch);
                    else
                        sb.append((char) (ch + 32));
                } else if (ch >= 97)
                    sb.append((char) (ch - 32));
                else
                    sb.append(ch);
                isUpper = false;
            } else if (ch == ' ')
                isUpper = true;
            else {
                if (ch >= 97)
                    sb.append(ch);
                else
                    sb.append((char) (ch + 32));
            }

            i++;
        }

        return sb.toString();
    }
}