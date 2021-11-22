import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AircraftsPage extends JPanel {

    private AdminFrame parent;

    private JButton CreateAircraft;
    private JButton ReadAircraft;
    private JButton UpdateAircraft;
    private JButton DeleteAircraft;
    private JButton back;



    public AircraftsPage(AdminFrame parent) {


        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        CreateAircraft = new JButton("CREATE AIRCRAFT");
        CreateAircraft.setSize(300,30);
        CreateAircraft.setLocation(100,100);
        add(CreateAircraft);
        CreateAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getCreateAircraftsPage().setVisible(true);

            }
        });

        ReadAircraft = new JButton("LIST AIRCRAFTS");
        ReadAircraft.setSize(300,30);
        ReadAircraft.setLocation(100,150);
        add(ReadAircraft);
        ReadAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getReadAircraftsPage().setVisible(true);
                parent.getReadAircraftsPage().generateTable();


            }
        });

        UpdateAircraft = new JButton("UPDATE AIRCRAFT");
        UpdateAircraft.setSize(300,30);
        UpdateAircraft.setLocation(100,200);
        add(UpdateAircraft);
        UpdateAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getUpdateAircraftsPage().setVisible(true);



            }
        });

        DeleteAircraft = new JButton("DELETE AIRCRAFT");
        DeleteAircraft.setSize(300,30);
        DeleteAircraft.setLocation(100,250);
        add(DeleteAircraft);
        DeleteAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getDeleteAircraftsPage().setVisible(true);
                parent.getDeleteAircraftsPage().generateTable();


            }
        });




        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(100,300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }


}