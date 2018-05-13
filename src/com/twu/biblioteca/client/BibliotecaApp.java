package com.twu.biblioteca.client;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.services.Menu;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Menu menuItens = new Menu();
        menuItens.showWelcome();
        User user =  menuItens.login();
        Library library = new Library(user);
        menuItens.printMenuItens(user);


        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        while (input > 0){
            menuItens.showOption(input, library);
            menuItens.printMenuItens(user);
            input = scanner.nextInt();
        }

    }
}
