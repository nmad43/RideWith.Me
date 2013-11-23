package com.g5.ridewithme;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RideWith_MeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
