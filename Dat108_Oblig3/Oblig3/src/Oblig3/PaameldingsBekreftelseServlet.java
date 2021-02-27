package Oblig3;

import static hjelpeklasse.UrlMappings.PAAMELDINGBEKREFTELSE_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjelpeklasse.Deltager;

@WebServlet(name = "PaameldingsBekreftelseServlet", urlPatterns = { "/" + PAAMELDINGBEKREFTELSE_URL })
public class PaameldingsBekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		Deltager d = (Deltager) request.getSession().getAttribute("deltager");
		String mobilnr = d.getMobilnr();
		String fornavn = d.getFornavn();
		String etternavn = d.getEtternavn();
		String kjonn = d.getKjonn();
		
		request.setAttribute("fornavn", fornavn);
		request.setAttribute("etternavn", etternavn);
		request.setAttribute("mobilnr", mobilnr);
		request.setAttribute("kjonn", kjonn);

		request.getRequestDispatcher("WEB-INF/Paameldingsbekreftelse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
