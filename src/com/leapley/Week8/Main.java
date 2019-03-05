package com.leapley.Week8;

/*
Hudson Leapley
3/5/2019
Add a class to the previous exercise that represents a collection of
contacts, both of the base class and the derived class. The collection
class should include a single method to add a contact, regardless of
class, to the collection - this demonstrates upcasting. The collection
class should also include a method to iterate through the contacts and
call their display methods - this demonstrates late binding.
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Contact contact = new Contact("Hudson","hudson.d.leapley@gmail.com"); //create normal contact
        BusinessContact bContact = new BusinessContact("Ethan","ethan@gmail.com","6149998888"); //create business contact
        Collection collection = new Collection();

        collection.addContact(contact);
        collection.addContact(bContact);
        collection.iterate();
    }
}

class Contact {
    private String name;
    private String email;

    public Contact(){}
    public Contact(String name, String email) { //Constructor for contact
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void display(){
        System.out.println("Name: " + getName() +"\n" +
                "Email: " + getEmail());
    }

}

class BusinessContact extends Contact{
    private String phoneNumber;

    public BusinessContact(String name, String email, String phoneNumber) { //Constructor for business contact
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override //Overrides display method to display phone number as well.
    public void display(){
        System.out.println("Name: " + getName() +"\n" +
                "Email: " + getEmail() +"\n" +
                "Phone Number: " + getPhoneNumber());
    }
}

class Collection{
    ArrayList<Contact> contacts =  new ArrayList<>();

    public void addContact(Contact contact){
        contacts.add(contact); //Add contact to array list.
    }

    public void iterate(){
        for(Contact contact: contacts){
            contact.display(); //Runs through contacts and displays
        }
    }
}

