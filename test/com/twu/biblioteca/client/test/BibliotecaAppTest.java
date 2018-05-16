package com.twu.biblioteca.client.test;


import com.twu.biblioteca.client.BibliotecaApp;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Menu;
import com.twu.biblioteca.util.ScannerUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;


public class BibliotecaAppTest {


//    @Test
//    public void test() {
//
//
//        User user =  new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1");
//
//        Menu menuItens = new Menu();
//
//        ScannerUtil scannerUtil = Mockito.mock(ScannerUtil.class);
//        Mockito.when(scannerUtil.readKeyBoardThenReturnInterger()).thenReturn(1);
//
//
//        PowerMockito.mockStatic(BibliotecaApp.class);
//
//        BibliotecaApp.mountMenu(user, menuItens, scannerUtil);
//        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
//        BibliotecaApp.mountMenu(user, menuItens, scannerUtil);
//
//    }
}




//Mockito 1.9.5-rc1 had to be refactored internally to allow third party mock maker.
//MockitoInvocationHandler was part of the Mockito's internals (as the package name suggests) up to Mockito 1.9.0.
//Due to these changes, current some older version Powermock releases as of today are not compatible with the latest Mockito release.
