//ClientHandler.java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    public DBManager db;


    public ClientHandler(Socket socket, int id, DBManager db){
        this.id = id;
        this.socket = socket;
        this.db = db;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData response  = null;
            while ((response = (PackageData) inputStream.readObject()) != null) {
                if(response.getOperationType().equals("list_cities")){
                    response.setCities(db.getAllCities());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_city")){
                    db.addCity(response.getCity());
                }
                else if(response.getOperationType().equals("update_city")){
                    db.updateCity(response.getCity());
                }
                else if(response.getOperationType().equals("delete_city")){
                    db.deleteCity(response.getCityID());
                }
                else if(response.getOperationType().equals("list_aircrafts")){
                    response.setAircrafts(db.getAllAircrafts());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_aircraft")){
                    db.addAircraft(response.getAircraft());
                }
                else if(response.getOperationType().equals("update_aircraft")){
                    db.updateAircraft(response.getAircraft());
                }
                else if(response.getOperationType().equals("delete_aircraft")){
                    db.deleteAircraft(response.getAircraftID());
                }
                else if(response.getOperationType().equals("list_flights")){
                    response.setFlights(db.getAllFlights());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_flight")){
                    db.addFlight(response.getFlight());
                }
                else if(response.getOperationType().equals("update_flight")){
                    db.updateFlight(response.getFlight());
                }
                else if(response.getOperationType().equals("delete_flight")){
                    db.deleteFlight(response.getFlightID());
                }
                else if(response.getOperationType().equals("list_tickets")){
                    response.setTickets(db.getAllTickets());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_ticket")){
                    db.addTicket(response.getTicket());
                }
                else if(response.getOperationType().equals("update_ticket")){
                    db.updateTicket(response.getTicket());
                }
                else if(response.getOperationType().equals("delete_ticket")){
                    db.deleteTicket(response.getTicketID());
                }
                else{
                    response.setOperationType("None");
                    outputStream.writeObject(response);
                }
            }
        }
        catch(Exception e){

        }

    }



}
