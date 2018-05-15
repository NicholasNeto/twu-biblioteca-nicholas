package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Authenticator;
import com.twu.biblioteca.services.Menu;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.util.ScannerUtil;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {


    private Menu menu;
    private Library library;
    private User user;
    private Authenticator Authenticator;



    @Before
    public void setUp(){
        menu = new Menu();

        user = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
        library = new Library();
        Authenticator = new Authenticator();
    }


    @Test
    public void shouldGetDadosOfUser(){

       assertEquals("\tWelcome Bangalore Public Library" , menu.showWelcome());

    }

    @Test
    public void shouldLoingWithSucessful(){

        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("1");

        User userResult = menu.login(scannerUtilMock);

        assertTrue(userResult.isLogged());
    }


    @Test
    public void shoudlPrintMenuWithSucessful(){
        //Given

        String expected = "\t Menu "
                + "Select: \n"
                + "(1) to browse books" + " - " + "(2) Lend Book" + " - " +  "(3) Return Book" + " - " + "(4) Show books unavailable \n"
                + "(5) to browse films" + " - " + "(6) Lend film" + " - " +  "(7) Return Film" + " - " + "(8) Show films unavailable \n"
                + "(0) to exit. \n"
                + "Option:";

        String printMenu = menu.getOptionsMenu();
        assertEquals(expected, printMenu);

    }


    @Test
    public void shoudlPrintMenuWithFail(){
        //Given

        String expected = "No menu option avalable";

        String noPrintMenu = menu.getNoOpitionsMenu();
        assertEquals(expected, noPrintMenu);

    }



    @Test
    public void shouldPrintBookAvailable(){
        //Given

        String desiredBookList =  String.format("%20s %20s %20s %20s %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status",
                "1", "TDD", "Kent", 2000, "AVAILABLE",
                "2" , "Design Patterns" ,"Fowler", 2001,"AVAILABLE",
                "3",  "Harry Potter", "Kent", 2002, "AVAILABLE",
                "4", "The Lord of the Rings", "Peter Jackson", 2003, "AVAILABLE");

        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        String resultForOpt1 = menu.showOption(1, library, scannerUtilMock);

        //Then
        assertEquals(desiredBookList, resultForOpt1);
    }


    @Test
    public void shouldLenBookdWithSucessful(){
        //Given
        String successMsg = "Thank you! Enjoy the book";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);


        // When
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("2");
        String resultForOpt1 = menu.showOption(2, library, scannerUtilMock);

        //Then
        assertEquals(successMsg, resultForOpt1);


    }

    @Test
    public void shouldLenBookdWithFail(){
        //Given

        String failMsg = "That book is not available.";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("2");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("2");
        String resultForOpt1 = menu.showOption(2, library, scannerUtilMock);

        //Then
        assertEquals(failMsg, resultForOpt1);
    }

    @Test
    public void shouldReturnBookWithSucessful(){
        //Given

        String successufulMensage = "Thank you for returning the book";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("2");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("2");
        String resultForOpt3 = menu.showOption(3, library, scannerUtilMock);

        //Then
        assertEquals(successufulMensage, resultForOpt3);
    }

    @Test
    public void shouldReturnBookWithSFail(){
        //Given

        String failMensage = "This is not a valid book to return";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("2");
        library.returnMediaToTheLibrary("2");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("2");
        String resultForOpt3 = menu.showOption(3, library, scannerUtilMock);

        //Then
        assertEquals(failMensage, resultForOpt3);
    }


    @Test
    public void shouldPrintBookUnavailable(){
        //Given

        String expectBooksUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2000, "UNAVAILABLE");

        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("1");
        String resultForOpt4 = menu.showOption(4, library, scannerUtilMock);

        //Then
        assertEquals(expectBooksUnavailableList, resultForOpt4);
    }


    @Test
    public void shouldPrintMovieAvailable(){
        //Given

        String desiredMovieList =  String.format("%20s %20s %20s %20s %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status",
                "5", "A luz", "Nicholas", 2000, "AVAILABLE",
                "6" , "Mochila Azul" ,"Nicols", 2001,"AVAILABLE",
                "7",  "Harry Potter", "J. K. Rowling", 2002, "AVAILABLE",
                "8", "The Matrix", "Cara Incrivel", 2003, "AVAILABLE");

        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        String resultForOpt5 = menu.showOption(5, library, scannerUtilMock);

        //Then
        assertEquals(desiredMovieList, resultForOpt5);
    }


    @Test
    public void shouldLenMoviedWithSucessful(){
        //Given
        String successMsg = "Thank you! Enjoy the movie";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("5");
        String resultForOpt6 = menu.showOption(6, library, scannerUtilMock);

        //Then
        assertEquals(successMsg, resultForOpt6);
    }

    @Test
    public void shouldLenMoviedWithFail(){
        //Given

        String failMsg = "That movie is not available.";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("5");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("5");
        String resultForOpt6 = menu.showOption(6, library, scannerUtilMock);

        //Then
        assertEquals(failMsg, resultForOpt6);
    }

    @Test
    public void shouldReturnMovieWithSucessful(){
        //Given

        String successufulMensage = "Thank you for returning the movie";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("5");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("5");
        String resultForOpt3 = menu.showOption(7, library, scannerUtilMock);

        //Then
        assertEquals(successufulMensage, resultForOpt3);
    }

    @Test
    public void shouldReturnMovieWithSFail(){
        //Given

        String failMensage = "This is not a valid movie to return";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("5");
        library.returnMediaToTheLibrary("5");
        Mockito.when(scannerUtilMock.readKeyBoardThenReturnString()).thenReturn("5");
        String resultForOpt3 = menu.showOption(7, library, scannerUtilMock);

        //Then
        assertEquals(failMensage, resultForOpt3);
    }


    @Test
    public void shouldPrintMovieUnavailable(){
        //Given
        String expectMoviesUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "5", "A luz", "Nicholas", 2000, "UNAVAILABLE");


        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        library.borrowLibraryMedia("5");
        String resultForOpt4 = menu.showOption(8, library, scannerUtilMock);

        //Then
        assertEquals(expectMoviesUnavailableList, resultForOpt4);
    }


    @Test
    public void shoulPrintAMustLeaveMessage(){
        //Given

        String successufulMensage = "See you  later!";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        String resultForOpt0 = menu.showOption(0, library, scannerUtilMock);

        //Then
        assertEquals(successufulMensage, resultForOpt0);
    }

    @Test
    public void shouldPrintADefaultMessage(){
        //Given
        String successufulMensage = "Select a valid option!";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        String resultForOpt0 = menu.showOption(55, library, scannerUtilMock);

        //Then
        assertEquals(successufulMensage, resultForOpt0);
    }

    @Test
    public void shouldPrintInvalidOption(){
        //Given
        String successufulMensage = "Invalid Option";
        ScannerUtil scannerUtilMock = Mockito.mock(ScannerUtil.class);

        // When
        String resultForNegativeOption = menu.showOption(-1, library, scannerUtilMock);

        //Then
        assertEquals(successufulMensage, resultForNegativeOption);
    }

}
