package ru.chmykhalov.sd.refactoring;

import org.junit.Assert;
import org.junit.Test;
import ru.chmykhalov.sd.refactoring.servlet.AddProductServlet;
import java.io.IOException;
import static org.mockito.Mockito.when;

public class AddProductServletTest extends TestBase {

    private final AddProductServlet servlet = new AddProductServlet();

    private void addProducts(Product product) throws IOException {
        when(request.getParameter("name")).thenReturn(product.getName());
        when(request.getParameter("price")).thenReturn(String.valueOf(product.getPrice()));
        servlet.doGet(request, response);
    }

    @Test
    public void addProductTest() throws IOException {
        addProducts(new Product("iphone", 10000));
        Assert.assertEquals("OK\n", writer.toString());
    }

}
