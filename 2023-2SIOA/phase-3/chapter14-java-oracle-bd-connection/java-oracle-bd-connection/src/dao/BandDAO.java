package dao;
import java.sql.Connection;
import model.Band;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BandDAO {
    // Attribute to set the connection
    private Connection connection;

    // Method that will be used to insert a new band into the database
    public void insert(Band band) {
        connection = DBManager.getConnection();
        try {
            PreparedStatement sqlStatement = connection.prepareStatement("INSERT INTO BANDS (id_band, nm_band," +
                    "genre_band) VALUES (SQ_BAND.NEXTVAL, ?, ?)");
            sqlStatement.setString(1, band.getName());
            sqlStatement.setString(2, band.getGenre());
            sqlStatement.executeUpdate();
            sqlStatement.close();
            connection.close();
        } catch (Exception SQLException) {
            SQLException.printStackTrace();
        }
    }

    // Method that will be used to update a band from the database
    public void update(Band band) {
        connection = DBManager.getConnection();
        PreparedStatement sqlStatement;
        try {
            sqlStatement = connection.prepareStatement("UPDATE BANDS SET nm_band = ?, genre_band = ? WHERE id_band = ?");
            sqlStatement.setString(1, band.getName());
            sqlStatement.setString(2, band.getGenre());
            sqlStatement.setInt(3, band.getId());
            sqlStatement.executeUpdate();
            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method that will be used to delete a band from the database
    public void delete(Band band) {
        connection = DBManager.getConnection();
        PreparedStatement sqlStatement;
        try {
            sqlStatement = connection.prepareStatement("DELETE FROM BANDS WHERE id_band = ?");
            sqlStatement.setInt(1, band.getId());
            sqlStatement.executeUpdate();
            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method that will be used to search for a band from the database
    public Band search(Band band) {
        connection = DBManager.getConnection();
        PreparedStatement sqlStatement;

        try {
            sqlStatement = connection.prepareStatement("SELECT * FROM BANDS WHERE id_band = ?");
            sqlStatement.setInt(1, band.getId());
            ResultSet queryResults = sqlStatement.executeQuery();
            if (queryResults.next()) {
                band.setId(queryResults.getInt("id_band"));
                band.setName(queryResults.getString("nm_band"));
                band.setGenre(queryResults.getString("genre_band"));
            }
            sqlStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return band;
    }

    // Method that will be used to list all bands from the database
    public ArrayList<Band> searchAll() {
        ArrayList<Band> listBands = new ArrayList<Band>();

        connection = DBManager.getConnection();

        PreparedStatement sqlStatement;
        try {
            sqlStatement = connection.prepareStatement("SELECT * FROM BANDS");
            ResultSet queryResults = sqlStatement.executeQuery();

            while(queryResults.next()) {
                Band band = new Band();
                band.setId(queryResults.getInt(1));
                band.setName(queryResults.getString(2));
                band.setGenre(queryResults.getString(3));
                listBands.add(band);
            }

            sqlStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listBands;
    }
}
