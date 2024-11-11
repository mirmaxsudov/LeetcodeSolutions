package univer_lesson.compositeTask;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Task {
    private String title;
    private List<Task> tasks = new ArrayList<>();

    public TaskList(String title) {
        this.title = title;
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public void remove(Task task) {
        this.tasks.remove(task);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Task title " + this.title);

        for (Task task : tasks) {
            task.display();
        }
    }
}
