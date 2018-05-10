package com.twu.biblioteca.client;

import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.services.Menu;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();

        Menu menuItens = new Menu(library);
        menuItens.showWelcome();
        menuItens.login();
        menuItens.printMenuItens();

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        while (input > 0){
            menuItens.showOption(input);
            menuItens.printMenuItens();
            input = scanner.nextInt();
        }

    }
}
