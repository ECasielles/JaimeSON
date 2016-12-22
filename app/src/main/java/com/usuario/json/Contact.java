package com.usuario.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by usuario on 20/12/16.
 */

public class Contact {
    @SerializedName("name")
    private String nombre;
    @SerializedName("address")
    private String direccion;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private Phone telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getTelefono() {
        return this.telefono;
    }

    public void setTelefono(Phone t) {
        this.telefono = t;
    }

    public String toString() {
        return nombre;
    }
}
