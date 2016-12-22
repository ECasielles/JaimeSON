package com.usuario.json;

/**
 * Created by usuario on 15/12/16.
 */

public class Contacto {
    private String nombre;
    private String direccion;
    private String email;
    private Telefono telefono;
    public String getNombre() { return nombre; }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefono getTelefono() { return telefono; }

    public void setTelefono(Telefono t) {
        this.telefono = t;
    }

    public String toString() {
        return nombre;
    }
}
