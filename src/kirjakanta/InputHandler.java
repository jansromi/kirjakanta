package kirjakanta;

import java.io.Console;
//kirjakanta : kissa
public class InputHandler implements PasswordHandler {
    private Console console;

    public InputHandler() {
        console = System.console();
        if (console == null) {
            System.exit(1);
        }
    }

    public String getNextCommand() {
        System.out.println("Enter command:");
        return console.readLine();
    }

    public String getPassword() {
        char[] password = console.readPassword("Enter password: ");
        return new String(password);
    }

}