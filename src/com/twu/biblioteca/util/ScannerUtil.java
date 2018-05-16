package com.twu.biblioteca.util;

import java.util.Scanner;

public class ScannerUtil {

    public String readKeyBoardThenReturnString(){
        Scanner scannerInputString = new Scanner(System.in);
        int optionsChosen = scannerInputString.nextInt();
        return String.valueOf(optionsChosen);
    }

    public int readKeyBoardThenReturnInterger(){
        Scanner scannerInputInterger = new Scanner(System.in);
        return scannerInputInterger.nextInt();

    }

}
