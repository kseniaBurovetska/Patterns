package builder.tutorialspoint;

import java.util.ArrayList;
import java.util.List;

public class BuilderPattern {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVedMeal();
        System.out.println("=======Veg Meal=======");
        vegMeal.showItems();
        System.out.println("Total Cost: "+ vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVedMeal();
        System.out.println("=======Non-Veg Meal=======");
        nonVegMeal.showItems();
        System.out.println("Total Cost: "+ nonVegMeal.getCost());
    }
}

interface Item {
    String name();

    Packing packing();

    double price();
}

interface Packing {
    String pack();
}

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}

abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}

class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public double price() {
        return 25.0;
    }
}

class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public double price() {
        return 30.5;
    }
}

class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public double price() {
        return 15.0;
    }
}

class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public double price() {
        return 18.5;
    }
}

//Product
class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double getCost() {
        double cost = 0.0;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item, " + item.name());
            System.out.println("Packing, " + item.packing().pack());
            System.out.println("Price, " + item.price());
        }
    }
}

class MealBuilder {

    //Concrete builders
    Meal prepareVedMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());

        return meal;
    }

    //Concrete builder
    Meal prepareNonVedMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());

        return meal;
    }
}