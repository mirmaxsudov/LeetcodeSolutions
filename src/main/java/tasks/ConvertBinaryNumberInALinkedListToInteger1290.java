package tasks;

public class ConvertBinaryNumberInALinkedListToInteger1290 {
    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder("");

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}