package com.company;

import java.util.*;

public class Administration {
    List<Book> books;   /*lista tututor cartilor din sistem*/
    List<Author> authors;    /*lista tututor autorilor din sistem*/
    List<Language> languages;    /*lista tututor limbilor din sistem*/
    List<EditorialGroup> editorialGroups;   /*lista tututor grupurilor editoriale din sistem*/
    List<PublishingBrand> publishingBrands;   /*lista tututor grupurilor editoriale din sistem*/
    List<PublishingRetailer> publishingRetailers;   /*lista tututor grupurilor de retail din sistem*/
    List<Countries> countries;   /*lista tututor tarilor editoriale din sistem*/

    /*iau toate datele din sistem*/
    public Administration(Sistem sistem) {
        this.books = sistem.books;
        this.authors = sistem.authors;
        this.languages = sistem.languages;
        this.editorialGroups = sistem.editorialGroups;
        this.publishingBrands = sistem.publishingBrands;
        this.publishingRetailers = sistem.publishingRetailers;
        this.countries = sistem.countries;
    }

    Set<Book>getBooksForPublishingRetailerID(int publishingRetailerID) {
        Set<Book>uniquePrBooks = new HashSet();
        Searcher searcher = new Searcher();
        PublishingRetailer publishingRetailer = searcher.SearchPublishingRetailer(this.publishingRetailers, String.valueOf(publishingRetailerID));

        for (int i = 0; i < publishingRetailer.publishingArtifacts.size(); i++) {
            if (publishingRetailer.publishingArtifacts.get(i) instanceof Book)
                uniquePrBooks.add((Book) publishingRetailer.publishingArtifacts.get(i));

            if (publishingRetailer.publishingArtifacts.get(i) instanceof EditorialGroup) {
                for (Book book : ((EditorialGroup) publishingRetailer.publishingArtifacts.get(i)).books)
                    uniquePrBooks.add(book);
            }

            if (publishingRetailer.publishingArtifacts.get(i) instanceof PublishingBrand) {
                for (Book book : ((PublishingBrand) publishingRetailer.publishingArtifacts.get(i)).books)
                    uniquePrBooks.add(book);
            }
        }
        return uniquePrBooks;
    }


    Set<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        Set<Language> PrLanguages = new HashSet();
        Searcher searcher = new Searcher();
        PublishingRetailer publishingRetailer = searcher.SearchPublishingRetailer(this.publishingRetailers, String.valueOf(publishingRetailerID));

        for (int i = 0; i < publishingRetailer.publishingArtifacts.size(); i++) {
            if (publishingRetailer.publishingArtifacts.get(i) instanceof Book) {
                Language language = searcher.SearchLanguage(this.languages, ((Book) publishingRetailer.publishingArtifacts.get(i)).languageID);
                PrLanguages.add(language);
            }

            if (publishingRetailer.publishingArtifacts.get(i) instanceof EditorialGroup) {
                for (Book book : ((EditorialGroup) publishingRetailer.publishingArtifacts.get(i)).books) {
                    Language language = searcher.SearchLanguage(this.languages, book.languageID);
                    PrLanguages.add(language);
                }
            }

            if (publishingRetailer.publishingArtifacts.get(i) instanceof PublishingBrand) {
                for (Book book : ((PublishingBrand) publishingRetailer.publishingArtifacts.get(i)).books) {
                    Language language = searcher.SearchLanguage(this.languages, book.languageID);
                    PrLanguages.add(language);
                }
            }
        }
        return PrLanguages;
    }


    List<Countries> getCountriesForBookID(int bookID) {

        List<Countries> BCountries = new ArrayList<Countries>();
        Searcher searcher = new Searcher();

        //parcurg toti publishing retailerii
        for(PublishingRetailer publishingRetailer: this.publishingRetailers)
        {
            //iau unul, scot setul de carti unice aferent
            Set<Book>PrBooks = this.getBooksForPublishingRetailerID(Integer.valueOf(publishingRetailer.getID()) );

            // transform din set in lista ca sa pot folosi searcher
            List<Book>PrBooksList=new ArrayList<>(PrBooks);

            //vad daca in setul de carti gasit se afla cartea pe care o caut eu
            Book book = searcher.SearchBook(PrBooksList, String.valueOf(bookID));

            if(book!=null)
            {
                //BCountries indica catre lista de tari unde publica acets retailer
                BCountries = publishingRetailer.countries;
                break;
            }
        }
        return BCountries;
    }


    List<Book>getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){

        List<Book> CommonBooks = new ArrayList<Book>();

        //scot cartile unice
        Set<Book>publishingRetailer1Books = this.getBooksForPublishingRetailerID(retailerID1);
        Set<Book>publishingRetailer2Books = this.getBooksForPublishingRetailerID(retailerID2);

        for(Book book1:publishingRetailer1Books) {
            for(Book book2:publishingRetailer2Books)
                if(book1.getISBN().equals(book2.getISBN()))
                    CommonBooks.add(book1);
        }
        return CommonBooks;
    }


    Set<Book>getAllBooksForRetailerIDs (int retailerID1, int retailerID2)
    {
        Set<Book> Union=  new HashSet();

        Set<Book>publishingRetailer1Books = this.getBooksForPublishingRetailerID(retailerID1);
        Set<Book>publishingRetailer2Books = this.getBooksForPublishingRetailerID(retailerID2);

        Union.addAll(publishingRetailer1Books); // adaug toate cartile din prima lista

        for(Book book:publishingRetailer2Books)
        Union.add(book);

        return Union;
    }



}
