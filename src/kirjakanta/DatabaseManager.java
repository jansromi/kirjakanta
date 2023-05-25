package kirjakanta;

import java.sql.Connection;
import java.sql.DriverManager;
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
		return;
	}
}
