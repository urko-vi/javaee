package frontcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IActionController {

	public View execute(HttpServletRequest request,
		    HttpServletResponse response) throws Exception;
}
