import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FlightsPage extends JPanel {

    private AdminFrame parent;

    private JButton CreateFlight;
    private JButton ReadFlight;
    private JButton UpdateFlight;
    private JButton DeleteFlight;
    private JButton back;



    public FlightsPage(AdminFrame parent) {


        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        CreateFlight = new JButton("CREATE FLIGHT");
        CreateFlight.setSize(300,30);
        CreateFlight.setLocation(100,100);
        add(CreateFlight);
        CreateFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getCreateFlightsPage().setVisible(true);
                parent.getCreateFlightsPage().generateComboBoxes();
            }
        });

        ReadFlight = new JButton("LIST FLIGHTS");
        ReadFlight.setSize(300,30);
        ReadFlight.setLocation(100,150);
        add(ReadFlight);
        ReadFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getReadFlightsPage().setVisible(true);
                parent.getReadFlightsPage().generateTable();


            }
        });

        UpdateFlight = new JButton("UPDATE FLIGHT");
        UpdateFlight.setSize(300,30);
        UpdateFlight.setLocation(100,200);
        add(UpdateFlight);
        UpdateFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getUpdateFlightsPage().setVisible(true);
                parent.getUpdateFlightsPage().generateComboBoxes();


            }
        });

        DeleteFlight = new JButton("DELETE FLIGHT");
        DeleteFlight.setSize(300,30);
        DeleteFlight.setLocation(100,250);
        add(DeleteFlight);
        DeleteFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getDeleteFlightsPage().setVisible(true);
                parent.getDeleteFlightsPage().generateTable();


            }
        });




        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(100,300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }


}