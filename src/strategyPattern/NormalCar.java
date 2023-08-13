package strategyPattern;

import strategyPattern.strategy.NormalDriveStrategy;

public class NormalCar extends Vehicle{
    public NormalCar() {
        super(new NormalDriveStrategy());
    }
}
