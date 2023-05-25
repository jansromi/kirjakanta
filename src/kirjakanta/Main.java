package kirjakanta;


public class Main {

	public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        InputHandler inputHandler = new InputHandler();

        String command = inputHandler.getNextCommand();
        while(!command.equals("quit")) {
            dbManager.executeQuery(command);
            command = inputHandler.getNextCommand();
        }

        dbManager.closeConnection();
	}

}
