import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    super.service(req, res);
  }

  @Override
  public void init() throws ServletException {
    super.init();
  }

  @Override
  public void destroy() {
    super.destroy();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    response.setContentType("text/html");

    //String str = "Ololo";
    //request.setAttribute("str", request.getRequestURI());

    request.getRequestDispatcher("/test.jsp").forward(request, response);

    /*try (PrintWriter out = response.getWriter()) {
      out.println("<html>");
      out.println("<head><title>Hello worm demo</title></head>");
      out.println("<body>");
      out.println("<h1>Hello, Worm!</h1>");

      out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
      out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

      out.println("</body></html>");
    }*/
  }
}
