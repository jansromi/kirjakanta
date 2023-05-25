package kirjakanta;


public class Main {

	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
        DatabaseManager dbManager = new DatabaseManager(inputHandler);
        

        String command = inputHandler.getNextCommand();
        while(!command.equals("quit")) {
        	if (command.equals("1")) {
        		System.out.println("hello");
        		dbManager.isConnected();
        	}
            dbManager.executeQuery(command);
            command = inputHandler.getNextCommand();
        }

        dbManager.closeConnection();
	}

}
