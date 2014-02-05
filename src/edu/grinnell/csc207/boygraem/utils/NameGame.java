package edu.grinnell.csc207.boygraem.utils;

import java.io.PrintWriter;

/*
 * Contains solutions for Assignment 3, Part D (The Name Game).
 * For CSC207 - 2014, taught by SamR
 * 
 * @author Graeme Boy (2014)
 * 
 */
public class NameGame
{
  /*
   * @nameGame takes in a string name, and outputs Ms. Ellis' lyrical verse
   * suitable for that name.
   * 
   * @param name, the string name that will be used to construct the verses.
   */
  public static String
    nameGame (String name)
  {
    // We use the substring( 1, stringIn.length ) quite often, so assign that.
    String sub = name.substring (1, name.length ());
    // Just add the relevent parts to a string result
    String result = name + "!\n" + name + ", " + name + " bo B" + sub
                    + " Bonana fanna fo F" + sub + " " + "\nFee fy mo M" + sub
                    + ", " + name + "!";
    // return the result.
    return result;
  } // nameGame (String)

  /*
   * The purpose of this main () method is purely to show that the nameGame
   * function works as expected, using examples.
   */
  public static void
    main (String[] args)
  {
    PrintWriter pen = new PrintWriter (System.out, true);
    pen.println (nameGame ("Lincoln") + "\n");
    /*
     * Expected output from above: Lincoln!\nLincoln, Lincoln bo Bincoln Bonana
     * fanna fo Fincoln\nFee fy mo Mincoln, Lincoln!
     */
    pen.println (nameGame ("Shirley") + "\n");
    pen.println (nameGame ("Sam") + "\n");
    // My one is a little more difficult.
    pen.println (nameGame ("Graeme"));
  } // main ()
} // class NameGame
