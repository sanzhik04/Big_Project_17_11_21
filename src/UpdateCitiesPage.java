import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UpdateCitiesPage extends JPanel {

    private AdminFrame parent;

    private JLabel IDlabel;
    private JLabel namelabel;
    private JLabel countrylabel;
    private JLabel short_namelabel;
    private JTextField IDtextField;
    private JTextField NametextField;
    private JTextField CountrytextField;
    private JTextField Short_nametextField;
    private JButton back;
    private JButton ADD;




    public UpdateCitiesPage(AdminFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        IDlabel = new JLabel("ID:");
        IDlabel.setSize(300,30);
        IDlabel.setLocation(100,50);
        add(IDlabel);

        namelabel = new JLabel("Name:");
        namelabel.setSize(300,30);
        namelabel.setLocation(100,100);
        add(namelabel);

        countrylabel = new JLabel("Country:");
        countrylabel.setSize(300,30);
        countrylabel.setLocation(100,150);
        add(countrylabel);

        short_namelabel = new JLabel("Short Name:");
        short_namelabel.setSize(300,30);
        short_namelabel.setLocation(100,200);
        add(short_namelabel);

        IDtextField = new JTextField();
        IDtextField.setSize(300,30);
        IDtextField.setLocation(170,50);
        add(IDtextField);

        NametextField = new JTextField();
        NametextField.setSize(300,30);
        NametextField.setLocation(170,100);
        add(NametextField);

        CountrytextField = new JTextField();
        CountrytextField.setSize(300,30);
        CountrytextField.setLocation(170,150);
        add(CountrytextField);


        Short_nametextField = new JTextField();
        Short_nametextField.setSize(300,30);
        Short_nametextField.setLocation(170,200);
        add(Short_nametextField);

        ADD = new JButton("Add");
        ADD.setSize(100,30);
        ADD.setLocation(150,400);
        add(ADD);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ID = IDtextField.getText();
                String name = NametextField.getText();
                String country = CountrytextField.getText();
                String short_name = Short_nametextField.getText();

                IDtextField.setText("");
                NametextField.setText("");
                CountrytextField.setText("");
                Short_nametextField.setText("");
                if(!name.equals("") && !country.equals("") && !short_name.equals("") && !ID.equals("")){
                    PackageData request = new PackageData();
                    request.setOperationType("update_city");
                    request.setCity(new City(Long.parseLong(ID),name, country, short_name));
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
                parent.getUpdateCitiesPage().setVisible(false);
                parent.getCitiesPage().setVisible(true);
            }
        });
    }




}
