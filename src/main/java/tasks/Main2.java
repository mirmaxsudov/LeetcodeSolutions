package tasks;

import java.util.StringJoiner;

public class Main2 {
    public static void main(String[] args) {
        String[] colors = {
                "red", "green", "blue", "yellow", "black",
                "white", "orange", "purple", "brown", "pink"
        };

        Color color = new Color(colors);
        color.add("CustomColor1");
        color.add("CustomColor2");
        color.add("CustomColor3");

        color.delete(0);
        color.delete(1);

        color.add(0, "CustomColor4");

        System.out.println(color);
    }
}

final class Color {
    private String[] colors;
    private int size = 0;

    public Color() {
        this.colors = new String[10];
        this.size += this.colors.length;
    }

    public Color(String[] colors) {
        this.colors = colors;
        this.size += this.colors.length;
    }


    public void add(String color) {
        if (this.size < this.colors.length) {
            this.colors[this.size] = color;
            this.size++;
            return;
        }

        String[] newColors = new String[this.colors.length * 2];
        System.arraycopy(this.colors, 0, newColors, 0, this.colors.length);
        this.colors = newColors;

        this.colors[this.size] = color;
        size++;
    }

    public String delete(int index) {
        String deleted = this.colors[index];

        for (int i = index; i < size; i++)
            this.colors[i] = this.colors[i + 1];

        this.size--;
        this.colors[this.size] = null;

        return deleted;
    }

    public String get(int index) {
        return this.colors[index];
    }

    public int size() {
        return this.size;
    }

    public void add(int index, String color) {
        this.colors[index] = color;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");

        for (int i = 0; i < size; i++) {
            joiner.add(this.colors[i]);
        }

        return joiner.toString();
    }
}