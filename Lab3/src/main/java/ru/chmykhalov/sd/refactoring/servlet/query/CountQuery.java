package ru.chmykhalov.sd.refactoring.servlet.query;

import ru.chmykhalov.sd.refactoring.*;

import java.util.Optional;

public class CountQuery extends Query<Optional<Long>> {

    public void executeQuery() {
        queryResult = DataBase.executeSQLQuery(DataBase.CALC_COUNT, DataBase::extractLong);
    }

    public void initRespond() {
        re.addLine("Number of products: ");
    }

    public void putResultInRespond() {
        queryResult.ifPresent(re::addLine);
    }

}