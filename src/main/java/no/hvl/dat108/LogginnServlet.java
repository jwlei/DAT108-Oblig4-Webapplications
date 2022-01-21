package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogginnServlet")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonEAO personEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requiresLoginRedirect = request.getParameter("requiresLogin") != null;
		boolean invalidInputRedirect = request.getParameter("invalidInput") != null;

		if (requiresLoginRedirect) {
			request.setAttribute("feilmelding", "Du må være logget inn for å kunne se deltakerlisten.");

		} else if (invalidInputRedirect) {
			request.setAttribute("feilmelding", "Ugyldig brukernavn og/eller passord. Prøv på nytt.");
		}
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");

		try {
			if (!personEAO.erPaameldtFraFor(mobil)) {
				response.sendRedirect("LogginnServlet?invalidInput");
			} else {
				Person person = personEAO.getPerson(mobil);
				if (InnloggingUtil.validatePassword(passord, person)) {
					InnloggingUtil.loggInn(request, person);
					response.sendRedirect("DeltagerlisteServlet");
				} else {
					response.sendRedirect("LogginnServlet?invalidInput");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("LogginnServlet");
		}

	}
}
