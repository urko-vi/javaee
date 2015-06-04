package org.techzoo.aqsa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	public View execute(HttpServletRequest request,
	    HttpServletResponse response) throws Exception;
}
