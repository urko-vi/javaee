package com.ipartek.formacion.inscripciones.model;

import java.sql.Connection;

import com.ipartek.formacion.inscripciones.exception.ModelException;

public interface IConnection {
    public void connect() throws ModelException;

    public void disconnect() throws ModelException;

    public Connection getConnection();
}
