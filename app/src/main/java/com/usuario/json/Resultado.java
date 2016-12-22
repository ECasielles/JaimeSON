package com.usuario.json;

/**
 * Created by usuario on 13/12/16.
 */

public class Resultado {
    private boolean codigo;
    private String mensaje;
    private String contenido;

    public boolean getCodigo() {
        return codigo;
    }
    public void setCodigo(boolean codigo) {
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
