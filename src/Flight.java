import java.io.Serializable;

public class Flight implements Serializable {
    Long id;
    Long aircraft_id;
    String aircraft;
    Long departure_city_id;
    String departure_city;
    Long arrival_city_id;
    String arrival_city;
    String departure_time;
    int econom_place_price;
    int business_place_price;



    public Flight(){

    }

    public Flight(Long id, Long aircraft_id, Long departure_city_id, Long arrival_city_id, String departure_time, int econom_place_price, int business_place_price){
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.econom_place_price = econom_place_price;
        this.business_place_price = business_place_price;
    }


    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAircraft() {
        return aircraft;
    }

    public int getBusiness_place_price() {
        return business_place_price;
    }

    public String getDeparture_city() {
        return departure_city;
    }


    public String getArrival_city() {
        return arrival_city;
    }

    public int getEconom_place_price() {
        return econom_place_price;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public void setBusiness_place_price(int business_place_price) {
        this.business_place_price = business_place_price;
    }


    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public void setEconom_place_price(int econom_place_price) {
        this.econom_place_price = econom_place_price;
    }

    public Long getAircraft_id() {
        return aircraft_id;
    }

    public Long getDeparture_city_id() {
        return departure_city_id;
    }

    public void setAircraft_id(Long aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public void setDeparture_city_id(Long departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public Long getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(Long arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }
}
