package biblioteca.startingPoint;

import biblioteca.common.*;

public class LibraryManagementSystem {
    OutputDriver outputDriver;

    LibraryManagementSystem(OutputDriver outputDriver){
        this.outputDriver = outputDriver;
        outputDriver.print(Messages.WELCOME_MESSAGE);
    }
}
