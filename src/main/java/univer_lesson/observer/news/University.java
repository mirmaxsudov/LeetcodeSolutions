package univer_lesson.observer.news;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class University implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String name;
    private String news;

    public University(String name) {
        this.name = name;
        this.news = "- FROM: " + name;
    }

    public String getEaddress() {
        return news;
    }

    public void sendNews(String news) {
        System.out.printf("\nName: %s, News : %s\n", name, news);
    }


    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(String message) {
        observers.forEach(observer -> observer.notification(news, message));
    }
}
