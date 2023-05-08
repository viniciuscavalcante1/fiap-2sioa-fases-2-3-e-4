package teste;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import dao.DBManager;
public class TesteGerenciadorBD {
    public static void main(String[] args) {
        Statement statement;
        try{
            statement = DBManager.getConnection().createStatement();
            statement.execute("INSERT INTO BANDS (id_band, nm_band, genre_band) VALUES (SQ_BAND.NEXTVAL, 'Iron Maiden', 'Heavy Metal')");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}