package tasks;

import java.util.List;

public class Checker {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String UZB_PHONE_REGEX = """
            ^\\+998\\d{9}$""";

    public static void main(String[] args) {
//        System.out.println(checkEmail("Abdurahmon@.com"));
//        System.out.println(checkEmail("Abdurahmon@gmail.com"));
//        System.out.println(checkEmail("1313413@gmail.com"));

//        System.out.println(checkPhone("+998998922222"));
//        System.out.println(checkPhone("998998922222"));
//        System.out.println(checkPhone("+9098998922222"));
//        System.out.println(checkPhone("+a98998922222"));
//        System.out.println(checkPhone("+99899892222c"));

//        TreeNode _ = new TreeNode();
        List<TreeNode> trees = List.of(
                new TreeNode(),
                new TreeNode(),
                new TreeNode(),
                new TreeNode(),
                new TreeNode(),
                new TreeNode(),
                new TreeNode()
        );

        trees.forEach(_ -> System.out.println("My trees"));

    }

    public static boolean checkPhone(String phone) {
        return phone.matches(UZB_PHONE_REGEX);
    }

    public static boolean checkEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
