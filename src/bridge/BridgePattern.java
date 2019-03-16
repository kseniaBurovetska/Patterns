package bridge;

public class BridgePattern {

    public static void main(String[] args) {
        Car car = new Sedan(new Kia());
        car.showDetails();
        Car car1 = new Sedan(new Skoda());
        car1.showDetails();
        Car car5 = new Sedan(new Mercedes());
        car5.showDetails();

        Car car2 = new Hatchback(new Kia());
        car2.showDetails();
        Car car3 = new Hatchback(new Skoda());
        car3.showDetails();
        Car car4 = new Hatchback(new Mercedes());
        car4.showDetails();
    }

}

abstract class Car {

    Make make;

    public Car(Make make) {
        this.make = make;
    }

    void showDetails(){
        showType();
        make.setMake();
    }

    abstract void showType();
}

class Sedan extends Car {

    public Sedan(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.print("Sedan - ");
    }
}

class Hatchback extends Car {

    public Hatchback(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.print("Hatchback - ");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {

    @Override
    public void setMake() {
        System.out.println("Kia make");
    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda make");
    }
}

class Mercedes implements Make {

    @Override
    public void setMake() {
        System.out.println("Mercedes make");
    }
}