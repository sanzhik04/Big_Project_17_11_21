import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CreateAircraftsPage extends JPanel {

    private AdminFrame parent;

    private JLabel namelabel;
    private JLabel modellabel;
    private JLabel business_class_capacitylabel;
    private JLabel econom_class_capacitylabel;
    private JTextField NametextField;
    private JTextField ModeltextField;
    private JTextField Business_class_capacitytextField;
    private JTextField econom_class_capacitytextField;
    private JButton back;
    private JButton ADD;




    public CreateAircraftsPage(AdminFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        namelabel = new JLabel("Name:");
        namelabel.setSize(300,30);
        namelabel.setLocation(100,50);
        add(namelabel);

        modellabel = new JLabel("Model:");
        modellabel.setSize(300,30);
        modellabel.setLocation(100,100);
        add(modellabel);

        business_class_capacitylabel = new JLabel("Business Class:");
        business_class_capacitylabel.setSize(300,30);
        business_class_capacitylabel.setLocation(100,150);
        add(business_class_capacitylabel);

        econom_class_capacitylabel = new JLabel("Econom Class:");
        econom_class_capacitylabel.setSize(300,30);
        econom_class_capacitylabel.setLocation(100,200);
        add(econom_class_capacitylabel);



        NametextField = new JTextField();
        NametextField.setSize(300,30);
        NametextField.setLocation(170,50);
        add(NametextField);

        ModeltextField = new JTextField();
        ModeltextField.setSize(300,30);
        ModeltextField.setLocation(170,100);
        add(ModeltextField);


        Business_class_capacitytextField = new JTextField();
        Business_class_capacitytextField.setSize(300,30);
        Business_class_capacitytextField.setLocation(170,150);
        add(Business_class_capacitytextField);

        econom_class_capacitytextField = new JTextField();
        econom_class_capacitytextField.setSize(300,30);
        econom_class_capacitytextField.setLocation(170,200);
        add(econom_class_capacitytextField);

        ADD = new JButton("Add");
        ADD.setSize(100,30);
        ADD.setLocation(150,400);
        add(ADD);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = NametextField.getText();
                String model = ModeltextField.getText();
                String business_class_capacity = Business_class_capacitytextField.getText();
                String econom_class_capacity = econom_class_capacitytextField.getText();

                NametextField.setText("");
                ModeltextField.setText("");
                Business_class_capacitytextField.setText("");
                econom_class_capacitytextField.setText("");
                if(!name.equals("") && !model.equals("") && !business_class_capacity.equals("") && !econom_class_capacity.equals("")){
                    PackageData request = new PackageData();
                    request.setOperationType("add_aircraft");
                    request.setAircraft(new Aircraft(null,name, model, Integer.parseInt(business_class_capacity), Integer.parseInt(econom_class_capacity)));
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
                parent.getCreateAircraftsPage().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
            }
        });
    }




}