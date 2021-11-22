//SecondPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ReadTicketsPage extends JPanel {

    private KassirFrame parent;



    private JLabel label;
    private JButton back;
    private JTextArea area;
    private JTable table;
    private JScrollPane scrollPane;
    private String header[] = {"FLIGHT ID","NAME","SURNAME","PASS NUM","TYPE"};

    public ReadTicketsPage(KassirFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        label = new JLabel("LIST OF TICKETS");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

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




        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getReadTicketsPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });





    }



    public void generateTable(){

        PackageData request = new PackageData();
        request.setOperationType("list_tickets");
        try{
            parent.getConnectPage().outputStream.writeObject(request);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectPage().inputStream.readObject())!=null){
                if(response.getTickets() != null) {

                    Object data[][] = new Object[response.getTickets().size()][5];

                    for(int i =0;i<response.getTickets().size();i++){
                        if(response.getTickets().get(i).getId()!=-1){
                            data[i][0] = response.getTickets().get(i).getFlight_id();
                            data[i][1] = response.getTickets().get(i).getName();
                            data[i][2] = response.getTickets().get(i).getSurname();
                            data[i][3] = response.getTickets().get(i).getPassport_number();
                            data[i][4] = response.getTickets().get(i).getTicket_type();
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


