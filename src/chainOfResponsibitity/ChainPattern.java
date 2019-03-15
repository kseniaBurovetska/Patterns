package chainOfResponsibitity;

public class ChainPattern {

    public static void main(String[] args) {

        MoneyModule module100 = new MoneyModule100();
        MoneyModule module50 = new MoneyModule50();
        MoneyModule module20 = new MoneyModule20();
        MoneyModule module10 = new MoneyModule10();

        module100.setNext(module50);
        module50.setNext(module20);
        module20.setNext(module10);

        module100.getMoney(new Money(230));

    }

}

class Money {

    private int money;

    public Money(int money) {
        if (money >= 0 && money % 10 == 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Cannot dispense such sum");
        }
    }

    public int getMoney() {
        return money;
    }
}

abstract class MoneyModule {
     MoneyModule next;

    abstract void getMoney(Money money);

    void setNext(MoneyModule next) {
        this.next = next;
    }
}

class MoneyModule100 extends MoneyModule {

    @Override
    void getMoney(Money money) {
        int count = money.getMoney() / 100;
        int remind = money.getMoney() % 100;

        if (count > 0) {
            System.out.println("Got " + count + " banknotes for " + 100 + " dollars");
        }
        if(remind > 0){
            next.getMoney(new Money(remind));
        }
    }
}

class MoneyModule50 extends MoneyModule {

    @Override
    void getMoney(Money money) {
        int count = money.getMoney() / 50;
        int remind = money.getMoney() % 50;

        if (count > 0) {
            System.out.println("Got " + count + " banknotes for " + 50 + " dollars");
        }
        if(remind > 0){
            next.getMoney(new Money(remind));
        }
    }
}

class MoneyModule20 extends MoneyModule {

    @Override
    void getMoney(Money money) {
        int count = money.getMoney() / 20;
        int remind = money.getMoney() % 20;

        if (count > 0) {
            System.out.println("Got " + count + " banknotes for " + 20 + " dollars");
        }
        if(remind > 0){
            next.getMoney(new Money(remind));
        }
    }
}

class MoneyModule10 extends MoneyModule {

    @Override
    void getMoney(Money money) {
        int count = money.getMoney() / 10;
        int remind = money.getMoney() % 10;

        if (count > 0) {
            System.out.println("Got " + count + " banknotes for " + 10 + " dollars");
        }
        if(remind > 0){
            next.getMoney(new Money(remind));
        }
    }
}

