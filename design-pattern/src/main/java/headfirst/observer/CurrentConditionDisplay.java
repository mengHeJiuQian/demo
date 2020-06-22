package headfirst.observer;

/**
 * @author: sheldon
 * @Date: 2020/6/22 下午11:08
 * @Version: 1.0
 * Description:
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("当前天气: 温度" + temperature + "度，湿度" + humidity + "%");
    }

}
