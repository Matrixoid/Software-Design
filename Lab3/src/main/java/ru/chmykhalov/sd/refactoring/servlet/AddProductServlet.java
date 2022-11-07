package ru.chmykhalov.sd.refactoring.servlet;

import ru.chmykhalov.sd.refactoring.*;

import javax.servlet.http.*;

public class AddProductServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Product product = new Product(
                request.getParameter("name"),
                Long.parseLong(request.getParameter("price")));
        DataBase.executeSQLUpdate(DataBase.addProduct(product));

        CustomHttpResponse re = new CustomHttpResponse("OK");
        re.commit(response);
    }
}
