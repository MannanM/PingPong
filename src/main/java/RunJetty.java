import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class RunJetty {
    public static void main(String[] args) throws Exception {
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(AppContext.class);

        DispatcherServlet servlet = new DispatcherServlet(springContext);
        Server server = new Server(getPort());
        ServletContextHandler servletHandler = new ServletContextHandler();
        ServletHolder holder = new ServletHolder("spring", servlet);
        servletHandler.addServlet(holder, "/*");
        server.setHandler(servletHandler);

        server.start();
    }

    private static int getPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.valueOf(port);
        }
        return 8080;
    }
}