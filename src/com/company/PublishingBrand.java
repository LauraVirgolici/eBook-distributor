package com.company;
import java.util.ArrayList;
import java.util.List;

public class PublishingBrand implements IPublishingArtifact {
    String ID;
    String name;
    List<Book> books;

    public PublishingBrand(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<Book>();
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
       this.books.add(book);
    }

    public String publish(int flag) {
        String bookOutput = "";

        for (Book book : this.books) {
            bookOutput += "\t\t<book>\n";
            bookOutput += book.publish(3);
            bookOutput += "\t\t<book>\n";
        }
        String output = "<xml>\n" +
                "\t<publishingBrand>\n" +
                "\t\t<ID>" + this.ID + "</ID>\n" +
                "\t\t<Name>" + this.name + "</Name>\n" +
                "\t</ publishingBrand>\n" +
                "\t<books>\n" + bookOutput +
                "\t</books>\n" +
                "</xml>\n";
        return output;
    }

}
