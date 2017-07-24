package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Samitem;
import util.DbItems;
import util.DbProduct;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		
		//get and check current user for login
				//Samuser s = 
				
				//System.out.println(typeoflist);
		

				String nextURL = "/error.jsp";
				//int userid = Integer.parseInt(request.getParameter("userid"));
				HttpSession session = request.getSession();
				if (session.getAttribute("user")==null){
					//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
					nextURL = "/login.jsp";
					session.invalidate();
					response.sendRedirect(request.getContextPath() + nextURL);
				    return;//return prevents an error
				}
				
				nextURL = "/MyCartServlet";
				int id = Integer.parseInt(request.getParameter("id"));
		
				DbItems.delete(DbItems.getItem(id));
				getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
