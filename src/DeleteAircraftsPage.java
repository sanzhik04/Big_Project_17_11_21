//SecondPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DeleteAircraftsPage extends JPanel {

    private AdminFrame parent;



    private JLabel label;
    private JButton back;
    private JButton delete;
    private JTextField IDtextField;
    private JTable table;
    private JScrollPane scrollPane;
    private String header[] = {"ID","Name","Model","Business","Econom"};

    public DeleteAircraftsPage(AdminFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        label = new JLabel("LIST OF AIRCRAFTS   {}   SELECT ID YOU WANT TO DELETE");
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
                    request.setOperationType("delete_aircraft");
                    request.setAircraftID(Long.parseLong(id));
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
                parent.getDeleteAircraftsPage().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
            }
        });





    }



    public void generateTable(){

        PackageData request = new PackageData();
        request.setOperationType("list_aircrafts");
        try{
            parent.getConnectionPage().outputStream.writeObject(request);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectionPage().inputStream.readObject())!=null){
                if(response.getAircrafts() != null) {

                    Object data[][] = new Object[response.getAircrafts().size()][5];

                    for(int i =0;i<response.getAircrafts().size();i++){
                        if(response.getAircrafts().get(i).getId()!=-1){
                            data[i][0] = response.getAircrafts().get(i).getId();
                            data[i][1] = response.getAircrafts().get(i).getName();
                            data[i][2] = response.getAircrafts().get(i).getModel();
                            data[i][3] = response.getAircrafts().get(i).getBusiness_class_capacity();
                            data[i][4] = response.getAircrafts().get(i).getEconom_class_capacity();
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
