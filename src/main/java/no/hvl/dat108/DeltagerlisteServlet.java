package no.hvl.dat108;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeltagerlisteServlet")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PersonEAO personEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if (!InnloggingUtil.erInnlogget(request)) {
			response.sendRedirect("LogginnServlet?requiresLogin");
		} else {
			List<Person> liste = personEAO.getList();
			
			//Formattering av tlf nr: 12 34 56 78
			liste.forEach(p -> {
				p.setMobil(p.getMobil().substring(0,2) + " " 
				+ p.getMobil().substring(2,4) + " " 
				+ p.getMobil().substring(4,6) + " " 
				+ p.getMobil().substring(6,8));
			});

			request.getSession().setAttribute("liste", liste);
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
