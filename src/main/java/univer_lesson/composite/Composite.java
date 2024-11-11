package univer_lesson.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    String name;
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void showPrice() {
        System.out.println(name);

        for (Component component : components) {
            component.showPrice();
        }
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    public Component getComponent(int index) {
        return components.get(index);
    }
}
