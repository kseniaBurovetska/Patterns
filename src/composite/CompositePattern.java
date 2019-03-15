package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {

    public static void main(String[] args) {
        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();

        Shape square3 = new Square();
        Shape triangle3 = new Triangle();
        Shape triangle4 = new Triangle();

        composite1.add(circle1);
        composite1.add(circle2);
        composite1.add(square1);
        composite1.add(square2);
        composite1.add(triangle1);
        composite1.add(triangle2);

        composite2.add(square3);
        composite2.add(triangle3);
        composite2.add(triangle4);

        composite.add(composite1);
        composite.add(composite2);

        composite.draw();
    }

}

//Component
interface Shape {
    void draw();
}

class Composite implements Shape {

    List<Shape> components = new ArrayList<>();

    void add(Shape component) {
        components.add(component);
    }

    void remove(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        components.stream()
                .forEach(Shape::draw);
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I am a square");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am a triangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am a circle");
    }
}
