package decorator;

public class DecoratorPattern {

    public static void main(String[] args) {
        PrinterInterface printer = new LBraceDecorator(new RBraceDecorator(new QuotesDecorator(new Printer("Hello"))));
        printer.print();
    }

}


interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {

    private String message;

    Printer(String message){
        this.message = message;
    }

    @Override
    public void print() {
        System.out.print(message);
    }
}

//Decorator
abstract class Decorator implements PrinterInterface {

    PrinterInterface component;

    Decorator(PrinterInterface component){
        this.component = component;
    }
}

//Concrete decorator
class QuotesDecorator extends Decorator {

    QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\'");
        component.print();
        System.out.print("\'");
    }
}

class LBraceDecorator extends Decorator {

    LBraceDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RBraceDecorator extends Decorator {

    RBraceDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}