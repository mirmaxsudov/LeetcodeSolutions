package dataStructres.bridge;

public class AmericanRestaurant extends Restaurant{
    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }
    @Override
    void addSauce() {
        pizza.setSauce("Special Sauce");
    }
    @Override
    void addToppings() {
        pizza.setToppings("Everything");
    }
    @Override
    void makeCrust() {
        pizza.setCrust("Thick");
    }
}