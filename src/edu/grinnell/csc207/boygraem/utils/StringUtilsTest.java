package edu.grinnell.csc207.boygraem.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Contains tests for Assignment 3, Parts A, B, C. 
 * For CSC207 - 2014, taught by SamR
 * 
 * @author Graeme Boy (2014)
 * 
 */
public class StringUtilsTest
{

  @Test
  public void
    partA ()
  {
    // Test splitAt(String, char)
    assertArrayEquals ("words seperated by space",
                       new String[] { "Harry", "Potter", "is", "a", "boy",
                                     "wizard" },
                       StringUtils.splitAt ("Harry Potter is a boy wizard", ' '));
    assertArrayEquals ("numbers seperated by colons", new String[] { "1", "1",
                                                                    "2", "3",
                                                                    "5", "8" },
                       StringUtils.splitAt ("1:1:2:3:5:8", ':'));
    assertArrayEquals ("some null values among numbers, seperated by colons",
                       new String[] { "1", "1", "2", "", "3", "5", "", "8" },
                       StringUtils.splitAt ("1:1:2::3:5::8", ':'));
    assertArrayEquals ("delimiter not present in string",
                       new String[] { "a b c" },
                       StringUtils.splitAt ("a b c", ':'));
    assertArrayEquals ("string with no characters", new String[] { "" },
                       StringUtils.splitAt ("", '-'));
    /*
     * Tests from SamR (2014) Acccessed at:
     * http://www.cs.grinnell.edu/~rebelsky/ +
     * Courses/CSC207/2014S/assignments/current.html
     */
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a:b:c", ':'));
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a b c", ' '));
    assertArrayEquals (new String[] { "a:b:c" },
                       StringUtils.splitAt ("a:b:c", ' '));
    assertArrayEquals ("one field", new String[] { "a" },
                       StringUtils.splitAt ("a", ':'));
    assertArrayEquals ("empty inner field", new String[] { "a", "", "c" },
                       StringUtils.splitAt ("a::c", ':'));
    assertArrayEquals ("leading empty field", new String[] { "", "a" },
                       StringUtils.splitAt (":a", ':'));
    assertArrayEquals ("trailing empty field", new String[] { "a", "" },
                       StringUtils.splitAt ("a:", ':'));
  } // test

  @Test
  public void
    partB ()
  {
    // Test splitCSV(String)
    /*
     * Tests from SamR (2014) Acccessed at:
     * http://www.cs.grinnell.edu/~rebelsky/ +
     * Courses/CSC207/2014S/assignments/current.html
     */
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitCSV ("a,b,c"));
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitCSV ("a,b,c"));
    assertArrayEquals (new String[] { "a,b", "c" },
                       StringUtils.splitCSV ("\"a,b\",c"));
    assertArrayEquals (new String[] { "a", "b,b\"", "c" },
                       StringUtils.splitCSV ("a,\"b,b\"\"\",c"));
  }

  @Test
  public void
    PartC ()
  {
    // Test deLeet(String)
    assertEquals ("Hello World", StringUtils.deLeet ("|-|3110 W0r1|)"));
    assertEquals ("Harry Potter is a boy wizard",
                  StringUtils.deLeet ("|-|@rry P0++3r is @ b0y wiz@r|)"));

    /*
     * Tests from SamR (2014) Acccessed at:
     * http://www.cs.grinnell.edu/~rebelsky/ +
     * Courses/CSC207/2014S/assignments/current.html
     */
    assertEquals ("e", StringUtils.deLeet ("3"));
    assertEquals ("leet", StringUtils.deLeet ("133+"));
    assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
  }

}