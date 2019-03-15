package builder;

public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder builder){
        this.builder = builder;
    }

    Car buildCar(){
        builder.createCar();
        builder.buildMark();
        builder.buildTransmission();
        builder.buildSpeed();
        Car car = builder.getCar();
        return car;
    }
}

abstract class CarBuilder{
    Car car;

    void createCar(){
        car = new Car();
    }

    abstract void buildMark();
    abstract void buildTransmission();
    abstract void buildSpeed();

    Car getCar(){
        return car;
    }
}

class FordBuilder extends CarBuilder{

    @Override
    void buildMark() {
        car.setMark("Ford");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(260);
    }
}

class SubaruBuilder extends CarBuilder{

    @Override
    void buildMark() {
        car.setMark("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(300);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car{
    String mark;
    Transmission transmission;
    int speed;

    public void setMark(String mark){
        this.mark = mark;
    }

    public void setTransmission(Transmission t){
        this.transmission = t;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", transmission=" + transmission +
                ", speed=" + speed +
                '}';
    }
}