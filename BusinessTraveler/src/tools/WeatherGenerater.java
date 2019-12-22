/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;
import model.EnumType.EnumTypes;
import model.EnumType.EnumTypes.WeatherType;
import model.Environment.Weather.*;
import model.Environment.Weather.Weather;
import myinterface.TimeInfluencable;

/**
 *
 * @author Yun_c
 */
public class WeatherGenerater implements TimeInfluencable {

    WeatherType lastWeather;
    Weather weather;

    private void generateWeater() {
        Random r = new Random();
        int alertLevel = 0;
        if (lastWeather == null) {
            alertLevel = r.nextInt(2);
            this.lastWeather = WeatherType.getWeatherByAlertLevel(alertLevel);
            return;
        } else {
            alertLevel = lastWeather.getAlertLevel();
        }

        int rndNumber = r.nextInt(6);
        if (rndNumber >= 0 && rndNumber <= 1) {
            this.lastWeather = WeatherType.getWeatherByAlertLevel(alertLevel - 1);
        } else if (rndNumber >= 2 && rndNumber <= 2) {
            //do nothing
        } else if (rndNumber >= 3) {
            this.lastWeather = WeatherType.getWeatherByAlertLevel(alertLevel + 1);
        }
    }

    public Weather getWeather() {
        return this.weather;
    }

    @Override
    public void timePassBy() {
        this.generateWeater();

        switch (lastWeather) {
            case SUNNY:
                this.weather = new Sunny();
                break;
            case RAINY:
                this.weather = new Rainy();
                break;
            case HEAVY_RAINY:
                this.weather = new HeavyRainy();
                break;
            case SNOWY:
                this.weather = new Snowy();
                break;
            case CLOUDY:
                this.weather = new Cloudy();
                break;
        }
    }

}
