package tasks;

public class Checker {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static void main(String[] args) {
        System.out.println(checkEmail("Abdurahmon@.com"));
        System.out.println(checkEmail("Abdurahmon@gmail.com"));
        System.out.println(checkEmail("1313413@gmail.com"));
    }

    public static boolean checkEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
