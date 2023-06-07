package edu.formation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/LoginServlet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<HTML> <Body>");

		String identifiantString = request.getParameter("identifiant");
		String passwordString = request.getParameter("password");

		if (identifiantString.equals("jean") && passwordString.equals("123456")) {

			HttpSession session = request.getSession();
			session.setAttribute("identifiantString", identifiantString);

			request.getRequestDispatcher("WEB-INF/ProfilServlet.jsp").forward(request, response);

			out.print("<p>Vous etes connecté</p>");

		} else {

			out.print("<p>Vous etes pas connecté</p>");
			out.print("<a href=\"Bienvenue.html\">Retourner à la page d'acceuil</a>");

		}
		out.print(" </Body></HTML>");

	}

}
