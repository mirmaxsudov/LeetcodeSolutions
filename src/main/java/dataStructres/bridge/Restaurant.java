package dataStructres.bridge;

public abstract class Restaurant {
    Pizza pizza;

    public Restaurant(Pizza pizza) {
        this.pizza = pizza;
    }

    abstract void addSauce();

    abstract void addToppings();

    abstract void makeCrust();

    public void deliver() {
        makeCrust();
        addSauce();
        addToppings();
        pizza.prepareCrust();
        pizza.prepareToppings();
        System.out.println("In process ...");
    }
}