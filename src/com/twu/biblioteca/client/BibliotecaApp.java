package com.twu.biblioteca.client;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.services.Menu;
import com.twu.biblioteca.util.ScannerUtil;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        ScannerUtil scannerUtil = new ScannerUtil();

        Menu menuItens = new Menu();
        System.out.println(menuItens.showWelcome());
        User user =  menuItens.login(scannerUtil);
        mountMenu(user, menuItens, scannerUtil);

    }

    public static void mountMenu(User user, Menu menuItens, ScannerUtil scannerUtil){

        if(user.isLogged()){

            Library library = new Library();

            System.out.println(menuItens.getOptionsMenu());

            int input = scannerUtil.readKeyBoardThenReturnInterger();

            System.out.println(menuItens.getOptionsMenu());

            while (input > 0){
                menuItens.showOption(input, library, scannerUtil);
                System.out.println(menuItens.getOptionsMenu());
                input = scannerUtil.readKeyBoardThenReturnInterger();
            }
        } else {
            menuItens.getNoOpitionsMenu();
        }
    }
}
