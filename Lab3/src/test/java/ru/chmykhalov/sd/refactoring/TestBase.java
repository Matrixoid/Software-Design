package ru.chmykhalov.sd.refactoring;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.Collection;
import static org.mockito.Mockito.when;

public class TestBase {

    @Mock
    protected HttpServletRequest request;

    @Mock
    protected HttpServletResponse response;

    protected final DatabaseManager databaseManager = new DatabaseManager("jdbc:sqlite:test.db");
    protected final StringWriter writer = new StringWriter();

    @Before
    public void before() throws SQLException, IOException {
        databaseManager.execute("create table if not exists product" +
                "(id integer primary key autoincrement not null," +
                " name text not null," +
                " price int not null)");
        databaseManager.execute("delete from product");
        MockitoAnnotations.initMocks(this);
        when(response.getWriter()).thenReturn(new PrintWriter(writer));
    }

    @After
    public void after() throws SQLException {
        databaseManager.execute("delete from product");
    }

    public String expected(Collection<Product> c) {
        StringBuilder response = new StringBuilder();
        response.append("<html><body>\n");

        for (Product product : c) {
            response.append(product.getName()).append("\t").append(product.getPrice()).append("</br>\n");
        }

        response.append("</body></html>\n");
        return response.toString();
    }
}
