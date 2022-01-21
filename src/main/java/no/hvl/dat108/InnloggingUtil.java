package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}

	public static boolean validatePassword(String password, Person person) {
		Hashing hashing = new Hashing("SHA-256");
		try {
			return (hashing.validatePasswordWithSalt(password, person.getPassordsalt(), person.getPassordhash()));	
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void loggInn(HttpServletRequest request, Person person) {
		loggUt(request);
		HttpSession sesjon = request.getSession(true);
        request.getSession().setAttribute("fornavn", person.getFornavn());
        request.getSession().setAttribute("etternavn", person.getEtternavn());
        request.getSession().setAttribute("mobil", person.getMobil());
        request.getSession().setAttribute("passordhash", person.getPassordhash());
        request.getSession().setAttribute("passordsalt", person.getPassordsalt());
        request.getSession().setAttribute("kjonn", person.getKjonn());
        sesjon.setAttribute("innlogget", "ja");
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
