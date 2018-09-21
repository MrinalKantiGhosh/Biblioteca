package biblioteca.view;

import biblioteca.model.Book;

import java.util.Collection;
import java.util.List;

public class OutputDriver {

    public void print(Object message){
        System.out.println(message);
    }

    public void printListOfBooks(List<String> collection){

        for(String book : collection){
            print(book);
        }
    }
}