package dataStructres.bridge;

public class VeggiePizza extends Pizza {
    @Override
    public void prepareToppings() {
        System.out.println("Add sauce " + sauce);
        System.out.println("Add toppings " + toppings);
        System.out.println("Add Cheese ");
    }

    @Override
    public void prepareCrust() {
        System.out.println("Prepare crust : " + crust);
    }
}