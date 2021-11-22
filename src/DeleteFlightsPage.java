//SecondPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DeleteFlightsPage extends JPanel {

    private AdminFrame parent;



    private JLabel label;
    private JButton back;
    private JButton delete;
    private JTextField IDtextField;
    private JTable table;
    private JScrollPane scrollPane;
    private String header[] = {"ID","Aircraft","DEP_CITY","ARR_CITY","TIME","EC","BS"};

    public DeleteFlightsPage(AdminFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        label = new JLabel("LIST OF FLIGHTS   {}   SELECT ID YOU WANT TO DELETE");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        IDtextField = new JTextField();
        IDtextField.setSize(300,30);
        IDtextField.setLocation(100,150);
        add(IDtextField);

        delete = new JButton("Delete");
        delete.setSize(100,30);
        delete.setLocation(100,400);
        add(delete);

        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(300,400);
        add(back);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);




        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDtextField.getText();

                IDtextField.setText("");
                if(!id.equals("")){
                    PackageData request = new PackageData();
                    request.setOperationType("delete_flight");
                    request.setFlightID(Long.parseLong(id));
                    try{
                        parent.getConnectionPage().outputStream.writeObject(request);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getDeleteFlightsPage().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }
        });





    }



    public void generateTable(){

        PackageData request = new PackageData();
        request.setOperationType("list_flights");
        try{
            parent.getConnectionPage().outputStream.writeObject(request);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectionPage().inputStream.readObject())!=null){
                if(response.getFlights() != null) {

                    Object data[][] = new Object[response.getFlights().size()][7];

                    for(int i =0;i<response.getFlights().size();i++){
                        if(response.getFlights().get(i).getId()!=-1){
                            data[i][0] = response.getFlights().get(i).getId();
                            data[i][1] = response.getFlights().get(i).getAircraft();
                            data[i][2] = response.getFlights().get(i).getDeparture_city();
                            data[i][3] = response.getFlights().get(i).getArrival_city();
                            data[i][4] = response.getFlights().get(i).getDeparture_time();
                            data[i][5] = response.getFlights().get(i).getEconom_place_price();
                            data[i][6] = response.getFlights().get(i).getBusiness_place_price();
                        }
                    }

                    DefaultTableModel model = new DefaultTableModel(data, header);
                    table.setModel(model);
                }else if(response.getOperationType().equals("None")){
                    System.out.println("Wrong input!");
                }
            }
        }
        catch(Exception e){

        }


    }


}

