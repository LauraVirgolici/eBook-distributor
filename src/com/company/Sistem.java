package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistem {

    List<Book> books;   /*lista tututor cartilor din sistem*/
    List<Author> authors;    /*lista tututor autorilor din sistem*/
    List<Language> languages;    /*lista tututor limbilor din sistem*/
    List<EditorialGroup> editorialGroups;   /*lista tututor grupurilor editoriale din sistem*/
    List<PublishingBrand> publishingBrands;   /*lista tututor grupurilor editoriale din sistem*/
    List<PublishingRetailer> publishingRetailers;   /*lista tututor grupurilor de retail din sistem*/
    List<Countries> countries;   /*lista tututor tarilor editoriale din sistem*/

    public Sistem() {
        this.books = new ArrayList<Book>();
        this.authors = new ArrayList<Author>();
        this.languages = new ArrayList<Language>();
        this.editorialGroups = new ArrayList<EditorialGroup>();
        this.publishingBrands = new ArrayList<PublishingBrand>();
        this.publishingRetailers = new ArrayList<PublishingRetailer>();
        this.countries = new ArrayList<Countries>();
    }

    public void readData(String filePath, String Case) {
        try {
            BufferedReader reader;
            Parser parser = new Parser();
            reader = new BufferedReader(new FileReader(filePath));

            String line = reader.readLine();
            line = reader.readLine();

            if (Case.equals("book")) {
                while (line != null) {
                    parser.ParseBook(line, this.books);
                    line = reader.readLine();
                }
            }

            if (Case.equals("language")) {
                while (line != null) {
                    parser.ParseLanguage(line, this.languages);
                    line = reader.readLine();
                }
            }

            if (Case.equals("author")) {
                while (line != null) {
                    parser.ParseAuthor(line, this.authors);
                    line = reader.readLine();
                }
            }

            if (Case.equals("editorial_group")) {
                while (line != null) {
                    parser.ParseEditorialGroup(line, this.editorialGroups);
                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing_brand")) {
                while (line != null) {
                    parser.ParsePublishingBrand(line, this.publishingBrands);
                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing_retailer")) {
                while (line != null) {
                    parser.ParsePublishingRetailer(line, this.publishingRetailers);
                    line = reader.readLine();
                }
            }

            if (Case.equals("countries")) {
                while (line != null) {

                    parser.ParseCountries(line, this.countries);
                    line = reader.readLine();
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void associateData(String filePath, String Case) {
        try {
            BufferedReader reader;
            Parser parser = new Parser();
            Searcher searcher = new Searcher();
            reader = new BufferedReader(new FileReader(filePath));

            String line = reader.readLine();
            line = reader.readLine();

            if (Case.equals("books-authors")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    Author author = searcher.SearchAuthor(this.authors, result[1]);
                    Book book = searcher.SearchBook(this.books, result[0]);

                    book.add_author_list(author);
                    line = reader.readLine();
                }
            }

            if (Case.equals("editorial-groups-books")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    EditorialGroup editorialGroup= searcher.SearchEditorialGroup(this.editorialGroups,result[0]);
                    Book book = searcher.SearchBook(this.books, result[1]);

                    editorialGroup.add_book_list(book);

                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing-brands-books")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    PublishingBrand publishingBrand= searcher.SearchPublishingBrand(this.publishingBrands,result[0]);
                    Book book = searcher.SearchBook(this.books, result[1]);
                    publishingBrand.addBook(book);

                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing-retailers-countries")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    PublishingRetailer publishingRetailer= searcher.SearchPublishingRetailer(this.publishingRetailers,result[0]);
                    Countries country = searcher.SearchCountries(this.countries, result[1]);

                    publishingRetailer.addCountry(country);
                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing-retailers-books")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    PublishingRetailer publishingRetailer= searcher.SearchPublishingRetailer(this.publishingRetailers,result[0]);
                    Book book = searcher.SearchBook(this.books, result[1]);

                    publishingRetailer.addBook(book);
                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing-retailers-editorial-groups")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    PublishingRetailer publishingRetailer= searcher.SearchPublishingRetailer(this.publishingRetailers,result[0]);
                    EditorialGroup editorialGroup = searcher.SearchEditorialGroup(this.editorialGroups, result[1]);

                    publishingRetailer.addEditorialGroup(editorialGroup);
                    line = reader.readLine();
                }
            }

            if (Case.equals("publishing-retailers-publishing-brands")) {
                while (line != null) {
                    String result[] = parser.SimpleParse(line);

                    PublishingRetailer publishingRetailer= searcher.SearchPublishingRetailer(this.publishingRetailers,result[0]);
                    PublishingBrand publishingBrand= searcher.SearchPublishingBrand(this.publishingBrands, result[1]);

                    publishingRetailer.addPublishingBrand(publishingBrand);
                    line = reader.readLine();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
