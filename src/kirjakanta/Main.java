package kirjakanta;


public class Main {

	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
        DatabaseManager dbManager = new DatabaseManager(inputHandler);
        

        String command = inputHandler.getNextCommand();
        
        while(!command.equals("quit") && !command.equals("\\q")) {
            switch(command) {
                case "0":
                	if (dbManager.isConnected()) {
                		System.out.println("Database online!");
                	}
                	else {
                		System.out.println("Not connected to database");
                	}
                    break;
                    
                case "1":
                	dbManager.selectBook(inputHandler.getUserInput("Book title: "));
                	break;
                	
                case "2":
                    dbManager.selectAllBooks();
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
