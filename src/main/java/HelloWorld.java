import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * Created by IntelliJ IDEA.
 * User: rajesh.kolla
 * Date: 6/25/13
 * Time: 7:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Hello from Java!\n");
    }

    public static void main(String[] args) throws Exception{

        Server server = null;
        try {
            server = new Server(Integer.valueOf(System.getenv("PORT")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorld()),"/*");
        server.start();
        server.join();



    }
}
