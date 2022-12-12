package ru.chmykhalov.sd.visitor.visitor;

import ru.chmykhalov.sd.visitor.token.*;

public interface TokenVisitor {

    void visit(NumberToken token);

    void visit(Brace token);

    void visit(Operation token);

}
