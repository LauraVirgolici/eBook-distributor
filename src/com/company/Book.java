package com.company;
import java.util.ArrayList;
import java.util.List;

public class Book implements IPublishingArtifact {
    String ID;
    String name;
    String subtitle;
    String ISBN;
    int pageCount;
    String keyWords;
    String languageID;
    String createdOn;
    List<Author> authors;

    public Book(String ID, String name, String subtitle, String ISBN, int pageCount, String keyWords, String languageID, String createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keyWords = keyWords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new ArrayList<Author>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getLanguageID() {
        return languageID;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void add_author_list(Author author) {

        this.authors.add(author);
    }

    public String printList(Book book) {
        String output = "";
        for (Author author : book.authors) {
            output += author.toString() + " ";
        }
        return output;
    }


    public String publish(int flag) {
        String listAuthors = this.printList(this);
        int nr = flag;

        String tabs = "";
        while (nr != 0) {
            tabs += "\t";
            nr--;
        }

        String output = (flag == 0) ? "</xml>\n" : "";

        output += tabs + "\t<title>" + this.name + "</title>\n" +
                tabs + "\t<subtitle>" + this.subtitle + "</subtitle>\n" +
                tabs + "\t<isbn>" + this.ISBN + "</isbn>\n" +
                tabs + "\t<pageCount>" + this.pageCount + "</pageCount>\n" +
                tabs + "\t<keywords>" + this.keyWords + "</keywords>\n" +
                tabs + "\t<languageID>" + this.languageID + "</languageID>\n" +
                tabs + "\t<createdOn>" + this.createdOn + "<createdOn>\n" +
                tabs + "\t<authors>" + listAuthors + "<authors>\n";

        output += (flag == 0) ? "</xml>\n" : "";
        return output;
    }


}