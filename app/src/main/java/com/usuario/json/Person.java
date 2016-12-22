package com.usuario.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by usuario on 20/12/16.
 */

public class Person {
    @SerializedName("contacts")
    public List<Contact> contacts;

    public Person() {

    }

    public List<Contact> getContactos() {
        return contacts;
    }

    public void setContactos(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
