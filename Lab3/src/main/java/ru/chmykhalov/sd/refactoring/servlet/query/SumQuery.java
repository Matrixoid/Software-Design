package ru.chmykhalov.sd.refactoring.servlet.query;

import ru.chmykhalov.sd.refactoring.*;

import java.util.Optional;

public class SumQuery extends Query<Optional<Long>> {

    public void executeQuery() {
        queryResult = DataBase.executeSQLQuery(DataBase.CALC_SUM, DataBase::extractLong);
    }

    public void initRespond() {
        re.addLine("Summary price: ");
    }

    public void putResultInRespond() {
        queryResult.ifPresent(re::addLine);
    }

}