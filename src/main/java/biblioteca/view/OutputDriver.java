package biblioteca.view;

import java.util.List;

public class OutputDriver {

    public void print(Object message){
        System.out.print(message);
    }

    public void println(Object message){
        System.out.println(message);
    }

    public void printListOfItems(List<String> collection){

        for(String book : collection){
            String detailOfIndividualBook[] = book.split(",");
            for(String detail : detailOfIndividualBook){
                String line = padLeft(detail);
                print(line);
            }
            println("\n");
        }
    }

    public void printUserDetails(String details){
        String detailOfIndividualBook[] = details.split(",");
        print("Name : " + detailOfIndividualBook[0]);
        print("email : " + detailOfIndividualBook[1]);
        print("Phone Numebr : " + detailOfIndividualBook[2]);
        print("\n");
    }

    public static String padRight(String string) {
        return String.format("%1$40s", string);
    }

    public static String padLeft(String string) {
        return String.format("%1$-40s", string);
    }
}