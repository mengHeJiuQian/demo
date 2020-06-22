package headfirst.observer;


import java.util.ArrayList;

/**
 * @author: sheldon
 * @Date: 2020/6/22 下午10:45
 * @Version: 1.0
 * Description: 天气数据对象
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature; // 温度
    private float humidity; // 湿度
    private float pressure; // 压强

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementsChange() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChange();
    }

}
