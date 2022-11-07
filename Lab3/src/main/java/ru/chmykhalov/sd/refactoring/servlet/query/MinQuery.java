package ru.chmykhalov.sd.refactoring.servlet.query;

import ru.chmykhalov.sd.refactoring.*;

import java.util.List;

public class MinQuery extends Query<List<Product>> {

    public void executeQuery() {
        queryResult = DataBase.executeSQLQuery(DataBase.SELECT_MIN, DataBase::collectProducts);
    }

    public void initRespond() {
        re.addHeader("Product with min price: ", 1);
    }

    public void putResultInRespond() {
        for (Product min : queryResult) {
            re.addLine(min.getName() + "\t" + min.getPrice() + "</br>");
        }
    }

}