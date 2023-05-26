package kirjakanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public void selectAllBooks() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String title = resultSet.getString("title");

                System.out.print("id: " + id);
                System.out.print(" | ");
                System.out.print("title: " + title + System.lineSeparator());
            }
        } catch (SQLException e) {
            System.out.println("Error executing the SELECT statement.");
            e.printStackTrace();
        }
    }
    
    public void selectBook(String bookTitle) {
    	String query = "SELECT b.id, b.title, a.author_name FROM book b " +
                "JOIN book_author ba ON b.id = ba.book_id " +
                "JOIN author a ON a.id = ba.author_id " +
                "WHERE b.title ILIKE ?";

    	try (PreparedStatement statement = connection.prepareStatement(query)) {
    		// Set the parameter
    		statement.setString(1, "%" + bookTitle + "%");
    		ResultSet resultSet = statement.executeQuery();
     
    		while (resultSet.next()) {
    			String title = resultSet.getString("title");
    			String author = resultSet.getString("author_name");
    			System.out.print("Title: " + title);
    			System.out.print(" | ");
    			System.out.print("Author: " + author + System.lineSeparator());
    		}
    	} catch (SQLException e) {
    	System.out.println("Error executing the SELECT statement.");
    	e.printStackTrace();
    	}
    }
}
