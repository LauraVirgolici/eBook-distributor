package com.company;
import java.util.List;

public class Parser {

    public Parser() {
    }

    public void ParseBook(String line, List<Book> books) {
        String[] result = line.split("###");
        Book book = new Book(result[0], result[1], result[2], result[3], Integer.parseInt(result[4]), result[5], result[6], result[7]);
        books.add(book);
    }

    public void ParseLanguage(String line, List<Language> languages) {
        String[] result = line.split("###");
        Language language = new Language(result[0], result[1], result[2]);
        languages.add(language);
    }

    public void ParseAuthor(String line, List<Author> authors) {
        String[] result = line.split("###");
        Author author = new Author(result[0], result[1], result[2]);
        authors.add(author);
    }

    public void ParseEditorialGroup(String line, List<EditorialGroup> editorialGroups) {
        String[] result = line.split("###");
        EditorialGroup editorialGroup = new EditorialGroup(result[0], result[1]);
        editorialGroups.add(editorialGroup);
    }

    public void ParsePublishingBrand(String line, List<PublishingBrand> publishingBrands) {
        String[] result = line.split("###");
        PublishingBrand publishingBrand = new PublishingBrand(result[0], result[1]);
        publishingBrands.add(publishingBrand);
    }

    public void ParsePublishingRetailer(String line, List<PublishingRetailer> publishingRetailers) {
        String[] result = line.split("###");
        PublishingRetailer publishingRetailer = new PublishingRetailer(result[0], result[1]);
        publishingRetailers.add(publishingRetailer);
    }

    public void ParseCountries(String line, List<Countries> countries) {
        String[] result = line.split("###");
        Countries country = new Countries(result[0], result[1]);
        countries.add(country);
    }

    public  String[] SimpleParse(String line) {
        String[] result = line.split("###");
       return result;
    }


}
