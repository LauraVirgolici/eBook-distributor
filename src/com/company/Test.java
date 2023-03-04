package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

public class Test {

    Printer printer= new Printer();
    File OutputFile;

    public Test() {
    }

    public void TestMethod1(Administration administration,String FilePath, String TestHeader, int ID) throws FileNotFoundException {
       this.OutputFile = new File(FilePath);
        PrintStream printStreamToFile = new PrintStream(OutputFile);
        System.setOut(printStreamToFile);
        Set<Book> set_test1=administration.getBooksForPublishingRetailerID(ID);
        System.out.println("****************"+TestHeader+"****************");
        printer.printSetBooks(set_test1,0);
    }

    public void TestMethod2(Administration administration,String FilePath, String TestHeader, int ID) throws FileNotFoundException {
        this.OutputFile = new File(FilePath);
        PrintStream printStreamToFile = new PrintStream(OutputFile);
        System.setOut(printStreamToFile);
        Set<Language> set_test2=administration.getLanguagesForPublishingRetailerID(ID);
        System.out.println("****************"+TestHeader+"****************");
        printer.printSetLanguages(set_test2);
    }

    public void TestMethod3(Administration administration,String FilePath, String TestHeader, int ID) throws FileNotFoundException {
        this.OutputFile = new File(FilePath);
        PrintStream printStreamToFile = new PrintStream(OutputFile);
        System.setOut(printStreamToFile);
        List<Countries> list_test3=administration.getCountriesForBookID(ID);
        System.out.println("****************"+TestHeader+"****************");
        printer.printListCountries(list_test3);
    }

    public void TestMethod4(Administration administration,String FilePath, String TestHeader, int ID1, int ID2) throws FileNotFoundException {
        this.OutputFile = new File(FilePath);
        PrintStream printStreamToFile = new PrintStream(OutputFile);
        System.setOut(printStreamToFile);
        List<Book> list_test4=administration.getCommonBooksForRetailerIDs(ID1,ID2);
        System.out.println("****************"+TestHeader+"****************");
        printer.printListBooks(list_test4,0);
    }


    public void TestMethod5(Administration administration,String FilePath, String TestHeader, int ID1, int ID2) throws FileNotFoundException {
        this.OutputFile = new File(FilePath);
        PrintStream printStreamToFile = new PrintStream(OutputFile);
        System.setOut(printStreamToFile);
        Set<Book> set_test5=administration.getAllBooksForRetailerIDs(ID1,ID2);
        System.out.println("****************"+TestHeader+"****************");
        printer.printSetBooks(set_test5,0);
    }


}
