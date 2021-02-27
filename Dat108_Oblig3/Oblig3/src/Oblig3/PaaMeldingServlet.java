package Oblig3;

import static hjelpeklasse.UrlMappings.PAAMELDINGBEKREFTELSE_URL;
import static hjelpeklasse.UrlMappings.PAAMELDING_URL;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import hjelpeklasse.Deltager;
import hjelpeklasse.DeltagerEAO;
import hjelpeklasse.Hashing;
import hjelpeklasse.Validator;

@WebServlet(name = "PaaMeldingServlet", urlPatterns = { "/paamelding"})
public class PaaMeldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Validator v = new Validator();
	@EJB
	DeltagerEAO deltagerEao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hashpassord = "";
		String saltpassord = "";
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobilnr = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
		
		

		boolean gyldigFornavn = false;
		if (v.isValidFName(fornavn)) {
			gyldigFornavn = true;
		}

		boolean gyldigEtternavn = false;
		if (v.isValidLName(etternavn)) {
			gyldigEtternavn = true;
		}
		boolean unik = false;
		boolean gyldigMobilnr = false;
		List<Deltager> liste = deltagerEao.hentAlleDeltagere();
		if (v.isValidNr(liste, mobilnr)) {
			gyldigMobilnr = true;
			System.out.println("Riktig nr?????");
			if(!(v.Unique(liste, mobilnr))) {
				unik=true;
				System.out.println("kom her ALLIKEVEL");
			}
		}

		boolean gyldigPassord = false;
		if (v.isValidPass(passord) && v.erLik(passord, passordRepetert)) {
			
			gyldigPassord = true;
			byte[] salt = Hashing.getSalt(); 
			
			try {
				Hashing.generateHashWithSalt(passord, salt);
				hashpassord = Hashing.getPasswordHashinHex();
				saltpassord = DatatypeConverter.printHexBinary(salt);
				
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}
		}
System.out.println("2" + unik);
		boolean altGyldig = v.altGyldig(gyldigPassord, gyldigMobilnr, gyldigFornavn, gyldigEtternavn);
		if (altGyldig) {

			Deltager d = new Deltager(fornavn, etternavn, mobilnr, hashpassord, saltpassord, kjonn);

			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setAttribute("deltager", d);
			sesjon.setMaxInactiveInterval(10);
			System.out.println(d.getMobilnr());
			System.out.println(d.getFornavn());
			System.out.println(d.getEtternavn());
			System.out.println(d.getHashpassord());
			System.out.println(d.getKjonn());
			
			deltagerEao.addDeltager(d);
			System.out.println("1" + unik);
			if(unik==true) {
				response.sendRedirect("/Oblig3/logginn");
				System.out.println("nr funnet 1");
			} else {
				response.sendRedirect(PAAMELDINGBEKREFTELSE_URL);
				System.out.println("Gikk til paameldingsbekreftelse");
			}
			

		} else {
			if(unik==true) {
				response.sendRedirect("/Oblig3/logginn");
				System.out.println("nr funnet 2");
				System.out.println(unik);
			} else {
				response.sendRedirect("/Oblig3/paamelding");
				System.out.println("Ikke gyldig skjema");
			}
			
		}

	}

}
