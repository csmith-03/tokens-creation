// Channing Smith
// I did this assignment all by myself, but I spoke with Josh about using the pattern and matcher class.
// Homework 2 - CSCI 320 (Due Sunday, February 13th)

import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;

class HW2 {
  public static void main(String[] args) {

    // tokens listed below
    String TT_PLUS = "[+]"; // addition
    String TT_LPAREN = "[(]"; // left paren
    String TT_RPAREN = "[)]"; // right paren
    String TT_MINUS = "[-]"; // subtraction
    String  TT_IDENT = "[a-zA-Z]+"; // identifiers
    String TT_NUM = "[0-9]+"; // number
    String TT_ASSIGN = "[=]"; // assignment
    String TT_TIMES = "[*]"; // multiplication
    String TT_EOL = "[\n]"; // end of line

    // assume 50 lines in a file
    String line[] = new String[50];

    // scanner for question
    Scanner question = new Scanner(System.in);
    System.out.println("Would you like to specify a file or provide input from keyboard?\n Type 'F' for file or 'K ' for keyboard: ");
    // gets answer to question
    String answer = question.nextLine();

    // this is for if the user wants to read from a file
    if (answer.equals("F")) {
      try {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your file name: ");
        String fileName = keyboard.nextLine();
        // reads from file
        Scanner inputFile = new Scanner(new File(fileName));

        // initialize line number
        int lineNumber = 0;

        // as long as inputFile has a next line
        while (inputFile.hasNext()) {
          line[lineNumber] = inputFile.nextLine();
          StringTokenizer tokenizerfile = new StringTokenizer(line[lineNumber]);
          // increment line number
          lineNumber++;

          for (int index = 0; index < lineNumber; index++) {
            // splits words at spaces
            String[] words = line[index].split(" ");
            // temporary
            String temp = "";

            for (int i = 0; i < words.length; i ++) {
              // gets next token
              temp = tokenizerfile.nextToken();
              // below are the statements for matching the word to the correct token type.
              if (words[i].matches(TT_MINUS)) {
                System.out.println("TT_MINUS token at [" + words[i] + "] : ");
              }
              if (words[i].matches(" ")) {
                continue;
              }
              else if (words[i].matches(TT_PLUS)) {
                System.out.println("TT_PLUS: " + words[i]);
              }
              else if (words[i].matches(TT_LPAREN)) {
                System.out.println("TT_LPAREN: " + words[i]);
              }
              else if (words[i].matches(TT_RPAREN)) {
                System.out.println("TT_RPAREN: " + words[i]);
              }
              else if (words[i].matches(TT_IDENT)) {
                System.out.println("TT_IDENT: " + words[i]);
              }
              else if (words[i].matches(TT_NUM)) {
                System.out.println("TT_NUM: " + words[i]);
              }
              else if (words[i].matches(TT_ASSIGN)) {
                System.out.println("TT_ASSIGN: " + words[i]);
              }
              else if (words[i].matches(TT_TIMES)) {
                System.out.println("TT_TIMES: " + words[i]);
              }
              else if (words[i].matches(TT_EOL)) {
                System.out.println("TT_EOL: " + words[i]);
              }
              else {
                System.out.println("TT_ERROR: " + words[i]);
              }
          }
        }
      }
    }
    // if the file is not found
    catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("File not found. Please try again.");
    }
  }
  // if the user wants to type input rather than read from a file.
  else {
    // scanner for input
    Scanner input = new Scanner(System.in);
    System.out.println("Type input, separated by spaces. As in 'a + b + c': ");
    String userInput = input.nextLine();
    // tokenizes the userInput
    StringTokenizer tokenizer = new StringTokenizer(userInput);

    // below is where we compile the regex as a pattern
    Pattern plusPattern = Pattern.compile(TT_PLUS);
    Pattern leftPattern = Pattern.compile(TT_LPAREN);
    Pattern rightPattern = Pattern.compile(TT_RPAREN);
    Pattern minusPattern = Pattern.compile(TT_MINUS);
    Pattern identPattern = Pattern.compile(TT_IDENT);
    Pattern numPattern = Pattern.compile(TT_NUM);
    Pattern assignPattern = Pattern.compile(TT_ASSIGN);
    Pattern timesPattern = Pattern.compile(TT_TIMES);
    Pattern eolPattern = Pattern.compile(TT_EOL);

    // creates variable for matches to the pattern
    Matcher plusMatcher = plusPattern.matcher(userInput);
    Matcher leftMatcher = leftPattern.matcher(userInput);
    Matcher rightMatcher = rightPattern.matcher(userInput);
    Matcher minusMatcher = minusPattern.matcher(userInput);
    Matcher identMatcher = identPattern.matcher(userInput);
    Matcher numMatcher = numPattern.matcher(userInput);
    Matcher assignMatcher = assignPattern.matcher(userInput);
    Matcher timesMatcher = timesPattern.matcher(userInput);
    Matcher eolMatcher = eolPattern.matcher(userInput);

    // counts the number of tokens
    int count = tokenizer.countTokens();
    System.out.println("Number of tokens: " + count);
    // int i = 0;
    String temp = "";

    for (int i = 0; i < count; i++) {
      temp = tokenizer.nextToken();

      // below are the statements for matching to the correct token type.
      if (minusPattern.matches(TT_MINUS, temp)) {
        System.out.println("TT_MINUS token at [" + i + "] : " + temp);
      }
      else if (plusPattern.matches(TT_PLUS, temp)) {
        System.out.println("TT_PLUS token at [" + i + "] : " + temp);
      }
      else if (leftPattern.matches(TT_LPAREN, temp)) {
        System.out.println("TT_LPAREN token at [" + i + "] : " + temp);
      }
      else if (rightPattern.matches(TT_RPAREN, temp)) {
        System.out.println("TT_RPAREN token at [" + i + "] : " + temp);
      }
      else if (identPattern.matches(TT_IDENT, temp)) {
        System.out.println("TT_IDENT token at [" + i + "] : " + temp);
      }
      else if (numPattern.matches(TT_NUM, temp)) {
        System.out.println("TT_NUM token at [" + i + "] : " + temp);
      }
      else if (assignPattern.matches(TT_ASSIGN, temp)) {
        System.out.println("TT_ASSIGN token at [" + i + "] : " + temp);
      }
      else if (timesPattern.matches(TT_TIMES, temp)) {
        System.out.println("TT_TIMES token at [" + i + "] : " + temp);
      }
      else if (eolPattern.matches(TT_EOL, temp)) {
        System.out.println("TT_EOL token at [" + i + "] : " + temp);
      }
      else {
        System.out.println("TT_ERROR token at [" + i + "] : " + temp);
      }

  }
}
}
}
