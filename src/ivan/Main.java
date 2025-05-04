package ivan;

import java.util.Scanner;

public class Main {

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
        startCalculator();

    }

    public static void startCalculator(){
        Intro();
        // running loop
        while (true){

            // First operator
            do {
                userInput = enterInput(false);
                if (userInput.equals("exit") || userInput.equals("clear") || userInput.equals(";")){
                    break;
                }
                doOperator();
                if (operator.equals("exit") || operator.equals("clear")){
                    break;
                }
                operator = enterInput(true);
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
                clearData();
            }
        }
    }


    public static Boolean doOperator(){
        switch (operator){
            case "+": resultOutput += Double.parseDouble(userInput);
                return true;

            case "-":
                resultOutput -= Double.parseDouble(userInput);
                return true;

            case "*":
                resultOutput *= Double.parseDouble(userInput);
                return true;

            case "/":
                try {
                    resultOutput /= Double.parseDouble(userInput);
                    return true;
                } catch (Exception e){
                    System.out.println("Error division");
                    operator = "clear";
                    return false;
                }
            default: System.out.println("Error operator not valid" + operator);
                return false;

        }
    }

    public static String enterInput( Boolean isOperator) {
        // VARIABLES
        String inputResult;
        Scanner scanner  = new Scanner(System.in);

        System.out.printf("Enter %s : ", isOperator ? "number ": " operation");
        inputResult = scanner.next();

        return inputResult;
    }

    public static void Intro(){
        System.out.println("To exit type \"exit\" to clear screen and reset type \"clear\" , to end operation type \";\"");
    }

    public static void clearTerminal()  {
        for (int i =0; i <50; i++){
            System.out.println();
        }
    }

    public static void clearData() {
        resultOutput = 0.0;
        operator = "+";
    }

    public static void clearEverything() {
        clearTerminal();
        clearData();
        System.out.println("Reseting...");
        Intro();
    }

}