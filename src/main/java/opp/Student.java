package opp;

public class Student {
    private String name = "Someone";
    private String surname = "Someoneov";

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void sayName() {
        System.out.println(this.name + " " + this.surname);
    }
}