package templateMethod;

public class TemplatePattern {

    public static void main(String[] args) {
        System.out.println("class A");
        A a = new A();
        a.templateMethod();

        System.out.println("class B");
        B b = new B();
        b.templateMethod();
    }

}

abstract class C {
    void templateMethod() {
        //System.out.println();
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }

    abstract void differ();
    abstract void differ2();
}

class A extends C{

    @Override
    void differ() {
        System.out.print("2");
    }

    @Override
    void differ2() {
        System.out.println("5");
    }
}

class B extends C {

    @Override
    void differ() {
        System.out.print("4");
    }

    @Override
    void differ2() {

    }
}