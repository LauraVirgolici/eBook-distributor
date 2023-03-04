package com.company;
import java.util.List;
import java.util.Objects;

public class Searcher {

    public Searcher() {
    }

    public Book SearchBook(List<Book> books, String ID) {
        for (Book book : books)
            if (Objects.equals(book.getID(), ID))
                return book;
        return null;
    }

    public Author SearchAuthor(List<Author> authors, String ID) {
        for (Author author : authors)
            if (Objects.equals(author.getID(), ID))
                return author;
        return null;
    }

    public Language SearchLanguage(List<Language> languages, String ID) {
        for (Language language : languages)
            if (Objects.equals(language.getID(), ID))
                return language;
        return null;
    }

    public EditorialGroup SearchEditorialGroup(List<EditorialGroup>editorialGroups, String ID) {
        for (EditorialGroup editorialGroup : editorialGroups)
            if (Objects.equals(editorialGroup.getID(), ID))
                return editorialGroup;
        return null;
    }

    public PublishingBrand SearchPublishingBrand(List<PublishingBrand>publishingBrands, String ID) {
        for (PublishingBrand publishingBrand : publishingBrands)
            if (Objects.equals(publishingBrand.getID(), ID))
                return publishingBrand;
        return null;
    }


    public PublishingRetailer SearchPublishingRetailer(List<PublishingRetailer>publishingRetailers, String ID) {
        for (PublishingRetailer publishingRetailer: publishingRetailers)
            if (Objects.equals(publishingRetailer.getID(), ID))
                return publishingRetailer;
        return null;
    }

    public Countries SearchCountries(List<Countries>countries, String ID) {
        for (Countries country: countries)
            if (Objects.equals(country.getID(), ID))
                return country;
        return null;
    }



}
