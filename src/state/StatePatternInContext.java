package state;

import java.util.HashMap;
import java.util.Map;

public class StatePatternInContext {

    public static void main(String[] args) {
        Station station = new Radio7();
        Radio radio = new Radio();
        radio.setStation(station);

        for(int i = 0; i<6;i++) {
            radio.play();
            radio.nextStation();
        }
    }

}

//State
abstract class Station {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void play();
}

class Radio7 extends Station {
    Radio7() {
        setName("radio7");
    }

    public void play() {
        System.out.println("Radio 7");
    }
}

class Radio6 extends Station {

    Radio6() {
        setName("radio6");
    }

    public void play() {
        System.out.println("Radio 6");
    }
}

class Radio5 extends Station {
    Radio5() {
        setName("radio5");
    }

    public void play() {
        System.out.println("Radio 5");
    }
}

//Context
class Radio {
    Station station;
    Map<String, Station> stationMap;


    Radio(){
        stationMap = new HashMap<>();

        stationMap.put("radio7", new Radio6());
        stationMap.put("radio6", new Radio5());
        stationMap.put("radio5", new Radio7());
    }

    void setStation(Station station) {
        this.station = station;
    }

    void nextStation(){
        setStation(stationMap.getOrDefault(station.getName(), new Radio7()));
    }

    void play(){
        station.play();
    }

}