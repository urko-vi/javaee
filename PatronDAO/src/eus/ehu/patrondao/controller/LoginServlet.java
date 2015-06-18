package eus.ehu.patrondao.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eus.ehu.patrondao.util.Constantes;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String url;
	private String op;
	HttpSession session;

	private boolean checkParameters() {
		boolean exito = false;
		if ("urko".equals(this.user) && "urko".equals(this.pass)) { // texto.equals("")
			this.url += "/backoffice/bienvenido.jsp";
			exito = true;
		} else {
			this.url += "/index.jsp?mensaje='parametros no validos'";
			exito = false;
		}
		return exito;
	}

	private boolean checkSession() {
		boolean existe = false;
		if (this.session != null) {
			existe = true;
		}
		return existe;
	}

	private void createSession(final HttpServletRequest request,
			final HttpServletResponse response) {
		this.session = request.getSession(true);
		this.session.setAttribute("usuario", this.user);
		this.session.setAttribute("password", this.pass);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// Comprobar session
		this.checkSession();
		// recoger los parametros
		this.getParameters(request, response);
		if (this.user != null && this.pass != null) {
			// comprobar parametros
			if (this.checkParameters()) {
				this.createSession(request, response);
			}
		} else {
			if (this.op != null && Constantes.OP_LOGOUT.equals(this.op)) {
				this.logOut();
			}
			this.url += "/index.jsp";
		}
		// redirigir
		response.sendRedirect(this.url);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

	private void getParameters(final HttpServletRequest request,
			final HttpServletResponse response) {
		this.user = request.getParameter("user");
		this.pass = request.getParameter("pass");
		this.op = request.getParameter(Constantes.PARAMETRO_OP);
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		this.user = null;
		this.pass = null;
		this.session = null;
		this.url = "/PatronDAO";
	}

	private void logOut() {
		this.session.invalidate();

	}
}
