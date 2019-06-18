/*
Elia Hernandez Lab003 completed with Demi Iglesias
COP3502
Scientific Calculator-(allows user use previous result) contains while loop; switch statement; parseDouble; new DecimalFormat;
 */


import java.util.Scanner;
import java.lang.Math;
import java.text.*;

public class SciCalculator {
    public static double result(String operand, double pastResult) {
        if (operand.equals("RESULT")) {
            return pastResult;
        } else {  //this else statement keeps the anything other than RESULT as a double
            return Double.parseDouble(operand);
        }
    }

    public static void mainMenu( double currentResult) {
        System.out.println("Current Result: " + currentResult + "\n");
        System.out.println("Calculator Menu \n" + "---------------\n"
                + "0. Exit Program \n"
                + "1. Addition \n"
                + "2. Subtraction \n"
                + "3. Multiplication \n"
                + "4. Division \n"
                + "5. Exponentiation \n"
                + "6. Logarithm \n"
                + "7. Display Average ");

        System.out.println("\nEnter Menu Selection: ");
    }

    public static void main(String[] args) { //Contains all operations of scientific calculator

        Scanner scnr = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        //Declare data types
        double operandOne;
        double operandTwo;
        double currentResult = 0.0;
        double pastResult;
        double sumOfCalc = 0;
        double avgOfCalc;
        int numberOfCalc = 0;
        int menuSelection;
        boolean newCalc = true; //used once operands have been entered and ready to complete new calculation from menu selection
        boolean caseZero = false; //used the exception in printing the menu when selection is 0 or 7

        //Begin calculator menu
        mainMenu(currentResult);
        menuSelection = scnr.nextInt();

        while (menuSelection != 0 || menuSelection != 7) {
            if (menuSelection < 0 || menuSelection > 7) {
                System.out.println("Error: Invalid selection!");
                caseZero = true; //when case is true, it will allow the user to select a menu option again w/o the menu
            }
            if (newCalc) {
                switch (menuSelection) { //case for each menu option 0-7
                    case 1:
                        pastResult = currentResult; //This calls the previous result before a new calculation is made
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");
                        //In each case we will call a String so that when the user inputs RESULT the past result will be called
                        String operand = scnr.next();
                        operandOne = result(operand, pastResult);

                         operand = scnr.next();
                        operandTwo = result(operand, pastResult);

                        currentResult = operandOne + operandTwo;
                        System.out.println("Current Result: " + currentResult);

                        numberOfCalc++;
                        sumOfCalc += currentResult;
                        break;

                    case 2:
                        pastResult = currentResult;
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");
                        //the operand if-else statement is repeated in each case**
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandOne = pastResult;
                        } else {
                            operandOne = Double.parseDouble(operand);
                        }
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandTwo = pastResult;
                        } else {
                            operandTwo = Double.parseDouble(operand);
                        }
                        currentResult = operandOne - operandTwo;
                        System.out.println("Current Result: " + currentResult);

                        sumOfCalc += currentResult;
                        numberOfCalc++;
                        break;
                    case 3:
                        pastResult = currentResult;
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");

                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandOne = pastResult;
                        } else {
                            operandOne = Double.parseDouble(operand);
                        }
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandTwo = pastResult;
                        } else {
                            operandTwo = Double.parseDouble(operand);
                        }

                        currentResult = operandOne * operandTwo;
                        System.out.println("Current Result: " + currentResult);

                        sumOfCalc += currentResult;
                        numberOfCalc++;
                        break;

                    case 4:
                        pastResult = currentResult;
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");

                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandOne = pastResult;
                        } else {
                            operandOne = Double.parseDouble(operand);
                        }
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandTwo = pastResult;
                        } else {
                            operandTwo = Double.parseDouble(operand);
                        }

                        currentResult = operandOne / operandTwo;
                        System.out.println("Current Result: " + currentResult);

                        sumOfCalc += currentResult;
                        numberOfCalc++;
                        break;

                    case 5:
                        pastResult = currentResult;
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");

                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandOne = pastResult;
                        } else {
                            operandOne = Double.parseDouble(operand);
                        }
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandTwo = pastResult;
                        } else {
                            operandTwo = Double.parseDouble(operand);
                        }

                        currentResult = Math.pow(operandOne, operandTwo);
                        System.out.println("Current Result: " + currentResult);

                        sumOfCalc += currentResult;
                        numberOfCalc++;
                        break;

                    case 6:
                        pastResult = currentResult;
                        System.out.println("Enter first operand: " +
                                "\nEnter second operand: ");

                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandOne = pastResult;
                        } else {
                            operandOne = Double.parseDouble(operand);
                        }
                        operand = scnr.next();
                        if (operand.equals("RESULT")) {
                            operandTwo = pastResult;
                        } else {
                            operandTwo = Double.parseDouble(operand);
                        }

                        currentResult = Math.log(operandTwo) / Math.log(operandOne);
                        System.out.println("Current Result: " + currentResult);

                        sumOfCalc += currentResult;
                        numberOfCalc++;
                        break;

                    case 7:
                        if (numberOfCalc == 0) {
                            caseZero = true; // allow user to input new selection
                            System.out.println("Error: No calculations yet to average!");

                        } else {
                            avgOfCalc = (sumOfCalc / numberOfCalc);
                            //https://stackoverflow.com/questions/8137218/trim-double-to-2-decimal-places
                            System.out.println("Sum of calculations: " + (df.format(sumOfCalc)));
                            System.out.println("Number of calculations: " + numberOfCalc);
                            System.out.println("Average of calculations: " + (df.format(avgOfCalc)));
                            caseZero = true; // allow user to input new selection
                        }
                        break;

                    case 0:
                        System.out.println("Thanks for using this calculator. Goodbye!");
                        System.exit(1);
                        break;
                }
            }
            //before the menu is executed we want to make sure it does not print for case 0 or 7 so this will be run through first
            if (caseZero) { //this occurs during case 0 and 7 if used when 0 calculations have occurred
                caseZero = false;
                System.out.println("\nEnter Menu Selection: ");
                menuSelection = scnr.nextInt();
                newCalc = true;
                continue;//using continue allows me to skip the rest of the menu and go back to the beginning of the while loop
            }
            //menu is within the while loop because we want it to print out after each case, with the exception of when caseZero occurs
            System.out.println("Calculator Menu \n" + "---------------\n"
                    + "0. Exit Program \n"
                    + "1. Addition \n"
                    + "2. Subtraction \n"
                    + "3. Multiplication \n"
                    + "4. Division \n"
                    + "5. Exponentiation \n"
                    + "6. Logarithm \n"
                    + "7. Display Average ");

            System.out.println("\nEnter Menu Selection: ");
            menuSelection = scnr.nextInt();
            newCalc = true; // newCalc is set to true which will allow for a new calculation

        }
    }
}