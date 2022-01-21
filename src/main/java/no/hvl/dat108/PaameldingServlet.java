package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PersonEAO personEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Deltagerskjema skjema = new Deltagerskjema(request);
		
		try {
			if (skjema.validSkjema() && !personEAO.erPaameldtFraFor(skjema.getMobil())) {

				Person person = skjema.nyPerson();

				personEAO.addPerson(person);

				InnloggingUtil.loggInn(request, person);
				response.sendRedirect("BekreftelseServlet");
			} else {
				skjema.feilmeldinger();
				request.getSession().setAttribute("skjema", skjema);
				response.sendRedirect("PaameldingServlet");

			}
		} catch (Exception e) {
			response.sendRedirect("PaameldingServlet");
		}
	}

}
