package com.company;
import java.util.List;
import java.util.Set;

public class Printer {

    public Printer() {
    }

    public void printListBooks(List<Book>books, int flag)
    {
        String output = "";
        for(Book book:books) {
            output += book.publish(flag);
        }
        System.out.println(output);
    }

    public void printListCountries(List<Countries>countries)
    {
        String output = "";
        for(Countries country:countries) {
            output += country.countryCode;
            output +="\n";
        }
        System.out.println(output);
    }


    public void printSetBooks(Set<Book> books, int flag)
    {
        String output = "";
        for(Book book:books) {
            output += book.publish(flag);
        }
        System.out.println(output);
    }

    public void printSetLanguages(Set<Language> languages)
    {
        String output = "";
        for(Language language: languages) {
            output += language.name;
            output +="\n";
        }
        System.out.println(output);
    }

}
