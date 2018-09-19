package biblioteca.startingPoint;

import biblioteca.common.Messages;
import biblioteca.common.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    OutputDriver outputDriver;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void init(){
        outputDriver = mock(OutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(outputDriver);
    }


    @DisplayName("check print functionality of output driver ")
    @Test
    void checkPrintFunctionality(){
        verify(outputDriver, times(1)).print(Messages.WELCOME_MESSAGE);
    }



}