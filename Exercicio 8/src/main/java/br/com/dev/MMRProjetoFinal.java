package br.com.dev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MMRProjetoFinal
 */
@WebServlet("/MMRProjetoFinal")
public class MMRProjetoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Container cont;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MMRProjetoFinal() {
        super();
        // TODO Auto-generated constructor stub
        this.cont = new Container();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
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
		User u = this.cont.selectById(id);
		request.setAttribute("user", u);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	
	private void insertUser(HttpServletRequest tomate, HttpServletResponse alface) throws ServletException, IOException{
		//String nomeBack = tomate.getParameter("nome"); // ERRO
		String nomeBack = tomate.getParameter("name");
		String emailBack = tomate.getParameter("email");
		String paisBack = tomate.getParameter("pais");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null)) {
			if (!nomeBack.equals("")){
				User user1 = new User(nomeBack, paisBack, emailBack);
				this.cont.insert(user1);
			}
		}
		alface.sendRedirect("MMRProjetoFinal");
	
	}
	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println(this.cont.selectAll());
		request.setAttribute("listUser", this.cont.selectAll());
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.cont.delete(id);
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
				this.cont.update(user1);
			}
		}
		response.sendRedirect("MMRProjetoFinal");
	}
	
}
