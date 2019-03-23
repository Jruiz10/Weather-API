package edu.quinnipiac.ser210.weather;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONDataHandler {


    public String getWeatherData(String JSONString) throws JSONException {
        String name,country,temp,mintemp,maxtemp,speed,degree,description;
        JSONObject weatherData = new JSONObject(JSONString);

        JSONObject main = weatherData.getJSONArray("list").getJSONObject(0).getJSONObject("main");
        JSONObject wind = weatherData.getJSONArray("list").getJSONObject(0).getJSONObject("wind");
        JSONObject weather = weatherData.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0);

        name = weatherData.getJSONArray("list").getJSONObject(0).getString("name");
        country = weatherData.getJSONArray("list").getJSONObject(0).getJSONObject("sys").getString("country");
        temp = main.getString("temp");
        mintemp = main.getString("temp_min");
        maxtemp = main.getString("temp_max");
        speed = wind.getString("speed");
        degree = wind.getString("deg");
        description = weather.getString("description");

        String toset = "" + name + " " + country
                + "\nTemperature: " + temp + "°F"
                + "\nMinimum Temperature: " + mintemp + "°F"
                + "\nMaximum Temperature: " + maxtemp + "°F"
                + "\nWind: "
                + "\n   Speed: " + speed
                + "\n   Degree:" + degree + "°"
                + "\nDescription: " + description;
        return toset;

    }
}