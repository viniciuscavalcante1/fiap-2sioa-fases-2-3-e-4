package dao;
import java.sql.Connection;
import model.Band;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BandDAO {
    // Attribute to set the connection
    private Connection connection;

    // Method that will be used to insert a new band into the database
    public void insert(Band band) {
        // TODO: implement this method
        connection = DBManager.getConnection();
        try {
            PreparedStatement sqlStatement = connection.prepareStatement("INSERT INTO BANDS (id_band, nm_band," +
                    "genre_band) VALUES (SQ_BAND.NEXTVAL, ?, ?)");
        } catch (Exception SQLException) {
            SQLException.printStackTrace();
        }
    }

    // Method that will be used to update a band from the database
    public void update(Band band) {
        // TODO: implement this method
    }

    // Method that will be used to delete a band from the database
    public void delete(Band band) {
        // TODO: implement this method
    }

    // Method that will be used to search for a band from the database
    public Band search(Band band) {
        // TODO: implement this method
        return band;
    }
}
