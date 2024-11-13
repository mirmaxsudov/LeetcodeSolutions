package univer_lesson.observer.news;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subscriber implements Observer {
    private String name;

    @Override
    public void notification(String handle, String message) {
        System.out.printf("%s received news: %s- NEWS: '%s'\n", name, handle, message);
    }
}