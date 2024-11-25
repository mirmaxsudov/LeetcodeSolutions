package academy.testProtected;

public class Main {
    public static void main(String[] args) {
        Mentor mentor = new Mentor("Java", "Denis", "denis@me.com", "12345678");
        System.out.println(mentor.getPassword());
    }
}

class User {
    public String name;
    protected String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

class Mentor extends User {
    private String course;

    public Mentor(String course, String name, String email, String password) {
        super(name, email, password);
        this.course = course;
    }
}