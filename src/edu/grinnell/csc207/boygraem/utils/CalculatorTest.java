package edu.grinnell.csc207.boygraem.utils;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

/*
 * Contains tests for Assignment 3, Part E (A Simple Calculator). 
 * For CSC207 - 2014, taught by SamR
 * 
 * @author Graeme Boy (2014)
 * 
 */
public class CalculatorTest
{

  @Test
  public void
    partE ()
  {
    // Test eval0(String)
    assertEquals ("-11 - 1 - 2 + 3 = -11", BigInteger.valueOf (-11),
                  Calculator.eval0 ("-11 - 1 - 2 + 3"));
    /*
     * Tests from SamR (2014) Acccessed at:
     * http://www.cs.grinnell.edu/~rebelsky/ +
     * Courses/CSC207/2014S/assignments/current.html
     */
    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("0"));
    assertEquals (BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
    assertEquals (BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
    assertEquals (BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));

    /*
     * 2 ^ 64 = 18446744073709551616 (verified on wolframalpha.com)
     */
    assertEquals (new BigInteger ("18446744073709551616"),
                  Calculator.eval0 ("2 ^ 64"));

  }

}
