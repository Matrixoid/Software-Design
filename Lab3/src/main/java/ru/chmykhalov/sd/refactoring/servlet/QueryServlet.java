package ru.chmykhalov.sd.refactoring.servlet;

import ru.chmykhalov.sd.refactoring.*;
import ru.chmykhalov.sd.refactoring.servlet.query.Query;

import javax.servlet.http.*;
public class QueryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("command");
        Query<?> query = Query.init(command);
        CustomHttpResponse re = query.execute();
        re.commit(response);
    }

}
