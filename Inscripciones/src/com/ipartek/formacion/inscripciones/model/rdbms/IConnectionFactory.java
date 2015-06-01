package com.ipartek.formacion.inscripciones.model.rdbms;

import com.ipartek.formacion.inscripciones.model.IConnection;

public interface IConnectionFactory {
	IConnection getIConnection();
}
