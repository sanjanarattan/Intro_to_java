import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        double value = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");

        try {
            value = sc.nextDouble();
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number");
            return;
        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter function:");
        String function = sc2.nextLine();
        function = function.toLowerCase();

        try {
            String letters="";
            for (int i = 0; i < 3; i++) {
                letters+=function.charAt(i);
            }
            switch (letters) {
                case "sin":
                    value = Math.sin(value);
                    System.out.println(value);
                    break;
                case "cos":
                    value = Math.cos(value);
                    System.out.println(value);
                    break;
                case "tan":
                    value = Math.tan(value);
                    System.out.println(value);
                    break;
                case "log":
                    value = Math.log(value);
                    System.out.println(value);
                    break;
                default:
                    System.out.println("not a valid function");
                    return;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Need at least first 3 letters of function");
            return;
        }

    }

}

