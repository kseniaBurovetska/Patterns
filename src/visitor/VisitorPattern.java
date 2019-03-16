package visitor;

public class VisitorPattern {

    public static void main(String[] args) {
        GoodVisitor goodVisitor = new GoodVisitor();
        BadVisitor badVisitor = new BadVisitor();

        Element car = new CarElement();

        car.accept(goodVisitor);

        car.accept(badVisitor);
    }

}

interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {

    Element[] elements;

    public CarElement() {
        this.elements = new Element[] {
            new WheelElement(),
            new BodyElement(),
            new EngineElement()
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for(Element elem : elements){
            elem.accept(visitor);
        }

        visitor.visit(this);
    }
}

class BadVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Broke engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Broke body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Broke car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Broke wheel");
    }
}

class GoodVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Fixed engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Fixed body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Fixed car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Fixed wheel");
    }
}