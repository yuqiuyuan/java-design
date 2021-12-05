import java.util.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExpressionTest {

  @Test
  void stackTest(){
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3,stack.pop());
    assertEquals(2,stack.pop());
    assertEquals(1,stack.pop());
  }

}