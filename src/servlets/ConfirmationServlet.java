package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DbItems;

/**
 * Servlet implementation class ConfirmationServlet
 */
@WebServlet("/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String nextURL = "/confirmation.jsp";
		HttpSession session = request.getSession();

		//working to change code below do not change
		
		/*session.setAttribute("cartitem", DbItems.getCartitem(sam.getSamid()));
		
		response.sendRedirect(request.getContextPath() + nextURL);
		doGet(request, response);
	}
	public void Add(HttpSession session ,double price){

	    Double sum=(Double)session.getAttribute("sum");
	    if(sum==null){
	        sum = new Double(price);
	    }
	        else {
	        sum = new Double(sum.intValue()+ price);
	    }
	    session.setAttribute("sum", sum);
	    }*/

}
