package univer_lesson.compositeTask;

public class Main {
    public static void main(String[] args) {
        Task task1 = new SimpleTask("Task1");
        Task task2 = new SimpleTask("Task2");

        TaskList taskList = new TaskList("TaskList");
        taskList.add(task1);
        taskList.add(task2);

        taskList.display();
    }
}