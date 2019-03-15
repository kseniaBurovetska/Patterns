package abstractFactory;

//Abstract product
interface Shape{
    void draw();
}

//Concrete product 1
class RoundedRectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rounded rectangle");
    }
}

//Concrete product 2
class RoundedSquare implements Shape{

    @Override
    public void draw() {
        System.out.println("Rounded square");
    }
}

//Concrete product 3
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

//Concrete product 4
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

//Abstract factory
abstract class AbstractFactory{
    abstract Shape getShape(String shapeType);
}

//Concrete factory 1
class ShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }
}

//Concrete factory 2
class RoundedShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("rectangle")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("square")){
            return new RoundedSquare();
        }
        return null;
    }
}

//Factory producer. Returns specific factory
class FactoryProducer{
    static AbstractFactory getFactory(boolean rounded){
        if(rounded)
            return new RoundedShapeFactory();
        else
            return new ShapeFactory();
    }
}


public class AbstractFactoryPattern {

    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();

        shapeFactory = FactoryProducer.getFactory(true);

        Shape rectangle1 = shapeFactory.getShape("rectangle");
        rectangle1.draw();

        Shape square1 = shapeFactory.getShape("square");
        square1.draw();

    }

}
