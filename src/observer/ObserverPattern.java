package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();

        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());

        meteoStation.setMeasurements(50, 60);
        meteoStation.setMeasurements(30, 90);
    }

}

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void handleEvent(int temp, int press);
}

//Concrete observable
class MeteoStation implements Observable {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    void setMeasurements(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.handleEvent(temperature, pressure));
    }
}

class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int press) {
        System.out.println("Console!\nWeather changed! Temperature: "+temp+" Pressure: "+press);
    }
}

class FileObserver implements Observer {

    @Override
    public void handleEvent(int temp, int press) {
        try {
            File f = File.createTempFile("WeatherObserver","_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.println("Text!\nWeather changed! Temperature: "+temp+" Pressure: "+press);
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}