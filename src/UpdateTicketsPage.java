import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UpdateTicketsPage extends JPanel {

    private KassirFrame parent;

    private JLabel idlabel;
    private JLabel flight_idlabel;
    private JLabel namelabel;
    private JLabel surnamelabel;
    private JLabel passport_numberlabel;
    private JLabel ticket_typelabel;
    private JTextField idtextField;
    private JTextField Flight_idtextField;
    private JComboBox TicketsBox;
    private JComboBox FlightsBox;
    private String[] flights = new String[100];
    private Long[] flightsIDs = new Long[100];
    private String[] tickets = new String[100];
    private Long[] ticketsIDs = new Long[100];
    private JTextField NametextField;
    private JTextField SurnametextField;
    private JTextField Passport_numbertextField;
    private JTextField Ticket_typetextField;
    private JButton back;
    private JButton ADD;




    public UpdateTicketsPage(KassirFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        idlabel = new JLabel("ID:");
        idlabel.setSize(300,30);
        idlabel.setLocation(100,50);
        add(idlabel);

        flight_idlabel = new JLabel("FLIGHT ID:");
        flight_idlabel.setSize(300,30);
        flight_idlabel.setLocation(100,100);
        add(flight_idlabel);

        namelabel = new JLabel("Name:");
        namelabel.setSize(300,30);
        namelabel.setLocation(100,150);
        add(namelabel);

        surnamelabel = new JLabel("Surname:");
        surnamelabel.setSize(300,30);
        surnamelabel.setLocation(100,200);
        add(surnamelabel);


        passport_numberlabel = new JLabel("PASSPORT:");
        passport_numberlabel.setSize(300,30);
        passport_numberlabel.setLocation(100,250);
        add(passport_numberlabel);

        ticket_typelabel= new JLabel("TYPE:");
        ticket_typelabel.setSize(300,30);
        ticket_typelabel.setLocation(100,300);
        add(ticket_typelabel);



        NametextField = new JTextField();
        NametextField.setSize(300,30);
        NametextField.setLocation(170,150);
        add(NametextField);


        SurnametextField = new JTextField();
        SurnametextField.setSize(300,30);
        SurnametextField.setLocation(170,200);
        add(SurnametextField);

        Passport_numbertextField = new JTextField();
        Passport_numbertextField.setSize(300,30);
        Passport_numbertextField.setLocation(170,250);
        add(Passport_numbertextField);

        Ticket_typetextField = new JTextField();
        Ticket_typetextField.setSize(300,30);
        Ticket_typetextField.setLocation(170,300);
        add(Ticket_typetextField);

        ADD = new JButton("Add");
        ADD.setSize(100,30);
        ADD.setLocation(150,400);
        add(ADD);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ticket = (String)TicketsBox.getSelectedItem();
                Long ticket_id = ticketsIDs[(Integer)TicketsBox.getSelectedIndex()];
                String flight = (String)FlightsBox.getSelectedItem();
                Long flight_id = flightsIDs[(Integer)FlightsBox.getSelectedIndex()];
                String name = NametextField.getText();
                String surname = SurnametextField.getText();
                String pass_num = Passport_numbertextField.getText();
                String ticket_type = Ticket_typetextField.getText();

                TicketsBox.setSelectedIndex(0);
                FlightsBox.setSelectedIndex(0);
                NametextField.setText("");
                SurnametextField.setText("");
                Passport_numbertextField.setText("");
                Ticket_typetextField.setText("");
                if(!ticket.equals("") && !flight.equals("") && !name.equals("") && !surname.equals("") && !pass_num.equals("") && !ticket_type.equals("")){
                    PackageData request = new PackageData();
                    request.setOperationType("update_ticket");
                    request.setTicket(new Ticket(ticket_id,flight_id, name, surname, pass_num, ticket_type));
                    try{
                        parent.getConnectPage().outputStream.writeObject(request);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(300,400);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getUpdateTicketsPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });
    }

    public void generateComboboxes(){
        PackageData request_for_tickets = new PackageData();
        request_for_tickets.setOperationType("list_tickets");
        try {
            parent.getConnectPage().outputStream.writeObject(request_for_tickets);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectPage().inputStream.readObject())!=null) {
                if (response.getTickets() != null) {
                    tickets = new String[response.getTickets().size()];
                    ticketsIDs = new Long[response.getTickets().size()];
                    for(int i = 0;i<response.getTickets().size();i++){
                        tickets[i] = response.getTickets().get(i).getName()+" "+response.getTickets().get(i).getSurname()+" "+response.getTickets().get(i).getPassport_number();
                        ticketsIDs[i] = response.getTickets().get(i).getId();
                    }

                }
            }
        }
        catch (Exception e){

        }

        TicketsBox = new JComboBox(tickets);
        TicketsBox.setSize(300,30);
        TicketsBox.setLocation(170,50);
        add(TicketsBox);

        PackageData request_for_flights = new PackageData();
        request_for_flights.setOperationType("list_flights");
        try {
            parent.getConnectPage().outputStream.writeObject(request_for_flights);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectPage().inputStream.readObject())!=null) {
                if (response.getFlights() != null) {
                    flights = new String[response.getFlights().size()];
                    flightsIDs = new Long[response.getFlights().size()];
                    for(int i = 0;i<response.getFlights().size();i++){
                        flights[i] = response.getFlights().get(i).getAircraft()+" "+response.getFlights().get(i).getDeparture_city()+" - "+response.getFlights().get(i).getArrival_city()+" "+response.getFlights().get(i).getDeparture_time();
                        flightsIDs[i] = response.getFlights().get(i).getId();
                    }

                }
            }
        }
        catch (Exception e){

        }

        FlightsBox = new JComboBox(flights);
        FlightsBox.setSize(300,30);
        FlightsBox.setLocation(170,100);
        add(FlightsBox);
    }


}

