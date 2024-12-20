package tasks;

public class CircularSentence2490 {
    public static void main(String[] args) {
//        System.out.println('L' - 'l');
//        System.out.println(isCircularSentence("leetcode exercises sound delightful") + " - " + "True");
//        System.out.println(isCircularSentence("wZJxUaNCVwUkWNGBQLzIIJDStzQIxLudYjejWimXWvoRJFnKFSiGynt tQywgnOIcpQRyaCGadbpNlVJZTikOukEyhFhWuEPPiBqGQTfHwUoBRGtHaNCRZpNpQaNoFZmBwzjyKCSzXxkNlyLdqOIeMCbPkCWMcjwTwkSbsmLasZyImimdnOTJTZjVIsox xQhIuBvGcXPXzLtwlFaSdVrdvnifyiWVFURLRgMUgXCmoUcsVAuUgmbiPyfnVywNeIbJPQlxWLjlVxvxzOpwqnqbMUQKXWTtA AVAPHRRXGUQqjIPKYlHCIZhcMLGOdCwDTeDIgFzZIX Xeou uOUhQbaueDrmpDdTEKImvPiugumCtBGHWfLAufLhhJgRCmVbw") + " - " + "True");
        System.out.println(isCircularSentence("IuTiUtGGsNydmacGduehPPGksKQyT TmOraUbCcQdnZUCpGCYtGp p pG GCcRvZDRawqGKOiBSLwjIDOjdhnHiisfddYoeHqxOqkUvOEyI") + " - " + "True");
    }

    public static boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;

        for (int i = 0; i < sentence.length(); i++) {
            int si = sentence.indexOf(' ', i);

            if (si == -1)
                break;

            if (Character.toLowerCase(sentence.charAt(si - 1)) != Character.toLowerCase(sentence.charAt(si + 1)))
                return false;

            i = si + 1;
        }

        return true;
    }
}