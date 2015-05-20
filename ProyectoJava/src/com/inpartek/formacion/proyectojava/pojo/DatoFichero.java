package com.inpartek.formacion.proyectojava.pojo;

public class DatoFichero {
    private String filePath;
    private String fileName;
    private String fileExt;

    public DatoFichero(final String pfilePath, final String pfileName,
	    final String pfileExt) {
	super();
	this.filePath = pfilePath;
	this.fileName = pfileName;
	this.fileExt = pfileExt;
    }

    public final String getFilePath() {
	return filePath;
    }

    public final void setFilePath(final String pfilePath) {
	this.filePath = pfilePath;
    }

    public final String getFileName() {
	return fileName;
    }

    public final void setFileName(final String pfileName) {
	this.fileName = pfileName;
    }

    public final String getFileExt() {
	return fileExt;
    }

    public final void setFileExt(final String pfileExt) {
	this.fileExt = pfileExt;
    }

}
