package com.company.mail;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Objects;

public class MessageTemplateBuilder {

    private StandardEvaluationContext context = new StandardEvaluationContext();
    private String expression;

    public MessageTemplateBuilder() {
    }

    public MessageTemplateBuilder setExpression(String expression) {
        Objects.requireNonNull(expression, "expression is null");
        this.expression = expression;
        return this;
    }

    public String buildMessage() {
        Objects.requireNonNull(expression, "expression is null");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expressionObject = parser.parseExpression(expression, new TemplateParserContext());
        return expressionObject.getValue(context, String.class);
    }
}