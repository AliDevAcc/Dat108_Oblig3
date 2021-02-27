package Oblig3;

import static hjelpeklasse.UrlMappings.DELTAGERLISTE_URL;
import static hjelpeklasse.UrlMappings.LOGGINN_URL;
import static hjelpeklasse.UrlMappings.PAAMELDINGBEKREFTELSE_URL;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hjelpeklasse.Deltager;
import hjelpeklasse.DeltagerEAO;
import hjelpeklasse.Hashing;

@WebServlet(name = "LogginnServlet", urlPatterns = { "/logginn" })
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashing hashing;
	private	String feilkode="";

	@EJB
	private DeltagerEAO deltagerEao;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String feilkode= request.getParameter("feilkode");
		if(feilkode==null) {
	
		request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
		}
		String feilmelding ="Ugyldig brukernavn og/eller passord";
		request.setAttribute("feilmelding", feilmelding);
		request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mobilnr = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		
		List<Deltager> liste = deltagerEao.hentAlleDeltagere();
		Hashing h=new Hashing();
		boolean valid=false;
		boolean funnet=false;
	String feilkode= "";
			Deltager d=deltagerEao.FinnesNr(mobilnr);
			if(d==null){
				feilkode ="1";
				response.sendRedirect("/Oblig3/logginn?feilkode=" + feilkode);
			}else {				
				try {
					valid=h.validatePasswordWithSalt(passord,d.getSaltpassord(),d.getHashpassord());
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				funnet=true;
				if(valid) {
					
					HttpSession sesjon = request.getSession(false);
					if (sesjon != null) {
						sesjon.invalidate();
					}
					sesjon = request.getSession(true);
					sesjon.setAttribute("deltager", d);
					sesjon.setMaxInactiveInterval(10);
					
					response.sendRedirect(DELTAGERLISTE_URL + "");
					System.out.println("Gikk til deltager");
				} else {
					feilkode="1";
					response.sendRedirect("/Oblig3/logginn?feilkode=" + feilkode);
					System.out.println("Gikk til paamelding");
				}
			} 

		

	}

}
