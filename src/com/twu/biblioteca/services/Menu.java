package com.twu.biblioteca.services;


import com.twu.biblioteca.models.ItemsLibrary;
import com.twu.biblioteca.models.StatusEnum;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.util.ScannerUtil;

public class Menu {

    Authenticator Authenticator;

    public Menu() {
        Authenticator = new Authenticator();
    }

    public String  showWelcome(){
        return "\tWelcome Bangalore Public Library";
    }

    public  User login(ScannerUtil scannerUtil){

        System.out.print("Login:");
        String idUser = scannerUtil.readKeyBoardThenReturnString();

        System.out.print("Password:");
        String password = scannerUtil.readKeyBoardThenReturnString();

        return Authenticator.login(idUser, password);
    }



    public String showOption(int input, Library library, ScannerUtil scannerUtil){
        if (input >= 0) {
            int option;
            option = input;
            ItemsLibrary itemsLibrary;
            MenuImpl menuImpl = new MenuImpl();
            String result = "";


            switch (option) {
                case 1:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.AVAILABLE).getBookList());
                    System.out.println(result);
                    return result;

                case 2:
                    System.out.println("Print the ID number of the book you want to borrow");
                    String optionsChosenToBook = scannerUtil.readKeyBoardThenReturnString();
                    result = library.borrowLibraryMedia(optionsChosenToBook);
                           // lendBook(library, optionsChosenToBook);
                    System.out.println(result);
                    return  result;

                case 3:
                    System.out.println("Print the ID number of the book you want to return");
                    String  optionsChosenToRetunrMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.returnMediaToTheLibrary(optionsChosenToRetunrMovie);
                    System.out.println(result);
                    return result;

                case 4:
                    itemsLibrary = library.getItemsByStatus(StatusEnum.UNAVAILABLE);
                    result = library.showMediaInTable(itemsLibrary.getBookList());
                    System.out.println(result);
                    return result;

                case 5:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.AVAILABLE).getMovieList());
                    System.out.println(result);
                    return result;

                case 6:
                    System.out.println("Print the ID number of the film you want to borrow");
                    String  optionsChosenToMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.borrowLibraryMedia(optionsChosenToMovie);
                    System.out.println(result);
                    return result;

                case 7:
                    System.out.println("Print the ID number of the film you want to return");
                    String  optionsChosenToReturnMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.returnMediaToTheLibrary(optionsChosenToReturnMovie);
                    System.out.println(result);
                    return result;

                case 8:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.UNAVAILABLE).getMovieList());
                    System.out.println(result);
                    return result;

                case 0:
                    result = "See you  later!";
                    System.out.println(result);
                    return result;

                default:
                    result = "Select a valid option!";
                    System.out.println(result);
                    return result;
            }
        }
        return "Invalid Option";
    }

    public String getOptionsMenu() {
        return "\t Menu "
                + "Select: \n"
                + "(1) to browse books" + " - " + "(2) Lend Book" + " - " +  "(3) Return Book" + " - " + "(4) Show books unavailable \n"
                + "(5) to browse films" + " - " + "(6) Lend film" + " - " +  "(7) Return Film" + " - " + "(8) Show films unavailable \n"
                + "(0) to exit. \n"
                + "Option:";
    }

    public String getNoOpitionsMenu() {
        return "No menu option avalable";
    }
}


