package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.Library;
import biblioteca.model.repository.UserRepository;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ListItemCommandTest {
    @DisplayName("test for performAction of List Book")
    @Test
    void testForPerformActionOfListBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ListItemCommand listItemCommand = new ListItemCommand(ItemType.BOOK);
        AuthorizedUsers authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());

        listItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);
        verify(library).getLibraryItemDetails(ItemType.BOOK);
    }

    @DisplayName("test for performAction of List Movie")
    @Test
    void testForPerformActionOfListMovie(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ListItemCommand listItemCommand = new ListItemCommand(ItemType.MOVIE);
        AuthorizedUsers authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());


        listItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);
        verify(library).getLibraryItemDetails(ItemType.MOVIE);
    }
}