package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Samitem;
import model.Samuser;
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
		
		doPost (request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextURL = "/confirmation.jsp";
	
		
		
		HttpSession session = request.getSession();

		//working to change code below do not change
		
		Samuser sam = (Samuser) session.getAttribute("user");
		
		

		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			response.sendRedirect(request.getContextPath() + nextURL);
return;//return prevents an error; Don't believe me? Take it out.
	}else{
		nextURL = "/confirmation.jsp";
	}
		

			
		List<Samitem> mycart = DbItems.getCartitems(sam.getSamid());
	
		float total = 0;
		
		System.out.println(total);
		for (Samitem item : mycart){
			float price = item.getPrice();
			int quantity = item.getQuantity();
			float subtotal;
		
			subtotal = price * quantity;
			total = total + subtotal;
		}
		System.out.println(sam);
		System.out.println(total);
		
		request.setAttribute("total", total);
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);


	}
	
			
		
		
}
