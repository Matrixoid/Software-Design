package ru.chmykhalov.sd.refactoring.servlet;

import ru.chmykhalov.sd.refactoring.*;

import javax.servlet.http.*;
import java.util.List;
public class GetProductsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = DataBase.executeSQLQuery(DataBase.GET_PRODUCTS, DataBase::collectProducts);

        CustomHttpResponse re = new CustomHttpResponse();
        for (Product product : products) {
            re.addLine(product.getName() + "\t" + product.getPrice() + "</br>");
        }
        re.commit(response);
    }
}
