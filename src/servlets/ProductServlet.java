package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Samuser;
import util.DbProduct;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nextURL = "/error.jsp";

//		//session.setAttribute("EmailResponse",null);
//		//make sure a user is in the session. If they don't exist then go back to the login page.
//		if (session.getAttribute("user")==null){
//			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
//			nextURL = "/login.jsp";
//			response.sendRedirect(request.getContextPath() + nextURL);
//			return;//return prevents an error; Don't believe me? Take it out.
//		}

		//get the userId from the request parameter
		//Anything that comes in from getParameter is a String so we need to 
		//convert it to an integer. In Java the term for converting something is "cast"
		//so we cast the incoming request parameter for userid to an int
		int productid = Integer.parseInt(request.getParameter("productid"));
		
		request.setAttribute("prod", DbProduct.getProduct(productid));

		/*
		 * simplify this so that it always requires two parameters, userid and action
		 * action is 'view' or 'edit'. If edit then the userID of the session(user) must be same as userID for profile
		 * since you can only edit your own profile.
		 * all urls coming to this page must contain both parameters (userid and action) or get an error.
		 */			
//		Samuser loggedInUser = (Samuser) session.getAttribute("user");//<-- here we are casting to a User object
//		Bhuser profileUser = DbUser.getUser(userid);//<-- we don't have to cast this time because we have a userId and the DbUser class knows what to do with a userId

		
		//REVIEW: What do we know at this point....
		/* ONE: The logged in user came from the session. 
		 * If they weren't in the session then the servlet would have sent them back
		 * to the login page above.
		 * TWO: The requesting url contained a parameter called userid which tells us which user's profile
		 * is being requested.
		 * THREE: We used the requested userid in TWO above to create the profile user. We'll need that in a 
		 * minute to decide if profile.jsp should show in read-only mode or edit mode (with textboxes) 
		 */


//		//update profile in database for user in request variable if action = updateprofile
//		if (action.equals("updateProfile")){
//			String userEmail = request.getParameter("useremail");
//			String userMotto = request.getParameter("usermotto");
//			profileUser.setMotto(userMotto);
//			profileUser.setUseremail(userEmail);
//			DbUser.update(profileUser);
//		}
//		///////////////////////////////////////////////////////////////////////////////
//
//		//if the loggedInUser is requesting their own profile
//		//then show profile.jsp in edit mode (ie... values in textboxes and a submit button)
//		if (loggedInUser.getBhuserid()==profileUser.getBhuserid()){
//			//display profile as form
//			//the session variable editProfile is used by the JSP to
//			//display the profile in edit mode
//			request.setAttribute("editProfile", true);
//			request.setAttribute("userid", profileUser.getBhuserid());
//			request.setAttribute("username", profileUser.getUsername());
//			request.setAttribute("useremail", profileUser.getUseremail());
//			request.setAttribute("usermotto", profileUser.getMotto());
//		}else{
//			//display profile read-only
//			//the session variable editProfile is used by the JSP to
//			//display the profile in read-only mode
//			request.setAttribute("editProfile", false);
//			request.setAttribute("userid", profileUser.getBhuserid());
//			request.setAttribute("username", profileUser.getUsername());
//			request.setAttribute("useremail", profileUser.getUseremail());
//			request.setAttribute("usermotto", profileUser.getMotto());
//		}

	
	
	
		//in any event we need to populate the data on profile.jsp
		//then set the values of the other attributes
		//profile.jsp contains ${user.username} to display the attribute for username and so on ...

		nextURL = "/productPage.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
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
