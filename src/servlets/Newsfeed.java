
package servlets;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Data;

import util.DbProduct;
import model.Product;

/**
 * Servlet implementation class Newsfeed
 */
@WebServlet("/Newsfeed")
public class Newsfeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newsfeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
//		List<DbProduct> posts = null;
//		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		//create a class called Post that contains email and text fields.
//		DbProduct p = new DbProduct();
//		
//		p.setPostdate(date);
//		p.setPosttext("This is the text of my post");
//		posts.add(p);
		int filterByUserID = 0; 
		String searchtext = "";
		
		String nextURL = "/error.jsp";
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
//		if (session.getAttribute("user")==null){
//			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
//			nextURL = "/login.jsp";
//			session.invalidate();
//			response.sendRedirect(request.getContextPath() + nextURL);
//		    return;//return prevents an error
//		}
//		
		//get posts based on parameters; if no parameters then get all posts
		List<Product> products = null;
		//userid not empty, get specific user posts
//		if (request.getParameter("userid")!=null){
//			filterByUserID = Integer.parseInt(request.getParameter("userid"));
//			posts = DbProduct.postsofUser(filterByUserID);
//			//get posts with search text similiar to this
//		}else if (request.getParameter("searchtext")!=null){
//			searchtext = request.getParameter("searchtext").toString();
//			posts = DbProduct.searchPosts(searchtext);
//		}else{
		products = DbProduct.getProducts();
//		}
		
		//add posts to session
		session.setAttribute("products", products);
//		
//		Enumeration keys = session.getAttributeNames();
//		while (keys.hasMoreElements())
//		{
//		  String key = (String)keys.nextElement();
//		  System.out.println(key + ": " + session.getAttribute(key) + "<br>");
//		}
//		//display posts in newsfeed.jsp
		nextURL = "/home.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
