package dataStructres.bridge;

public class PepperoniPizza extends Pizza {
    @Override
    public void prepareToppings() {
        System.out.println("Add sauce " + sauce);
        System.out.println("Add toppings " + toppings);
        System.out.println("Add Pepperoni ");
    }

    @Override
    public void prepareCrust() {
        System.out.println("Prepare crust : " + crust);
    }
}