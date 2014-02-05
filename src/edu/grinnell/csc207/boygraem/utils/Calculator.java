package edu.grinnell.csc207.boygraem.utils;

import java.math.BigInteger;

/*
 * Contains a solution for Assignment 3, Part E (A Simple Calculator).
 * For CSC207 - 2014, taught by SamR
 * 
 * @author Graeme Boy (2014)
 * 
 */
public class Calculator
{
  public static BigInteger
    eval0 (String exprIn)
  {
    // Split the string into its arguments, using method created earlier.
    String args[] = StringUtils.splitAt (exprIn, ' ');
    // Start with 0.
    BigInteger result = BigInteger.valueOf (0);

    for (int i = 0; i < args.length; i++)
      {
        /*
         * There are 5 operations, so we have an if-statement for each. If we
         * encounter an operator, we surely will expect a number next,
         * therefore, take BigInteger of next item, perform the operation, and
         * increment i. While it would be nice to use switch-case, this won't
         * work for strings. If no operator is given, we add it to result, as in
         * the case of the starting number.
         */

        if (args[i].equals ("+"))
          {
            result = result.add (new BigInteger (args[i + 1]));
            i++;
          } // + 
        else if (args[i].equals ("-"))
          {
            result = result.subtract (new BigInteger (args[i + 1]));
            i++;
          } // -
        else if (args[i].equals ("*"))
          {
            result = result.multiply (new BigInteger (args[i + 1]));
            i++;
          } // *
        else if (args[i].equals ("/"))
          {
            BigInteger next = new BigInteger (args[i + 1]);
            if (next != BigInteger.valueOf (0))
              result = result.divide (next);
            i++;
          } // /
        else if (args[i].equals ("^"))
          {
            result = result.pow (Integer.parseInt (args[i + 1]));
            i++;
          } // ^
        else
          {
            BigInteger cur = new BigInteger (args[i]);
            result = result.add (cur);
          } // default
      } // for, i

    return result;
  } // eval0 (String)
} // class Calculator
