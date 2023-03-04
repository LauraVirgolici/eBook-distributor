package com.company;
import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Sistem sistem = new Sistem();
        /*introducerea datelor in sistem*/
        sistem.readData("src/com/init/books.in", "book");
        sistem.readData("src/com/init/languages.in", "language");
        sistem.readData("src/com/init/authors.in", "author");
        sistem.readData("src/com/init/editorial-groups.in", "editorial_group");
        sistem.readData("src/com/init/publishing-brands.in", "publishing_brand");
        sistem.readData("src/com/init/publishing-retailers.in", "publishing_retailer");
        sistem.readData("src/com/init/countries.in", "countries");

        /*realizarea asocierilor*/
        sistem.associateData("src/com/init/books-authors.in", "books-authors");
        sistem.associateData("src/com/init/editorial-groups-books.in", "editorial-groups-books");
        sistem.associateData("src/com/init/publishing-brands-books.in", "publishing-brands-books");

        sistem.associateData("src/com/init/publishing-retailers-countries.in", "publishing-retailers-countries");
        sistem.associateData("src/com/init/publishing-retailers-books.in", "publishing-retailers-books");
        sistem.associateData("src/com/init/publishing-retailers-editorial-groups.in", "publishing-retailers-editorial-groups");
        sistem.associateData("src/com/init/publishing-retailers-publishing-brands.in", "publishing-retailers-publishing-brands");



        /*TESTE*/
        Administration administration= new Administration(sistem);
        Printer printer= new Printer();
        Test tester=new Test();

        /*I.getBooksForPublishingRetailerID*/
        /*1*/ tester.TestMethod1(administration,"out/output/method_1/Test1","TEST 1",1);
        /*2*/ tester.TestMethod1(administration,"out/output/method_1/Test2","TEST 2",9);
        /*3*/ tester.TestMethod1(administration,"out/output/method_1/Test3","TEST 3",11);
        /*4*/ tester.TestMethod1(administration,"out/output/method_1/Test4","TEST 4",20);
        /*5*/ tester.TestMethod1(administration,"out/output/method_1/Test5","TEST 5",33);


        /*II.getLanguagesForPublishingRetailerID*/
        /*1*/ tester.TestMethod2(administration,"out/output/method_2/Test1","TEST 1",1);
        /*2*/ tester.TestMethod2(administration,"out/output/method_2/Test2","TEST 2",9);
        /*3*/ tester.TestMethod2(administration,"out/output/method_2/Test3","TEST 3",12);
        /*4*/ tester.TestMethod2(administration,"out/output/method_2/Test4","TEST 4",20);
        /*5*/ tester.TestMethod2(administration,"out/output/method_2/Test5","TEST 5",33);


        /*III.getCountriesForBookID*/
        /*1*/ tester.TestMethod3(administration,"out/output/method_3/Test1","TEST 1",204);
        /*2*/ tester.TestMethod3(administration,"out/output/method_3/Test2","TEST 2",262);
        /*3*/ tester.TestMethod3(administration,"out/output/method_3/Test3","TEST 3",357);
        /*4*/ tester.TestMethod3(administration,"out/output/method_3/Test4","TEST 4",591);
        /*5*/ tester.TestMethod3(administration,"out/output/method_3/Test5","TEST 5",913);


        /*IV.getCommonBooksForRetailerIDs*/
        /*1*/ tester.TestMethod4(administration,"out/output/method_4/Test1","TEST 1",17,19 );
        /*2*/ tester.TestMethod4(administration,"out/output/method_4/Test2","TEST 2",11,12);
        /*3*/ tester.TestMethod4(administration,"out/output/method_4/Test3","TEST 3",7,24);
        /*4*/ tester.TestMethod4(administration,"out/output/method_4/Test4","TEST 4",23,28);
        /*5*/ tester.TestMethod4(administration,"out/output/method_4/Test5","TEST 5",20,21);


        /*V.getAllBooksForRetailerIDs*/
        /*1*/ tester.TestMethod5(administration,"out/output/method_5/Test1","TEST 1",17,19);
        /*2*/ tester.TestMethod5(administration,"out/output/method_5/Test2","TEST 2",11,12);
        /*3*/ tester.TestMethod5(administration,"out/output/method_5/Test3","TEST 3",7,24);
        /*4*/ tester.TestMethod5(administration,"out/output/method_5/Test4","TEST 4",23,28);
        /*5*/ tester.TestMethod5(administration,"out/output/method_5/Test5","TEST 5",29,33);

    }


}
