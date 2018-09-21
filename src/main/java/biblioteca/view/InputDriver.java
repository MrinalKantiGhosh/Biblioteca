package biblioteca.view;

import java.util.Scanner;

public class InputDriver {
    private final Scanner scanner;

    public InputDriver() {
        this.scanner = new Scanner(System.in);
    }

    public int getInputFromUserForSelectMenuOption(){
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public String getInputBookName(){
        String input = scanner.nextLine();
        return input;
    }
}
