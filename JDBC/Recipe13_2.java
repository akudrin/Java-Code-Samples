import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Recipe13_2 {

    private static CreateConnection createConn;

    public static void main(String[] args) {

        createConn = new CreateConnection();

        queryDatabase();

    }

    public static void queryDatabase() {
        String qry = "select recipe_num, name, description from recipes";
        try (Connection conn = createConn.getConnection();
                Statement stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                // PERFORM SOME WORK
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
