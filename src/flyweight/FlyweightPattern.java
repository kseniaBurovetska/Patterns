package flyweight;

import java.util.*;

public class FlyweightPattern {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(shapeFactory.getShape("square"));
        shapeList.add(shapeFactory.getShape("triangle"));
        shapeList.add(shapeFactory.getShape("triangle"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("square"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("square"));
        shapeList.add(shapeFactory.getShape("triangle"));

        Random random = new Random();

        shapeList.forEach(s ->
                s.draw(random.nextInt(100), random.nextInt(100)
                ));

    }

}

//Flyweight
interface Shape {
    void draw(int x, int y);
}

//Concrete flyweight
class Triangle implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing triangle x=" + x + " y=" + y);
    }
}

//Concrete flyweight
class Circle implements Shape {

    int radius = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing circle radius=" + radius + " x=" + x + " y=" + y);
    }
}

//Concrete flyweight
class Square implements Shape {

    int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing square a=" + a + " x=" + x + " y=" + y);
    }
}

class ShapeFactory {

    Map<String, Shape> shapeMap = new HashMap<>();
    Map<String, Shape> shapes = new HashMap<>();

    ShapeFactory() {
        shapeMap.put("triangle", new Triangle());
        shapeMap.put("circle", new Circle());
        shapeMap.put("square", new Square());
    }

    Shape getShape(String shapeName) {
        shapes.computeIfAbsent(shapeName, x -> shapes.put(x, shapeMap.get(shapeName.toLowerCase())));

        return shapes.get(shapeName);
    }

}