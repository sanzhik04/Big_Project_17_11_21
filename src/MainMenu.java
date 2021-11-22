//MainMenu.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainMenu extends JPanel {

    private AdminFrame parent;

    private JButton CitiesButton;
    private JButton AircraftsButton;
    private JButton FlightsButton;
    private JButton exitButton;



    public MainMenu(AdminFrame parent) {


        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        CitiesButton = new JButton("CITIES");
        CitiesButton.setSize(300,30);
        CitiesButton.setLocation(100,100);
        add(CitiesButton);
        CitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getCitiesPage().setVisible(true);

            }
        });

        AircraftsButton = new JButton("AIRCRAFTS");
        AircraftsButton.setSize(300,30);
        AircraftsButton.setLocation(100,150);
        add(AircraftsButton);
        AircraftsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAircraftsPage().setVisible(true);



            }
        });

        FlightsButton = new JButton("FLIGHTS");
        FlightsButton.setSize(300,30);
        FlightsButton.setLocation(100,200);
        add(FlightsButton);
        FlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getFlightsPage().setVisible(true);



            }
        });




        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,250);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }


}
