package singleton;

public class SingletonPattern {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[500];

        for (int i = 0; i < 500; i++) {
            threads[i] = new Thread(new R());
            threads[i].start();
        }

        for (int i = 0; i < 500; i++) {
            threads[i].join();
        }

        System.out.println(Singleton.counter);

    }

}

class R implements Runnable {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {

    static int counter = 0;
    private static volatile Singleton instance;

    private Singleton() {
        counter++;
    }

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    /*static Singleton getInstance() {
        return instance;
    }*/

    /*static synchronized Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }*/

}