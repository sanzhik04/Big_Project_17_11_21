import javax.swing.*;

public class KassirFrame extends JFrame {
    private ConnectPage connectionPage;
    private Menu mainMenu;
    private CreateTicketsPage createTicketsPage;
    private ReadTicketsPage readTicketsPage;
    private UpdateTicketsPage updateTicketsPage;
    private DeleteTicketsPage deleteTicketsPage;

    public KassirFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kassir Menu");
        setSize(500,500);

        connectionPage = new ConnectPage(this);
        connectionPage.setVisible(true);
        add(connectionPage);

        mainMenu = new Menu(this);
        mainMenu.setVisible(false);
        add(mainMenu);

        createTicketsPage = new CreateTicketsPage(this);
        createTicketsPage.setVisible(false);
        add(createTicketsPage);

        readTicketsPage = new ReadTicketsPage(this);
        readTicketsPage.setVisible(false);
        add(readTicketsPage);

        updateTicketsPage = new UpdateTicketsPage(this);
        updateTicketsPage.setVisible(false);
        add(updateTicketsPage);

        deleteTicketsPage = new DeleteTicketsPage(this);
        deleteTicketsPage.setVisible(false);
        add(deleteTicketsPage);

    }


    public ConnectPage getConnectPage() {
        return connectionPage;
    }

    public CreateTicketsPage getCreateTicketsPage() {
        return createTicketsPage;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public ReadTicketsPage getReadTicketsPage() {
        return readTicketsPage;
    }

    public DeleteTicketsPage getDeleteTicketsPage() {
        return deleteTicketsPage;
    }

    public UpdateTicketsPage getUpdateTicketsPage() {
        return updateTicketsPage;
    }


}
