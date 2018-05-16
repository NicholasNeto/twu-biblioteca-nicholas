package com.twu.biblioteca.services;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.util.MessagesUtil;
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

            String result = null;
            
            switch (option) {
                case 1:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.AVAILABLE, Book.class));
                    System.out.println(result);
                    return result;

                case 2:
                    System.out.println(MessagesUtil.GET_ID_TO_BORROW);
                    String optionsChosenToBook = scannerUtil.readKeyBoardThenReturnString();
                    result = library.borrowLibraryMedia(optionsChosenToBook) + MessagesUtil.BOOK_LABEL;
                    System.out.println(result);
                    return  result;

                case 3:
                    System.out.println(MessagesUtil.GET_ID_TO_RETURNING);
                    String  optionsChosenToRetunrMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.returnMediaToTheLibrary(optionsChosenToRetunrMovie) + MessagesUtil.BOOK_LABEL;
                    System.out.println(result);
                    return result;

                case 4:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.UNAVAILABLE, Book.class));
                    System.out.println(result);
                    return result;

                case 5:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.AVAILABLE, Movie.class));
                    System.out.println(result);
                    return result;

                case 6:
                    System.out.println(MessagesUtil.GET_ID_TO_BORROW);
                    String  optionsChosenToMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.borrowLibraryMedia(optionsChosenToMovie) + MessagesUtil.MOVIE_LABEL;
                    System.out.println(result);
                    return result;

                case 7:
                    System.out.println(MessagesUtil.GET_ID_TO_RETURNING);
                    String  optionsChosenToReturnMovie = scannerUtil.readKeyBoardThenReturnString();
                    result = library.returnMediaToTheLibrary(optionsChosenToReturnMovie) + MessagesUtil.MOVIE_LABEL;;
                    System.out.println(result);
                    return result;

                case 8:
                    result = library.showMediaInTable(library.getItemsByStatus(StatusEnum.UNAVAILABLE, Movie.class));
                    System.out.println(result);
                    return result;

                case 0:
                    result = MessagesUtil.WANT_TO_LEAVE;
                    System.out.println(result);
                    return result;

                default:
                    result = MessagesUtil.SELECT_OTHER_OPTION_VALID;
                    System.out.println(result);
                    return result;
            }
        }
        return MessagesUtil.INVALID_OPTION;
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


