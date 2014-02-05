package edu.grinnell.csc207.boygraem.utils;

import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Contains answers to Assignment 3, Problems A, B, C. 
 * For CSC207 - 2014, taught by SamR
 * 
 * @author Graeme Boy (2014)
 * 
 */

public class StringUtils
{
  /*
   * @splitAt takes in a string and a character, and uses the character as a
   * delimiter to split the string input. For example: splitAt ( "Harry Potter",
   * ' ' ) returns [ "Harry", "Potter" ]
   * 
   * @param stringIn, the string to be split
   * 
   * @param delimiter, the character with which to split up the string
   * 
   * @return result, an array of the components of stringIn split by delimiter
   */
  public static String[]
    splitAt (String stringIn, char delimiter)
  {
    // Create a resizable ArrayList to hold our components:
    ArrayList<String> result = new ArrayList<String> ();
    int mark = 0; // mark will hold where the last split took place
    // Iterate through each character in the string
    for (int i = 0; i < stringIn.length (); i++)
      {
        // Check if this character is the delimiter
        if (stringIn.charAt (i) == delimiter)
          { // we have reached a delimiter
            // add what we have (since last mark) to the result list
            result.add (stringIn.substring (mark, i));
            mark = i + 1; // update the mark
          }
      }
    // add the remainder to the list
    result.add (stringIn.substring (mark, stringIn.length ()));
    // return the list as an array of the same size as the list
    return result.toArray (new String[result.size ()]);
  } // splitAt(String, char)

  /*
   * @splitCSV takes in a string that has comma-seperated values, and splits
   * that string into its component parts. It allows the use of quotes to
   * describe when commas should be included in one part (or item). Furthermore,
   * double quotes are treated as a single quote to be included in one part. I
   * have heavily commented this function, but it's really only about 17 lines.
   * 
   * @param stringIn, a string of comma-seperated values
   * 
   * @pre stringIn is properly formatted according to CSV standards
   * 
   * @return result, an array consisting of the components of the CSV
   */
  public static String[]
    splitCSV (String stringIn)
  {
    // ArrayList result holds the strings that we will return.
    ArrayList<String> result = new ArrayList<String> ();
    // Boolean ignoreComma is true when characters are wrapped by quotes
    boolean ignoreComma = false;
    // String temp holds the current version of the string to be added to result
    String temp = "";

    // Iterate through the chars of stringIn, checking for "," or double quotes
    for (int i = 0; i < stringIn.length (); i++)
      {
        if (stringIn.charAt (i) == '"')
          {
            /*
             * If a quote follows this one, we add this one and ignore the next
             * one (thus treating them as one symbol.)
             */
            if (stringIn.charAt (i + 1) == '"')
              {
                temp += stringIn.charAt (i); // add this one
                i++; // ignore next
              } // if charAt (i + 1) == "'"
            else
              // single quotation mark
              /*
               * The characters to follow are wrapped in quotes; thus we toggle
               * ignoreCommas, which signals to ignore commas.
               */
              ignoreComma = !ignoreComma;
          } // if charAt == '"'
        else if (stringIn.charAt (i) == ',' && !ignoreComma)
          {
            /*
             * We have encountered a comma that is not surrounded by quotes.
             * Thus, we ought to add what we have in temp to the result list,
             * and reset temp to an empty string.
             */
            result.add (temp);
            temp = "";
          } // else if charAt == ',' and not ignoreComma
        else
          /*
           * Otherwise, we have simply encountered a character that must be
           * added to the temp string.
           */
          temp += stringIn.charAt (i);
      } // for, i

    // add the remainder of the input to the list.
    result.add (temp);

    /*
     * Boolean ignoreCase should always be false at this point (because it
     * toggles according to quotes, the number of which we expect to be even.)
     * If it is not false, then there is probably a formatting error. We should
     * inform the user in this case.
     */
    if (ignoreComma)
      {
        PrintWriter pen = new PrintWriter (System.out, true);
        pen.println ("Warning: The number of quotes in the CSV given was odd."
                     + "This might indicate a formatting error.");
      }
    // return a String [] from our ArrayList variable.
    return result.toArray (new String[result.size ()]);
  } // splitCSV ( String )

  /*
   * @deLeet takes in a string of text written in the pseudo-language known
   * commonly as 133+, and returns a direct transliteration into English.
   * 
   * @param stringIn, a string of 133+ characters
   * 
   * @return result, a transliteration of stringIn into English
   */
  public static String
    deLeet (String stringIn)
  {
    /*
     * Create a dictionary of symbols to english equivalents. This can be done
     * with a 1:1 mapping of an array of symbols to an array of "meanings" (key
     * to value.) Symbols must be ordered by precedence, and therefore compound
     * symbols must be included first, and ordered by length of characters (E.g.
     * |3 must become 'b', before the '3' becomes 'e'.)
     */
    final String[] LEET_SYMBOLS = { "|\\|", "|3", "|)", "|-|", "0", "3", "1",
                                   "+", "5", "@" };
    final String[] LEET_MEANINGS = { "n", "b", "d", "H", "o", "e", "l", "t",
                                    "s", "a" };
    String result = ""; // holds the translation
    String letter = ""; // temporary, holds the characters to be added to result

    for (int i = 0; i < stringIn.length (); i++) // Walk through stringIn
      {
        /*
         * Initially, assume no change will be made, and set our letter string
         * to the current character.
         */
        letter = "" + stringIn.charAt (i);
        /*
         * Iterate through the known symbols; check if they are contained in the
         * string.
         */
        for (int x = 0; x < LEET_SYMBOLS.length; x++)
          {
            /*
             * For a replacement to occur, the remaining length of the string
             * must be longer than the known leet symbol, and the substring of
             * stringIn, the length of the symbol, must equal that symbol.
             */
            if (stringIn.length () >= i + LEET_SYMBOLS[x].length ()
                && stringIn.substring (i, i + LEET_SYMBOLS[x].length ())
                           .equalsIgnoreCase (LEET_SYMBOLS[x]))
              {
                // If that is true, add the "meaning" of the symbol.
                letter = LEET_MEANINGS[x];
                /*
                 * If it was a compound letter, we must skip length - 1.
                 * example: If the length is 2, skip one
                 */
                i += (LEET_SYMBOLS[x].length () - 1);
                /*
                 * once we've replaced the symbol, there is no reason to check
                 * further.
                 */
                break;
              } // if length >= leetSymbol && stringIn.substring == leetSymbol
          } // for each leetSymbol
        result += letter;
      } // for each character in stringIn
    return result;
  } // deLeet ( String )

} // StringUtils