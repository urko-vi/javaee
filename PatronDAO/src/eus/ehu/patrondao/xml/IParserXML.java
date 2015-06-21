package eus.ehu.patrondao.xml;

import java.io.File;
import java.util.List;

public interface IParserXML<T> {


	// Pasr XML a OBjeto
	public List<?> parseJavaObject(final File archivo);
	// validar con Schema
	public boolean validateXML(final File archivoSchema,final File archivoXML);
	//void parseXML(List<IXMLParser> lista, File archivo);
}
