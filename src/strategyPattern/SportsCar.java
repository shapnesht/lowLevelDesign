package strategyPattern;

import strategyPattern.strategy.SpecialDriveStrategy;

public class SportsCar extends Vehicle{

    public SportsCar() {
        super(new SpecialDriveStrategy());
    }
}
