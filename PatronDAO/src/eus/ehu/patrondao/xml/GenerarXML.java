package eus.ehu.patrondao.xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;





public class GenerarXML implements IParserXML {

	public GenerarXML(){
		
	}

	/**
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	private void parseObjectXML(IXMLParser elemento,File archivo)   {
		//Object.class
		try {
			JAXBContext context = JAXBContext.newInstance(elemento.getClass());
			Marshaller m = context.createMarshaller();
			 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		     m.marshal(elemento, new File(archivo.getAbsolutePath()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       

        // Write to System.out for debugging
        // m.marshal(emp, System.out);

        // Write to File

	}

	@Override
	public List<?> parseJavaObject(File archivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateXML(File archivoSchema, File archivoXML) {
		// TODO Auto-generated method stub
		return false;
	}

	public void parseXML(List<IXMLParser> lista, File archivo) {
		// TODO Auto-generated method stub
		
		/*
		AlumnoXML alum = new AlumnoXML();
		AsignaturaXML asig = alum.new AsignaturaXML();
		*/
		for(IXMLParser ob: lista){
			parseObjectXML(ob,archivo);
		}
	}


	// http://www.journaldev.com/1234/jaxb-tutorial-example-to-convert-object-to-xml-and-xml-to-object
	// http://www.journaldev.com/895/how-to-validate-xml-against-xsd-in-java

}
