//PackageData.java
import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<City> cities;
    ArrayList<Aircraft> aircrafts;
    Aircraft aircraft;
    City city;
    Long cityID;
    Long aircraftID;
    ArrayList<Flight> flights;
    Flight flight;
    Long flightID;
    Ticket ticket;
    ArrayList<Ticket> tickets;
    Long ticketID;

    public PackageData(){
        this.operationType = "None";
    }

    public PackageData(String operationType){
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public City getCity() {
        return city;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getCityID() {
        return cityID;
    }

    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Long getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(Long aircraftID) {
        this.aircraftID = aircraftID;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public Flight getFlight() {
        return flight;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public Long getTicketID() {
        return ticketID;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}

