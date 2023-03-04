package com.company;
import java.util.List;
import java.util.ArrayList;

public class PublishingRetailer {
    String ID;
    String name;
    List<IPublishingArtifact> publishingArtifacts;
    List<Countries>countries;

    public PublishingRetailer(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = new ArrayList<IPublishingArtifact>();
        this.countries= new ArrayList<Countries>();
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

    public List getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(List publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public List getCountries() {
        return countries;
    }

    public void setCountries(List countries) {
        this.countries = countries;
    }


    public void addBook(Book book) {
        this.publishingArtifacts.add(book);
    }
    public void addPublishingBrand(PublishingBrand publishingBrand) {
        this.publishingArtifacts.add(publishingBrand);
    }

    public void addEditorialGroup(EditorialGroup editorialGroup) {
        this.publishingArtifacts.add(editorialGroup);
    }

    public void addCountry(Countries country) {
        this.countries.add(country);
    }

}
