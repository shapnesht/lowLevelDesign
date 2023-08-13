package decoratorPattern;

import decoratorPattern.decorators.ExtraCheese;
import decoratorPattern.decorators.Mushroom;
import decoratorPattern.pizzas.BasePizza;
import decoratorPattern.pizzas.Margherita;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Mushroom(new Mushroom(new Margherita())));
        System.out.println(pizza.cost());
    }
}