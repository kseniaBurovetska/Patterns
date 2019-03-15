package factoryMethod;

import java.util.HashMap;
import java.util.Map;

//Product interface
interface Shape {
    void draw();
}

//Concrete products
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}


//Concrete creator
class ShapeFactory {

    Map<String, Shape> shapeMap = new HashMap<>();

    ShapeFactory() {
        shapeMap.put("circle", new Circle());
        shapeMap.put("rectangle", new Rectangle());
        shapeMap.put("square", new Square());
    }

    public Shape getShape(String shapeType) {
        return shapeMap.getOrDefault(shapeType.toLowerCase(), null);
    }
}

public class FactoryMethodPattern {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();

    }

}
