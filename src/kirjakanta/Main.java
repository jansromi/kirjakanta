package kirjakanta;


public class Main {

	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
        DatabaseManager dbManager = new DatabaseManager(inputHandler);
        

        String command = inputHandler.getNextCommand();
        
        while(!command.equals("quit") && !command.equals("\\q")) {
            switch(command) {
                case "1":
                    dbManager.isConnected();
                    break;
                case "2":
                    dbManager.selectBooks();
                    break;
                default:
                    System.out.println("Command unknown.");
                    break;
            }
            command = inputHandler.getNextCommand();
        }

        dbManager.closeConnection();
	}

}
