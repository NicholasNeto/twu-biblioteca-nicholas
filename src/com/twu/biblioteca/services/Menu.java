package com.twu.biblioteca.services;

import com.twu.biblioteca.models.ItemsLibrary;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Library;

import java.util.Scanner;

public class Menu {

    Autheticator autheticator;

    public Menu() {
        autheticator = new Autheticator();
    }

    public void showWelcome(){
        System.out.println("\tWELCOME");
    }

    public User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login:");
        String idUser = scanner.nextLine();

        System.out.print("Password:");
        String password = scanner.nextLine();

        return autheticator.login(idUser, password);
    }

    public void printMenuItens(User user) {
        if(user.isLogged()){
            System.out.println("\t Menu ");
            System.out.println("Select: \n"
                    + "(1) to browse books" + " - " + "(2) Lend Book" + " - " +  "(3) Return Book" + " - " + "(4) Show books unavailable \n"
                    + "(5) to browse films" + " - " + "(6) Lend film" + " - " +  "(7) Return Film" + " - " + "(8) Show films unavailable \n"
                    + "(0) to exit. \n");
            System.out.println("Option:");
        } else {
            System.out.println("No menu option avalable");
        }
    }

    public void showOption(int input, Library library){
        if (input >= 0) {
            int option;
            option = input;
            ItemsLibrary itemsLibrary;
            switch (option) {
                case 1:
                    System.out.println(library.showMediaInTable(library.getItemLibraryAvaible().getBookList()));
                    break;

                case 2:
                    System.out.println("Print the ID number of the book you want to borrow");
                    Scanner scannerInputBook = new Scanner(System.in);
                    int inputBook = scannerInputBook.nextInt();
                    String inputStringBook= String.valueOf(inputBook);
                    library.borrowLibraryMedia(inputStringBook);
                    break;

                case 3:
                    System.out.println("Print the ID number of the book you want to return");
                    Scanner scannerReturnBook = new Scanner(System.in);
                    int inputReturnBook = scannerReturnBook.nextInt();
                    String inputReturnStringBook = String.valueOf(inputReturnBook);
                    library.returMediaToTheLibrary(inputReturnStringBook);
                    break;

                case 4:
                    itemsLibrary = library.getItemsUnavailable();
                    System.out.println(library.showMediaInTable(itemsLibrary.getBookList()));
                    break;

                case 5:
                    System.out.println(library.showMediaInTable(library.getItemLibraryAvaible().getMovieList()));
                    break;

                case 6:
                    System.out.println("Print the ID number of the film you want to borrow");
                    Scanner scannerInputFilm = new Scanner(System.in);
                    int inputFilm = scannerInputFilm.nextInt();
                    String inputStringFilm= String.valueOf(inputFilm);
                    library.borrowLibraryMedia(inputStringFilm);
                    break;

                case 7:
                    System.out.println("Print the ID number of the film you want to return");
                    Scanner scannerReturnFilm = new Scanner(System.in);
                    int inputReturnFilm = scannerReturnFilm.nextInt();
                    String inputReturnStringFilm = String.valueOf(inputReturnFilm);
                    library.returMediaToTheLibrary(inputReturnStringFilm);
                    break;

                case 8:
                    itemsLibrary = library.getItemsUnavailable();
                    System.out.println(library.showMediaInTable(itemsLibrary.getMovieList()));
                    break;

                case 0:
                    System.out.println("See you  later!");
                    break;

                default:
                    System.out.println("Select a valid option!");
            }
        }
    }

}
