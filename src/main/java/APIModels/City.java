package APIModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private Integer id;
    private String name;
    private Coord coord;
    private String country;
    private Integer population;
    private Integer timezone;
    private Integer sunrise;
    private Integer sunset;

    public City() {
        super();
    }

    public City(String name, Coord coord, String country) {
        this.name = name;
        this.coord = coord;
        this.country = country;
    }


    public City(Integer id, String name, Coord coord, String country, Integer population, Integer timezone, Integer sunrise, Integer sunset) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", timezone=" + timezone +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPopulation() {
        return population;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }
}
