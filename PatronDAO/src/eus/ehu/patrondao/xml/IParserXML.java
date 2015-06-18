package eus.ehu.patrondao.xml;

import java.io.File;
import java.util.List;

public interface IParserXML<T> {

	// Pasar de Objeto a XML
	public void parseXML(final List<? extends IXMLParser> lista,final File archivo);
	// Pasr XML a OBjeto
	public List<?> parseJavaObject(final File archivo);
	// validar con Schema
	public boolean validateXML(final File archivoSchema,final File archivoXML);
}
