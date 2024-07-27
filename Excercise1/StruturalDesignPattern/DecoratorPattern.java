package Excercise1.StruturalDesignPattern;
interface Coffee {
    double cost();
    String description();
}

class BasicCoffee implements Coffee {
    @Override
    public double cost() {
        return 5;
    }

    @Override
    public String description() {
        return "Basic Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }

    @Override
    public String description() {
        return coffee.description();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String description() {
        return super.description() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + ", Sugar";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.description() + " costs $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " costs $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " costs $" + coffee.cost());
    }
}
