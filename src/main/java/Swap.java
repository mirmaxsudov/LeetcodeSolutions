public class Swap {
    public static void main(String[] args) {
        ver1();
        ver2();
        ver3();
    }

    private static void ver3() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap a = " + a + " and b = " + b);
        a = a ^ b;
        b = a ^ b;
        System.out.println("After swap a = " + a + " and b = " + b);
    }

    private static void ver2() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap a = " + a + " and b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swap a = " + a + " and b = " + b);
    }

    private static void ver1() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap a = " + a + " and b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap a = " + a + " and b = " + b);
    }
}
