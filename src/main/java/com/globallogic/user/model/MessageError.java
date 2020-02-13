package com.globallogic.user.model;

/**
 * Created by cristianfgr on 13-02-20.
 */
public class MessageError {

    private String mensaje;

    public MessageError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
