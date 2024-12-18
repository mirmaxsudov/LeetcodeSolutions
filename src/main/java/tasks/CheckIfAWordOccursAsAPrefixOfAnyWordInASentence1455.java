package tasks;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455 {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int searchWordLen = searchWord.length();
        int wordCount = 0;

        int left = 0;
        int right = left + 1;

        for (int i = 0; i < sentence.length() - 1; i++) {

            if (right == sentence.length()) {
                System.out.println(sentence.substring(left, right + 1));

                if (right - left >= searchWordLen) {
                    int index = 0;
                    for (int j = left + 1; j <= right; j++) {
                        if (sentence.charAt(j) != searchWord.charAt(index)) {
                            break;
                        } else {
                            index++;
                        }
                    }

                    if (index == searchWordLen - 1) {
                        return wordCount;
                    }
                }

                return -1;
            }

            if (sentence.charAt(right) == ' ') {
                if (right - left >= searchWordLen) {
                    int index = 0;

                    System.out.println(sentence.substring(left, right + 1));

                    for (int j = left + 1; j <= right; j++) {
                        if (sentence.charAt(j) != searchWord.charAt(index)) {
                            break;
                        } else {
                            index++;
                        }
                    }

                    if (index == searchWordLen - 1) {
                        return wordCount;
                    }
                }

                left = right + 1;
                right = left + 1;
                wordCount++;
            } else {
                right++;
            }
        }

        return -1;
    }
//    public static int isPrefixOfWord(String sentence, String searchWord) {
//        String[] s = sentence.split(" ");
//        for (int i = 0; i < s.length; i++) {
//            if (s[i].startsWith(searchWord))
//                return i;
//        }
//        return -1;
//    }
}