package univer_lesson.observer.news;

public interface Subject {
    void addSubscriber(Observer observer);

    void removeSubscriber(Observer observer);

    void notifySubscribers(String email);
}