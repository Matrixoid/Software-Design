package ru.chmykhalov.sd.refactoring.servlet.query;

import ru.chmykhalov.sd.refactoring.*;

import java.util.List;

public class MaxQuery extends Query<List<Product>> {

    public void executeQuery() {
        queryResult = DataBase.executeSQLQuery(DataBase.SELECT_MAX, DataBase::collectProducts);
    }

    public void initRespond() {
        re.addHeader("Product with max price: ", 1);
    }

    public void putResultInRespond() {
        for (Product max : queryResult) {
            re.addLine(max.getName() + "\t" + max.getPrice() + "</br>");
        }
    }

}