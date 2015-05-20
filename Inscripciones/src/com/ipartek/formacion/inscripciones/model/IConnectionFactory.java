package com.ipartek.formacion.inscripciones.model;

import com.ipartek.formacion.inscripciones.exception.ModelException;

public interface IConnectionFactory {
    IConnection getIConnection() throws ModelException;
}
