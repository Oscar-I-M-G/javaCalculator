package ivan;

import java.util.Scanner;

public class Main {


    private static Scanner scanner = new Scanner(System.in);

    private static String userInput;

    private static Double resultOutput = 0.0;

    private static String operator = "+";



    public static void main(String[] args) {
        /* Calculator | Exercise 2
        *
        * Create a Calculator similar to the first exercise!
        * However, this time use at least two custom methods (one for evaluating the operation and one for continuing)!
        *
        * Additionally, make sure if a Dividing by 0 would happen, you catch that and just return a 0 instead!
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