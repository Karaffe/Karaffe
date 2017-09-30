package org.karaffe.compiler.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.karaffe.compiler.lexer.KeywordToken.Extends;
import org.karaffe.compiler.lexer.OperatorToken.LeftBrace;
import org.karaffe.compiler.lexer.OperatorToken.RightBrace;
import org.karaffe.compiler.lexer.Tokens;
import org.karaffe.compiler.parser.util.ChainParser;
import org.karaffe.compiler.parser.util.MatchResult;
import org.karaffe.compiler.parser.util.TokenMatcher;
import org.karaffe.compiler.tree.Block;
import org.karaffe.compiler.tree.MethodDef;
import org.karaffe.compiler.tree.TypeDef.ClassDef;
import org.karaffe.compiler.tree.VarDef;
import org.karaffe.compiler.tree.VarName;
import org.karaffe.compiler.tree.base.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassDefParser implements Parser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassDefParser.class);

    @Override
    public MatchResult parse(final Tokens input) {
        if (input.isEmpty()) {
            return new MatchResult.Failure(input);
        }
        ClassDefParser.LOGGER.debug("Input : {}", input);
        final ChainParser parser = new ChainParser(input);
        parser.nextMatch(TokenMatcher.classKeyword());
        final Optional<VarName> c = parser.nextMatch(TokenMatcher.identifier(), VarName.class);
        if (!c.isPresent()) {
            ClassDefParser.LOGGER.debug("className not found.");
            return parser.toFailure();
        }
        final VarName className = c.get();

        final boolean hasExtends = parser.testNext(TokenMatcher.create(Extends.class));
        final boolean hasSuperClass = parser.testNext(TokenMatcher.identifier(), VarName.class);

        if (hasExtends != hasSuperClass) {
            ClassDefParser.LOGGER.debug("superClass not found. 1");
            return parser.toFailure();
        }

        final VarName superClassName = hasExtends ? parser.lastMatch() : null;

        parser.testNext(TokenMatcher.create(LeftBrace.class));

        final List<Node> defs = new ArrayList<>();
        while (parser.testNext(new VarDefParser(), VarDef.class)) {
            final VarDef varDef = parser.lastMatch();
            defs.add(varDef);
        }

        while (parser.testNext(new MethodDefParser(), MethodDef.class)) {
            final MethodDef varDef = parser.lastMatch();
            defs.add(varDef);
        }

        parser.testNext(TokenMatcher.create(RightBrace.class));

        if (parser.hasError()) {
            ClassDefParser.LOGGER.debug("gen error");
            return parser.toFailure();
        }
        return new MatchResult.Success(parser.next(), parser.matched(), new ClassDef(className, superClassName, new Block(defs)));
    }

}
