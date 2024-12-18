package univer_lesson.observer.news;

public class Main {
    public static void main(String[] args) {
        University n1 = new University("PDP EcoSystem");
        Subscriber s1 = new Subscriber("Student One");
        Subscriber s2 = new Subscriber("Teacher One");
        n1.addSubscriber(s1);
        n1.addSubscriber(s2);
        n1.sendNews("Summer Offers!");
        n1.removeSubscriber(s2);
        n1.sendNews("Ends in September !");
        n1.notifySubscribers("E-mail");
    }
}