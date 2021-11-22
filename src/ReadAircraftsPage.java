//SecondPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ReadAircraftsPage extends JPanel {

    private AdminFrame parent;



    private JLabel label;
    private JButton back;
    private JTextArea area;
    private JTable table;
    private JScrollPane scrollPane;
    private String header[] = {"Name","Model","Business","Econom"};

    public ReadAircraftsPage(AdminFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        label = new JLabel("LIST OF AIRCRAFTS");
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
                parent.getReadAircraftsPage().setVisible(false);
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

                    Object data[][] = new Object[response.getAircrafts().size()][4];

                    for(int i =0;i<response.getAircrafts().size();i++){
                        if(response.getAircrafts().get(i).getId()!=-1){
                            data[i][0] = response.getAircrafts().get(i).getName();
                            data[i][1] = response.getAircrafts().get(i).getModel();
                            data[i][2] = response.getAircrafts().get(i).getBusiness_class_capacity();
                            data[i][3] = response.getAircrafts().get(i).getEconom_class_capacity();
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
