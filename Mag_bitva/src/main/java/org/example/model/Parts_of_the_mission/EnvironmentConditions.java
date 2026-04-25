package org.example.model.Parts_of_the_mission;
import org.example.model.enums.Visibility;

public class EnvironmentConditions {
    private String weather;
    private String timeOfDay;
    private Visibility visibility;
    private Double cursedEnergyDensity;

    public EnvironmentConditions() {
        this.weather = "";
        this.timeOfDay = "";
        this.visibility = Visibility.UNKNOWN;
        this.cursedEnergyDensity = 0.0;
    }

    public EnvironmentConditions(String weather, String timeOfDay,
                                 Visibility visibility, Double cursedEnergyDensity) {
        this.weather = weather;
        this.timeOfDay = timeOfDay;
        this.visibility = visibility;
        this.cursedEnergyDensity = cursedEnergyDensity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Double getCursedEnergyDensity() {
        return cursedEnergyDensity;
    }

    public void setCursedEnergyDensity(Double cursedEnergyDensity) {
        this.cursedEnergyDensity = cursedEnergyDensity;
    }
}
