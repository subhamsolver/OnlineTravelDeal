package p1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowcustdealsServlet
 */
@WebServlet("/ShowcustdealsServlet")
public class ShowcustdealsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowcustdealsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			DataAccess da=new DataAccess();
			
			String e=request.getParameter("description");
	//		String s=request.getParameter("sid");
	//		int sid=Integer.parseInt(s);
			ArrayList<Deals> list=da.selectalldeals(e);
			HttpSession session=request.getSession(true);
		//	session.setAttribute("name", e);
			session.setAttribute("DLIST", list);
			response.sendRedirect("alldealshow.jsp");
			
		/*	request.setAttribute("DLIST",list);
			RequestDispatcher rd=request.getRequestDispatcher("Dealshow.jsp");
			rd.forward(request, response);	*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
