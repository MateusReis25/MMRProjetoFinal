package br.com.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MMRProjetoFinal")
public class MMRProjetoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Container container;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MMRProjetoFinal() {
    	super();
        // TODO Auto-generated constructor stub
    	this.container = new Container();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String option = request.getParameter("option");
		if (option == null) {
			option = "";
		}
		switch(option) {
			case ("insertForm"):
				showInsertUser(request, response);
			break;
			case ("updateForm"):
				showUpdateUser(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				insertUser(request, response);
			break;
			default:
				selectAllUsers(request, response);
		}
	}
	
	private void showInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	
	private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		User u = this.container.buscarUser(id);
		request.setAttribute("user", u);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeBack = request.getParameter("name");
		String emailBack = request.getParameter("email");
		String paisBack = request.getParameter("pais");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null)) {
			if (!nomeBack.equals("")){
				User user1 = new User(nomeBack, paisBack, emailBack);
				this.container.insert(user1);
			}
		}
		response.sendRedirect("MMRProjetoFinal");
	}
	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listUser", this.container.getListUser());
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.container.delete(id);
		}
		response.sendRedirect("MMRProjetoFinal");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nomeBack = request.getParameter("name");
		String emailBack = request.getParameter("email");
		String paisBack = request.getParameter("pais");
		String idBack = request.getParameter("id");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null) && (idBack != null)) {
			if (!nomeBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				User user1 = new User(nomeBack, paisBack, emailBack);
				user1.setId(id);
				this.container.update(user1);
			}
		}
		response.sendRedirect("MMRProjetoFinal");
	}
	
}
