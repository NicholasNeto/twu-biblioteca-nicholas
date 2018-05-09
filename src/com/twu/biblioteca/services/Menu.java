package com.twu.biblioteca.services;

import com.twu.biblioteca.services.Library;

import java.util.Scanner;

public class Menu {

    Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void showWelcome(){
        System.out.println("\tWELCOME");
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login:");
        String nome = scanner.nextLine();

        System.out.print("Password:");
        String password = scanner.nextLine();

        library.login(nome, password);
    }

    public void printMenuItens() {
        if(library.isLogged()){
            System.out.println("\t Menu ");
            System.out.println("Select: \n"
                    + "(1) to browse books" + " - " + "(2) Lend Book" + " - " +  "(3) Return Book" + " - " + "(4) Show books unavailable \n"
                    + "(5) to browse films" + " - " + "(6) Lend film" + " - " +  "(7) Return Film" + " - " + "(8) Show films unavailable \n"
                    + "(0) to exit. \n");
            System.out.println("Option:");
        } else{
            System.out.println("No menu option avalable");
        }
    }

    public void showOption(int input){
        if (input >= 0) {
            int option;
            option = input;

            switch (option) {
                case 1:
                    System.out.println(library.showMediaInTable(library.bookList));
                    break;

                case 2:
                    System.out.println("Print the ID number of the book you want to borrow");
                    Scanner scannerInputBook = new Scanner(System.in);
                    int inputBook = scannerInputBook.nextInt();
                    String inputStringBook= String.valueOf(inputBook);
                    library.borrowLibraryBook(inputStringBook);
                    break;

                case 3:
                    System.out.println("Print the ID number of the book you want to return");
                    Scanner scannerReturnBook = new Scanner(System.in);
                    int inputReturnBook = scannerReturnBook.nextInt();
                    String inputReturnStringBook = String.valueOf(inputReturnBook);
                    library.returnBookToTheLibrary(inputReturnStringBook);
                    break;

                case 4:
                    System.out.println(library.showUnavailableBook());
                    break;

                case 5:
                    System.out.println(library.showMediaInTable(library.filmList));
                    break;

                case 6:
                    System.out.println("Print the ID number of the film you want to borrow");
                    Scanner scannerInputFilm = new Scanner(System.in);
                    int inputFilm = scannerInputFilm.nextInt();
                    String inputStringFilm= String.valueOf(inputFilm);
                    library.borrowLibraryFilm(inputStringFilm);
                    break;

                case 7:
                    System.out.println("Print the ID number of the film you want to return");
                    Scanner scannerReturnFilm = new Scanner(System.in);
                    int inputReturnFilm = scannerReturnFilm.nextInt();
                    String inputReturnStringFilm = String.valueOf(inputReturnFilm);
                    library.returnFilmToTheLibrary(inputReturnStringFilm);
                    break;

                case 8:
                    System.out.println(library.showUnavailableFilm());
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
