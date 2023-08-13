package decoratorPattern.pizzas;

import decoratorPattern.pizzas.BasePizza;

public class VegDelight extends BasePizza {
    @Override
    public int cost() {
        return 150;
    }
}
