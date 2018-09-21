package biblioteca.view;

import java.util.Scanner;

public class InputDriver {
    Scanner scanner;

    public InputDriver() {
        this.scanner = new Scanner(System.in);
    }

    public int getInputFromUserForSelectMenuOption(){
        int input = scanner.nextInt();
        return input;
    }
}
