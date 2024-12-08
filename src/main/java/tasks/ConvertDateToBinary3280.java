package tasks;

public class ConvertDateToBinary3280 {
    public static void main(String[] args) {

    }

    public static String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();

        String[] values = date.split("-");

        for (String value : values)
            sb.append(Integer.toBinaryString(Integer.parseInt(value))).append("-");

        return sb.toString();
    }
}
