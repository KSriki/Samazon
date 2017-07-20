package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DbUser;

/**
 * Servlet implementation class MyCartServlet
 */
@WebServlet("/MyCartServlet")
public class MyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCartServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nextURL = "/login.jsp";
		
		HttpSession session = request.getSession();
		
		session.getAttribute("user");
		
			if (session.getAttribute("user")==null){
				//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
				nextURL = "/login.jsp";
				response.sendRedirect(request.getContextPath() + nextURL);
	return;//return prevents an error; Don't believe me? Take it out.
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
