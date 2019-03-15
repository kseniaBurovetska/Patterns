package state;

public class StatePatternInStates {

    public static void main(String[] args) {
        Human human = new Human();
        human.setActivity(new Work());

        for (int i = 0; i < 15; i++) {
            human.doActivity();
        }
    }

}

//Context
class Human {
    private Activity activity;

    void setActivity(Activity activity) {
        this.activity = activity;
    }

    void doActivity() {
        activity.doActivity(this);
    }
}

//State
interface Activity {
    void doActivity(Human human);
}

class Work implements Activity {


    @Override
    public void doActivity(Human human) {
        System.out.println("Working...");
        human.setActivity(new Weekend());
    }
}

class Weekend implements Activity {

    private int count = 0;

    @Override
    public void doActivity(Human human) {
        if (count < 3) {
            System.out.println("Relaxing");
            count++;
        } else {
            human.setActivity(new Work());
            human.doActivity();
        }
    }
}