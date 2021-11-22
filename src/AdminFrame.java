import javax.swing.*;

public class AdminFrame extends JFrame {
    private MainMenu mainMenuPage;
    private CitiesPage citiesPage;
    private AircraftsPage aircraftsPage;
    private ConnectionPage connectionPage;
    private FlightsPage flightsPage;
    private CreateCitiesPage createCitiesPage;
    private UpdateCitiesPage updateCitiesPage;
    private ReadCitiesPage readCitiesPage;
    private DeleteCitiesPage deleteCitiesPage;
    private CreateAircraftsPage createAircraftsPage;
    private UpdateAircraftsPage updateAircraftsPage;
    private ReadAircraftsPage readAircraftsPage;
    private DeleteAircraftsPage deleteAircraftsPage;
    private CreateFlightsPage createFlightsPage;
    private UpdateFlightsPage updateFlightsPage;
    private ReadFlightsPage readFlightsPage;
    private DeleteFlightsPage deleteFlightsPage;


    public AdminFrame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Menu");
        setSize(500,500);

        connectionPage = new ConnectionPage(this);
        connectionPage.setVisible(true);
        add(connectionPage);


        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(false);
        add(mainMenuPage);

        citiesPage = new CitiesPage(this);
        citiesPage.setVisible(false);
        add(citiesPage);

        aircraftsPage = new AircraftsPage(this);
        aircraftsPage.setVisible(false);
        add(aircraftsPage);

        flightsPage = new FlightsPage(this);
        flightsPage.setVisible(false);
        add(flightsPage);

        createCitiesPage = new CreateCitiesPage(this);
        createCitiesPage.setVisible(false);
        add(createCitiesPage);

        updateCitiesPage = new UpdateCitiesPage(this);
        updateCitiesPage.setVisible(false);
        add(updateCitiesPage);

        readCitiesPage = new ReadCitiesPage(this);
        readCitiesPage.setVisible(false);
        add(readCitiesPage);

        deleteCitiesPage = new DeleteCitiesPage(this);
        deleteCitiesPage.setVisible(false);
        add(deleteCitiesPage);

        createAircraftsPage = new CreateAircraftsPage(this);
        createAircraftsPage.setVisible(false);
        add(createAircraftsPage);

        updateAircraftsPage = new UpdateAircraftsPage(this);
        updateAircraftsPage.setVisible(false);
        add(updateAircraftsPage);

        readAircraftsPage = new ReadAircraftsPage(this);
        readAircraftsPage.setVisible(false);
        add(readAircraftsPage);

        deleteAircraftsPage = new DeleteAircraftsPage(this);
        deleteAircraftsPage.setVisible(false);
        add(deleteAircraftsPage);

        createFlightsPage = new CreateFlightsPage(this);
        createFlightsPage.setVisible(false);
        add(createFlightsPage);

        updateFlightsPage = new UpdateFlightsPage(this);
        updateFlightsPage.setVisible(false);
        add(updateFlightsPage);

        readFlightsPage = new ReadFlightsPage(this);
        readFlightsPage.setVisible(false);
        add(readFlightsPage);

        deleteFlightsPage = new DeleteFlightsPage(this);
        deleteFlightsPage.setVisible(false);
        add(deleteFlightsPage);





    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public ConnectionPage getConnectionPage() {
        return connectionPage;
    }

    public CitiesPage getCitiesPage() {
        return citiesPage;
    }

    public AircraftsPage getAircraftsPage() {
        return aircraftsPage;
    }

    public FlightsPage getFlightsPage() {
        return flightsPage;
    }

    public CreateCitiesPage getCreateCitiesPage() {
        return createCitiesPage;
    }

    public CreateAircraftsPage getCreateAircraftsPage() {
        return createAircraftsPage;
    }

    public CreateFlightsPage getCreateFlightsPage() {
        return createFlightsPage;
    }

    public DeleteAircraftsPage getDeleteAircraftsPage() {
        return deleteAircraftsPage;
    }

    public DeleteCitiesPage getDeleteCitiesPage() {
        return deleteCitiesPage;
    }

    public DeleteFlightsPage getDeleteFlightsPage() {
        return deleteFlightsPage;
    }

    public UpdateAircraftsPage getUpdateAircraftsPage() {
        return updateAircraftsPage;
    }

    public UpdateCitiesPage getUpdateCitiesPage() {
        return updateCitiesPage;
    }

    public UpdateFlightsPage getUpdateFlightsPage() {
        return updateFlightsPage;
    }

    public ReadAircraftsPage getReadAircraftsPage() {
        return readAircraftsPage;
    }

    public ReadCitiesPage getReadCitiesPage() {
        return readCitiesPage;
    }

    public ReadFlightsPage getReadFlightsPage() {
        return readFlightsPage;
    }
}
