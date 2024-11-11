package dataStructres.bridge;

public class ItalianRestaurant extends Restaurant {
    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.setSauce("Italian Sicily Sauce");
    }

    @Override
    void addToppings() {
        pizza.setToppings("Everything ...");
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thing");
    }
}