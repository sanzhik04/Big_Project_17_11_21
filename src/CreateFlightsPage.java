import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateFlightsPage extends JPanel {

    private AdminFrame parent;

    private JLabel aircraft_idlabel;
    private JLabel departure_city_idlabel;
    private JLabel arrival_city_idlabel;
    private JLabel departure_timelabel;
    private JLabel econom_place_pricelabel;
    private JLabel business_place_pricelabel;
    private JTextField Aircraft_idtextField;
    private JTextField Departure_city_idtextField;
    private JTextField Arrival_city_idtextField;
    private JTextField Departure_timetextField;
    private JTextField Econom_place_priceField;
    private JTextField business_place_pricetextField;
    private JComboBox AircraftsBox;
    private JComboBox Dep_citiesBox;
    private JComboBox Arr_citiesBox;
    private String[] aircrafts;
    private String[] arr_cities;
    private String[] dep_cities;
    private Long[] aircraftsIDs;
    private Long[] arr_citiesIDs;
    private Long[] dep_citiesIDs;
    private JButton back;
    private JButton ADD;




    public CreateFlightsPage(AdminFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        aircraft_idlabel = new JLabel("Aircraft ID:");
        aircraft_idlabel.setSize(300,30);
        aircraft_idlabel.setLocation(100,50);
        add(aircraft_idlabel);

        departure_city_idlabel = new JLabel("DEP ID:");
        departure_city_idlabel.setSize(300,30);
        departure_city_idlabel.setLocation(100,100);
        add(departure_city_idlabel);

        arrival_city_idlabel = new JLabel("ARR ID:");
        arrival_city_idlabel.setSize(300,30);
        arrival_city_idlabel.setLocation(100,150);
        add(arrival_city_idlabel);

        departure_timelabel = new JLabel("DEP TIME:");
        departure_timelabel.setSize(300,30);
        departure_timelabel.setLocation(100,200);
        add(departure_timelabel);

        econom_place_pricelabel = new JLabel("EC PRICE:");
        econom_place_pricelabel.setSize(300,30);
        econom_place_pricelabel.setLocation(100,250);
        add(econom_place_pricelabel);


        business_place_pricelabel = new JLabel("BS PRICE:");
        business_place_pricelabel.setSize(300,30);
        business_place_pricelabel.setLocation(100,300);
        add(business_place_pricelabel);




        Departure_timetextField = new JTextField();
        Departure_timetextField.setSize(300,30);
        Departure_timetextField.setLocation(170,200);
        add(Departure_timetextField);

        Econom_place_priceField = new JTextField();
        Econom_place_priceField.setSize(300,30);
        Econom_place_priceField.setLocation(170,250);
        add(Econom_place_priceField);

        business_place_pricetextField = new JTextField();
        business_place_pricetextField.setSize(300,30);
        business_place_pricetextField.setLocation(170,300);
        add(business_place_pricetextField);



        ADD = new JButton("Add");
        ADD.setSize(100,30);
        ADD.setLocation(150,400);
        add(ADD);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String aircraft = (String)AircraftsBox.getSelectedItem();
                Long aircraft_id = aircraftsIDs[(Integer)AircraftsBox.getSelectedIndex()];

                String dep_city = (String)Dep_citiesBox.getSelectedItem();
                Long dep_city_id = dep_citiesIDs[(Integer)Dep_citiesBox.getSelectedIndex()];

                String arr_city = (String)Arr_citiesBox.getSelectedItem();
                Long arr_city_id = arr_citiesIDs[(Integer)Arr_citiesBox.getSelectedIndex()];

                String dep_time = Departure_timetextField.getText();
                String ec_price = Econom_place_priceField.getText();
                String bs_price = business_place_pricetextField.getText();

                AircraftsBox.setSelectedIndex(0);
                Dep_citiesBox.setSelectedIndex(0);
                Arr_citiesBox.setSelectedIndex(0);
                Departure_timetextField.setText("");
                Econom_place_priceField.setText("");
                business_place_pricetextField.setText("");
                if(!aircraft.equals("") && !dep_city.equals("") && !arr_city.equals("") && !dep_time.equals("") && !ec_price.equals("") && !bs_price.equals("")){
                    PackageData request = new PackageData();
                    request.setOperationType("add_flight");
                    request.setFlight(new Flight(null,aircraft_id, dep_city_id, arr_city_id, dep_time, Integer.parseInt(ec_price),Integer.parseInt(bs_price)));
                    try{
                        parent.getConnectionPage().outputStream.writeObject(request);
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
                parent.getCreateFlightsPage().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }
        });
    }


    public void generateComboBoxes(){

        PackageData request = new PackageData();
        request.setOperationType("list_aircrafts");
        try {
            parent.getConnectionPage().outputStream.writeObject(request);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectionPage().inputStream.readObject())!=null) {
                if (response.getAircrafts() != null) {
                    aircrafts = new String[response.getAircrafts().size()];
                    aircraftsIDs = new Long[response.getAircrafts().size()];
                    for(int i = 0;i<response.getAircrafts().size();i++){
                        aircrafts[i] = response.getAircrafts().get(i).getName();
                        aircraftsIDs[i] = response.getAircrafts().get(i).getId();
                    }

                }
            }
        }
        catch (Exception e){

        }

        AircraftsBox = new JComboBox(aircrafts);
        AircraftsBox.setSize(300,30);
        AircraftsBox.setLocation(170,50);
        add(AircraftsBox);

        PackageData request2 = new PackageData();
        request2.setOperationType("list_cities");
        try {
            parent.getConnectionPage().outputStream.writeObject(request2);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectionPage().inputStream.readObject())!=null) {
                if (response.getCities() != null) {
                    dep_cities = new String[response.getCities().size()];
                    arr_cities = new String[response.getCities().size()];
                    dep_citiesIDs = new Long[response.getCities().size()];
                    arr_citiesIDs = new Long[response.getCities().size()];
                    for(int i = 0;i<response.getCities().size();i++){
                        dep_cities[i] = response.getCities().get(i).getName();
                        arr_cities[i] = response.getCities().get(i).getName();
                        dep_citiesIDs[i] = response.getCities().get(i).getId();
                        arr_citiesIDs[i] = response.getCities().get(i).getId();
                    }

                }
            }
        }
        catch (Exception e){

        }

        Dep_citiesBox = new JComboBox(dep_cities);
        Dep_citiesBox.setSize(300,30);
        Dep_citiesBox.setLocation(170,100);
        add(Dep_citiesBox);


        Arr_citiesBox = new JComboBox(arr_cities);
        Arr_citiesBox.setSize(300,30);
        Arr_citiesBox.setLocation(170,150);
        add(Arr_citiesBox);
    }

}

