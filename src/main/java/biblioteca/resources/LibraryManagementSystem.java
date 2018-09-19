package biblioteca.resources;

import biblioteca.common.Messages;
import biblioteca.common.OutputDriver;

public class LibraryManagementSystem {
    OutputDriver outputDriver;

    LibraryManagementSystem(OutputDriver outputDriver){
        this.outputDriver = outputDriver;
        outputDriver.print(Messages.WELCOME_MESSAGE);
    }
}
