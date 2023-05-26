package kirjakanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private Connection connection;
	private final String url = "jdbc:postgresql://192.168.108.19:5432/tjta3501";
	private final String user = "kirjakanta";
	
	
	public DatabaseManager(PasswordHandler pwHandler) {
		try {
            connection = DriverManager.getConnection(url, user, pwHandler.getPassword());
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
            e.printStackTrace();
        }
    }
	
    public boolean isConnected() {
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT 1");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

	public void executeQuery(String command) {
		
		return;
	}

	public void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                System.out.println("Error closing the database connection.");
                e.printStackTrace();
            }
        }
    }

    public void selectBooks() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String title = resultSet.getString("title");
                // and so on for other columns

                System.out.print("id: " + id);
                System.out.print(" | ");
                System.out.print("title: " + title + System.lineSeparator());
                // and so on for other columns
            }
        } catch (SQLException e) {
            System.out.println("Error executing the SELECT statement.");
            e.printStackTrace();
        }
    }
}
