import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CitiesPage extends JPanel {

    private AdminFrame parent;

    private JButton CreateCity;
    private JButton ReadCity;
    private JButton UpdateCity;
    private JButton DeleteCity;
    private JButton back;



    public CitiesPage(AdminFrame parent) {


        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        CreateCity = new JButton("CREATE CITY");
        CreateCity.setSize(300,30);
        CreateCity.setLocation(100,100);
        add(CreateCity);
        CreateCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getCreateCitiesPage().setVisible(true);

            }
        });

        ReadCity = new JButton("LIST CITIES");
        ReadCity.setSize(300,30);
        ReadCity.setLocation(100,150);
        add(ReadCity);
        ReadCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getReadCitiesPage().setVisible(true);
                parent.getReadCitiesPage().generateTable();



            }
        });

        UpdateCity = new JButton("UPDATE CITY");
        UpdateCity.setSize(300,30);
        UpdateCity.setLocation(100,200);
        add(UpdateCity);
        UpdateCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getUpdateCitiesPage().setVisible(true);



            }
        });

        DeleteCity = new JButton("DELETE CITY");
        DeleteCity.setSize(300,30);
        DeleteCity.setLocation(100,250);
        add(DeleteCity);
        DeleteCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getDeleteCitiesPage().setVisible(true);
                parent.getDeleteCitiesPage().generateTable();



            }
        });




        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(100,300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }


}