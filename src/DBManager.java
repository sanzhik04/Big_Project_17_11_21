//DBManager.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBManager{

    private Connection connection;

    public void connect(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project_data?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("DATABASE CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<City> getAllCities(){
        ArrayList<City> cities = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");

            ResultSet rs = st.executeQuery();

            while (rs.next()){

                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");



                cities.add(new City(id,name,country,short_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cities;
    }

    public void addCity(City city){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id, name, country, short_name) values(NULL,?,?,?)");

            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShort_name());


            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCity(City city){
        try{

            PreparedStatement st = connection.prepareStatement("UPDATE cities set name = ?, country = ?, short_name = ? where id = ?");

            st.setString(1, city.getName());
            st.setString(2, city.getCountry());
            st.setString(3, city.getShort_name());
            st.setLong(4, city.getId());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCity(Long id){
        try{

            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id = ?");

            st.setLong(1, id);

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Aircraft> getAllAircrafts(){
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");

            ResultSet rs = st.executeQuery();

            while (rs.next()){

                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity  = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");



                aircrafts.add(new Aircraft(id,name,model,business_class_capacity, econom_class_capacity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return aircrafts;
    }


    public void addAircraft(Aircraft aircraft){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id, name, model, business_class_capacity, econom_class_capacity) values(NULL,?,?,?,?)");

            st.setString(1,aircraft.getName());
            st.setString(2,aircraft.getModel());
            st.setInt(3,aircraft.getBusiness_class_capacity());
            st.setInt(4,aircraft.getEconom_class_capacity());


            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateAircraft(Aircraft aircraft){
        try{

            PreparedStatement st = connection.prepareStatement("UPDATE aircrafts set name = ?, model = ?, business_class_capacity = ?, econom_class_capacity = ? where id = ?");

            st.setString(1, aircraft.getName());
            st.setString(2, aircraft.getModel());
            st.setInt(3, aircraft.getBusiness_class_capacity());
            st.setInt(4, aircraft.getEconom_class_capacity());
            st.setLong(5,aircraft.getId());

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAircraft(Long id){
        try{

            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where id = ?");

            st.setLong(1, id);

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Flight> getAllFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(
                    "SELECT flights.id, a.name, c.short_name, cities.short_name, " +
                            "flights.departure_time, flights.econom_place_price, " +
                            "flights.business_place_price from flights " +
                            "inner join aircrafts a on flights.aircraft_id = a.id " +
                            "inner join cities c on flights.departure_city_id = c.id " +
                            "inner join cities cities on flights.arrival_city_id = cities.id"
            );



            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Flight flight = new Flight();
                Long id = rs.getLong(1);
                String aircraft = rs.getString(2);
                String dep_city = rs.getString(3);
                String arr_city = rs.getString(4);
                String dep_time = rs.getString(5);
                int ec_price = rs.getInt(6);
                int bs_price = rs.getInt(7);

                flight.setAircraft(aircraft);
                flight.setId(id);
                flight.setDeparture_city(dep_city);
                flight.setArrival_city(arr_city);
                flight.setDeparture_time(dep_time);
                flight.setEconom_place_price(ec_price);
                flight.setBusiness_place_price(bs_price);



                flights.add(flight);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flights;
    }

    public void addFlight(Flight flight){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price) values(NULL,?,?,?,?,?,?)");

            st.setLong(1,flight.getAircraft_id());
            st.setLong(2,flight.getDeparture_city_id());
            st.setLong(3,flight.getArrival_city_id());
            st.setString(4,flight.getDeparture_time());
            st.setInt(5,flight.getEconom_place_price());
            st.setInt(6,flight.getBusiness_place_price());


            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateFlight(Flight flight){
        try{

            PreparedStatement st = connection.prepareStatement("UPDATE flights set aircraft_id = ?, departure_city_id = ?, arrival_city_id = ?, departure_time = ?, econom_place_price = ?, business_place_price = ? where id = ?");

            st.setLong(1, flight.getAircraft_id());
            st.setLong(2, flight.getDeparture_city_id());
            st.setLong(3, flight.getArrival_city_id());
            st.setString(4, flight.getDeparture_time());
            st.setInt(5,flight.getEconom_place_price());
            st.setInt(6,flight.getBusiness_place_price());
            st.setLong(7,flight.getId());
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteFlight(Long id){
        try{

            PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id = ?");

            st.setLong(1, id);

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<Ticket> getAllTickets(){
        ArrayList<Ticket> tickets = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");


            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Long id = rs.getLong(1);
                Long flight_id = rs.getLong(2);
                String name = rs.getString(3);
                String surname = rs.getString(4);
                String pass_num = rs.getString(5);
                String ticket_type = rs.getString(6);





                tickets.add(new Ticket(id,flight_id,name, surname, pass_num, ticket_type));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return tickets;
    }


    public void addTicket(Ticket ticket){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(id, flight_id, name, surname, passport_number, ticket_type) values(NULL,?,?,?,?,?)");

            st.setLong(1,ticket.getFlight_id());
            st.setString(2,ticket.getName());
            st.setString(3,ticket.getSurname());
            st.setString(4,ticket.getPassport_number());
            st.setString(5,ticket.getTicket_type());


            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateTicket(Ticket ticket){
        try{

            PreparedStatement st = connection.prepareStatement("UPDATE tickets set flight_id = ?, name = ?, surname = ?, passport_number = ?, ticket_type = ?  where id = ?");

            st.setLong(1, ticket.getFlight_id());
            st.setString(2, ticket.getName());
            st.setString(3, ticket.getSurname());
            st.setString(4, ticket.getPassport_number());
            st.setString(5,ticket.getTicket_type());
            st.setLong(6,ticket.getId());
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteTicket(Long id){
        try{

            PreparedStatement st = connection.prepareStatement("DELETE FROM tickets where id = ?");

            st.setLong(1, id);

            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}

