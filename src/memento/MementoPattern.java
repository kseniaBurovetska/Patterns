package memento;

import java.time.LocalDate;
import java.time.LocalTime;

public class MementoPattern {

    public static void main(String[] args) {

        Game game = new Game();
        game.set("Level 5", LocalTime.now());
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("Level 10", LocalTime.now());
        System.out.println(game);

        game.load(file.getSave());
        System.out.println(game);
    }

}

//Originator
class Game {
    private String level;
    private LocalTime time;

    public Game() {
    }

    public void set(String level, LocalTime time) {
        this.level = level;
        this.time = time;
    }

    public Save save(){
        return new Save(level, time);
    }

    public void load(Save save){
        this.level = save.getLevel();
        this.time = save.getTime();
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}

//Memento
class Save {

    private final String level;
    private final LocalTime time;

    Save(String level, LocalTime time){
        this.level = level;
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public LocalTime getTime() {
        return time;
    }
}

//Caretaker
class File {
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}