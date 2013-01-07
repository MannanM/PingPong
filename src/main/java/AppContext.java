import au.com.pingmate.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

@Configuration
@EnableWebMvc
@ComponentScan("au.com.pingmate.controller")
public class AppContext {

    @Bean
    public Service database() throws Exception {

        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        StringBuilder sb = new StringBuilder();
        while (rs.next()) {
            sb.append("Read from DB: " + rs.getTimestamp("tick"));
        }
        connection.close();
        return new Service(sb.toString());
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = getDbUrl();

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    private static URI getDbUrl() throws URISyntaxException {
        String database_url = System.getenv("DATABASE_URL");
        if (database_url != null) {
            return new URI(database_url);
        }
        return new URI("postgres://postgres:test@localhost:5432/test");

    }
}
