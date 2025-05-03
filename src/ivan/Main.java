package ivan;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static Scanner scanner = new Scanner(System.in);

    private static String userInput;

    private static Double resultOutput = 0.0;

    private static String operator = "+";



    public static void main(String[] args) {
        /* Easy Calculator
        * Create a Calulator that runs multiple times until you break out of it .
        * You should read the operation first, then read the first and second number.
        *
        * Depending on the operation chosen, you then have to return a different result.
        * You can do this with if statements or a switch statement.
        *
        * Please note that when reading in s String , you want to use scanner.next()
        * And When comparing strings you wanna use;
        * s.equals("string");
        *
        * afther the result has been output, ask the user if they want to continue, if not  end the program!
        * Estimated Time: 30 - 45 minutes
        *
        * */

        System.out.println("To exit type \"exit\" to clear screen and reset type \"clear\" , to end operation type \";\"");
        // running loop
        while (true){

            // First operator
            do {
                System.out.print("Enter a number (double) : ");
                userInput = scanner.next();
                if (userInput.equals("exit") || userInput.equals("clear")){
                    break;
                }
                switch (operator){
                    case "+": resultOutput += Double.parseDouble(userInput);
                        break;
                    case "-": resultOutput -= Double.parseDouble(userInput);
                        break;
                    case "*": resultOutput *= Double.parseDouble(userInput);
                        break;
                    case "/": resultOutput /= Double.parseDouble(userInput);
                        break;
                    default: System.out.println("Error operator not valid" + operator);
                        break;
                }
                System.out.println("Enter operator ");
                operator = scanner.next();
                if (operator.equals("exit") || operator.equals("clear")){
                    break;
                }

            }while (!userInput.equals(";") && !operator.equals(";") );

            if (operator.equals("exit") || userInput.equals("exit")){
                System.out.println("Exiting...");
                break;
            }else if(operator.equals("clear") || userInput.equals("clear")){
                clearEverything();
            }else{
                System.out.println("Result: " + resultOutput);
                resultOutput = 0.0;
                operator = "+";
            }

        }



    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearEverything() {
        clearScreen();
        System.out.println("Reseting...");
        System.out.println("To exit type \"exit\" to clear screen and reset type \"clear\" , to end operation type \";\"");
        resultOutput = 0.0;
        operator = "+";
    }

}