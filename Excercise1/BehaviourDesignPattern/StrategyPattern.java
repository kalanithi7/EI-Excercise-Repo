package Excercise1.BehaviourDesignPattern;

interface TravelStrategy {
    double calculateCost(int distance);
}

class CarTravelStrategy implements TravelStrategy {
    @Override
    public double calculateCost(int distance) {
        return distance * 0.5;
    }
}

class TrainTravelStrategy implements TravelStrategy {
    @Override
    public double calculateCost(int distance) {
        return distance * 0.3;
    }
}

class FlightTravelStrategy implements TravelStrategy {
    @Override
    public double calculateCost(int distance) {
        return distance * 0.8;
    }
}

class TravelContext {
    private TravelStrategy strategy;

    public TravelContext(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public double getTravelCost(int distance) {
        return strategy.calculateCost(distance);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        int distance = 100;

        TravelContext context = new TravelContext(new CarTravelStrategy());
        System.out.println("Car travel cost: " + context.getTravelCost(distance));

        context.setStrategy(new TrainTravelStrategy());
        System.out.println("Train travel cost: " + context.getTravelCost(distance));

        context.setStrategy(new FlightTravelStrategy());
        System.out.println("Flight travel cost: " + context.getTravelCost(distance));
    }
}
