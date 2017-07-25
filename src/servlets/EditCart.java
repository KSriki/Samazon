package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Samitem;
import model.Samuser;
import util.DbItems;
import util.DbProduct;

/**
 * Servlet implementation class EditCart
 */
@WebServlet("/EditCart")
public class EditCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get and check current user for login
		//Samuser s = 
		String typeoflist = (String) request.getParameter("list");
		//System.out.println(typeoflist);
		//the product id
		int aP = Integer.parseInt(request.getParameter("productname"));
		Product newCartItem = DbProduct.getProduct(aP);
		String nextURL = "/error.jsp";
		if(request.getParameter("Quantity").isEmpty()){
			request.setAttribute("AddCart", "Please enter the quantity of the item you wish to purchase!");
			nextURL = "/Newsfeed";
			//System.out.println(request.getAttribute("AddCart"));
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
			return;
		}
		
		

		//int userid = Integer.parseInt(request.getParameter("userid"));
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		
		Samuser thisUser = (Samuser) session.getAttribute("user");
		
		Samitem toAdd = new Samitem();
		toAdd.setList(typeoflist);
		toAdd.setProduct(newCartItem);
		toAdd.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
		toAdd.setPrice(newCartItem.getPrice());

//		Date now = new Date();
//		toAdd.setPurchasedate(now);
	 					//need to allow in form the quantity. So form vs GET 
		toAdd.setSamuser(thisUser);
		
		
	//	if(DbItems.getItem())
		
		DbItems.insert(toAdd);
		request.setAttribute("AddCart", newCartItem.getProductname() + " added to cart");
		nextURL = "/Newsfeed";
		//System.out.println(request.getAttribute("AddCart"));
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
