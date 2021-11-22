//Menu.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu extends JPanel {

    private KassirFrame parent;

    private JButton CreateButton;
    private JButton ReadButton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JButton exitButton;



    public Menu(KassirFrame parent) {


        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        CreateButton = new JButton("CREATE TICKET");
        CreateButton.setSize(300,30);
        CreateButton.setLocation(100,100);
        add(CreateButton);
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenu().setVisible(false);
                parent.getCreateTicketsPage().setVisible(true);
                parent.getCreateTicketsPage().generateCombobox();

            }
        });

        ReadButton = new JButton("LIST TICKETS");
        ReadButton.setSize(300,30);
        ReadButton.setLocation(100,150);
        add(ReadButton);
        ReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenu().setVisible(false);
                parent.getReadTicketsPage().setVisible(true);
                parent.getReadTicketsPage().generateTable();


            }
        });

        UpdateButton = new JButton("UPDATE TICKET");
        UpdateButton.setSize(300,30);
        UpdateButton.setLocation(100,200);
        add(UpdateButton);
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenu().setVisible(false);
                parent.getUpdateTicketsPage().setVisible(true);
                parent.getUpdateTicketsPage().generateComboboxes();


            }
        });

        DeleteButton = new JButton("DELETE TICKET");
        DeleteButton.setSize(300,30);
        DeleteButton.setLocation(100,250);
        add(DeleteButton);
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenu().setVisible(false);
                parent.getDeleteTicketsPage().setVisible(true);
                parent.getDeleteTicketsPage().generateTable();


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

