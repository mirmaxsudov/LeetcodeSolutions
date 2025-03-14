package univer_lesson.observer.weather;

import lombok.Getter;

@Getter
public class PhoneDisplay implements Observer {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("Phone display: weather updated - " + this.weather);
    }
}