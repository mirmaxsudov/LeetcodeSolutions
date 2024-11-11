package dataStructres.stack;


public class Reversal {
    private String input;
    private String output;

    public Reversal(String input) {
        this.input = input;
        this.output = "";
    }

    public String reverse() {
        CustomStack stack = new CustomStack(10);

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty())
            builder.append(((char) stack.pop()));

        return output = builder.toString();
    }

    public String getInput() {
        return this.input;
    }

    public String getOutput() {
        return this.output;
    }

    public void setInput(String input) {
        this.input = input;
        this.output = "";
    }
}