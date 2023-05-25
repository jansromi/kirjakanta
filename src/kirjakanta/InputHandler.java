package kirjakanta;

import java.io.Console;
import java.util.Arrays;

public class InputHandler {
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

    public char[] getPassword() {
        char[] password = console.readPassword("Enter password: ");
        return password;
    }

    public void clearPassword(char[] password) {
        Arrays.fill(password, '\0');
    }

}