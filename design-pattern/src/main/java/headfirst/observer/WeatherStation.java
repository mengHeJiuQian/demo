package headfirst.observer;

/**
 * @author: sheldon
 * @Date: 2020/6/22 下午11:13
 * @Version: 1.0
 * Description: 气象站
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(35, 80, 30.4F);

        System.out.println("");
    }
}
