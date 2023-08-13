package strategyPattern;

import strategyPattern.strategy.NormalDriveStrategy;
import strategyPattern.strategy.SpecialDriveStrategy;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(new NormalDriveStrategy());
        vehicle1.drive();

        Vehicle vehicle2 = new Vehicle(new SpecialDriveStrategy());
        vehicle2.drive();
    }
}