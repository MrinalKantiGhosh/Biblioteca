package biblioteca.controller;

import biblioteca.controller.command.ListItem;
import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ListItemTest {
    @DisplayName("test for performAction of List Book")
    @Test
    void testForPerformActionOfListBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ListItem listItem = new ListItem(ItemType.BOOK);

        listItem.performCommand(library, outputDriver, inputDriver);
        verify(library).getLibraryItemDetails(ItemType.BOOK);
    }

    @DisplayName("test for performAction of List Movie")
    @Test
    void testForPerformActionOfListMovie(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ListItem listItem = new ListItem(ItemType.MOVIE);

        listItem.performCommand(library, outputDriver, inputDriver);
        verify(library).getLibraryItemDetails(ItemType.MOVIE);
    }
}