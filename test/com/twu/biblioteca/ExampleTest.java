package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private static final String NEW_LINE = "\r\n";
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!!!"+NEW_LINE;
    private static final String MAIN_MENU = "1.List Books"+NEW_LINE;
    private static final String BOOK_LIST_COLUMNS="INDEX | TITLE | AUTHOR | YEAR PUBLISHED"+NEW_LINE;
    private static final BookList BOOK_LIST[]={
            new BookList(1001,"","",2),
            new BookList(1002,"","",2),
            new BookList(1003,"","",2)
    };
    private static final String NO_EXCEPTION_THROWN = "";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWelcomeMessage() {
        assertSystemOutPrintln(WELCOME_MESSAGE,new BibliotecaApp().printWelcomeMessage());
    }

    @Test
    public void testMainMenu(){
        assertSystemOutPrintln(MAIN_MENU,new BibliotecaApp().printMainMenu());
    }

//    @Test
//    public void testBookList() {
//        assertSystemOutPrintln(BOOK_LIST,new BibliotecaApp().printBookList());
//    }

    private void assertSystemOutPrintln(String message,Void e) {
        assertEquals(message, getActualOutput());
        assertEquals(NO_EXCEPTION_THROWN, getActualException());
    }

    private void assertSystemOutPrintln(BookList[] bookList,Void e) {
        String expectedOutput = parseBookListArrayToString(bookList);
        assertEquals(expectedOutput, getActualOutput());
        assertEquals(NO_EXCEPTION_THROWN, getActualException());
    }

    private String getActualException() {
        return errContent.toString();
    }

    private String getActualOutput() {
        return outContent.toString();
    }

    private String parseBookListArrayToString(BookList[] bookList) {
        String output=BOOK_LIST_COLUMNS;
        for (int i = 0; i < bookList.length; i++) {
            output+=bookList.toString()+NEW_LINE;
        }
        return output;
    }


}
