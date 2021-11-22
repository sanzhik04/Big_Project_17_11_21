//SecondPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ReadCitiesPage extends JPanel {

    private AdminFrame parent;



    private JLabel label;
    private JButton back;
    private JTextArea area;
    private JTable table;
    private JScrollPane scrollPane;
    private String header[] = {"Name","Country","Short Name"};

    public ReadCitiesPage(AdminFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        label = new JLabel("LIST OF CITIES");
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
                parent.getReadCitiesPage().setVisible(false);
                parent.getCitiesPage().setVisible(true);
            }
        });





    }



    public void generateTable(){

        PackageData request = new PackageData();
        request.setOperationType("list_cities");
        try{
            parent.getConnectionPage().outputStream.writeObject(request);
            PackageData response = null;
            if((response = (PackageData) parent.getConnectionPage().inputStream.readObject())!=null){
                if(response.getCities() != null) {

                    Object data[][] = new Object[response.getCities().size()][3];

                    for(int i =0;i<response.getCities().size();i++){
                        if(response.getCities().get(i).getId()!=-1){
                            data[i][0] = response.getCities().get(i).getName();
                            data[i][1] = response.getCities().get(i).getCountry();
                            data[i][2] = response.getCities().get(i).getShort_name();
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
