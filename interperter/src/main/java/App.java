import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class App {

  public static void main (String[] args) {
    final var tokenString = "4 3 2 - 1 + * ";
    var stack = new Stack<Expression>();
    var tokenList = tokenString.split(" ");
    for (var s : tokenList) {
      if (isOperator(s)) {
        Expression rightExpression = stack.pop();
        Expression leftExpression = stack.pop();
        Expression operatorInstance = getOperatorInstance(s, leftExpression, rightExpression);
        int result = operatorInstance.interpret();
        log.info("operator  {} {} {} = {}", leftExpression, operatorInstance, rightExpression, result);
        NumberExpression resultExpression = new NumberExpression(result);
        stack.push(resultExpression);
      } else {
        NumberExpression numberExpression = new NumberExpression(s);
        stack.push(numberExpression);
      }
    }
    log.info("result:{}", stack.pop().interpret());
  }

  private static boolean isOperator (String s) {
    return  "+".equals(s) ||  "-".equals(s) || "*".equals(s);
  }

  private static Expression getOperatorInstance (String s, Expression left, Expression right) {
    switch (s) {
      case "+":
        return new PlusExpression(left, right);
      case "-":
        return new MinusExpression(left, right);
      default:
        return new MultiplyExpression(left, right);
    }
  }
}
