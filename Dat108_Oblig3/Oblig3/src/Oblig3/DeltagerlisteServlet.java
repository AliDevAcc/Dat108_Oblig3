package Oblig3;

import static hjelpeklasse.UrlMappings.DELTAGERLISTE_URL;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjelpeklasse.Deltager;
import hjelpeklasse.DeltagerEAO;

@WebServlet(name = "DeltagerlisteServlet", urlPatterns = { "/" + DELTAGERLISTE_URL })
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
		DeltagerEAO deltagerEao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Deltager> liste = deltagerEao.hentAlleDeltagere();
		liste.sort((d1,d2) -> d1.getFornavn().compareTo(d2.getFornavn()));
		for(int i = 0; i < liste.size(); i++){
		   Deltager d = liste.get(i);
		String mobilnr = d.getMobilnr();
		String fornavn = d.getFornavn();
		String etternavn = d.getEtternavn();
		String kjonn = d.getKjonn();
		
		request.setAttribute("liste", liste);
		request.setAttribute("fornavn", fornavn);
		request.setAttribute("etternavn", etternavn);
		request.setAttribute("mobilnr", mobilnr);
		request.setAttribute("kjonn", kjonn);
		
		Deltager d2 = (Deltager) request.getSession().getAttribute("deltager");
		String mobilnr2 = d2.getMobilnr();
		request.setAttribute("mobilnr2", mobilnr2);
		}
		request.getRequestDispatcher("WEB-INF/Deltagerliste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}

}
