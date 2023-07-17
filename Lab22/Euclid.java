public class Euclid {
    public static void main(String[] args) {
        if (args.length < 2) {										//check to see if there are 2 arguements
            System.err.println("ERROR: Need 2 integers");
            System.exit(1);
        }

        try {
            int num1 = Integer.parseInt(args[0]);					//check to see if there are non-integer values
            int num2 = Integer.parseInt(args[1]);					//if not, parse args as ints and send to GCF finder
            int gcf = GCF_Finder(num1, num2);
            System.out.println(gcf);
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Invalid (non-integer) input: " + e.getMessage());
            System.exit(1);
        }
    }

    public static int GCF_Finder(int num1, int num2) {
        if (num2 == 0) {										//"end" goal in the recursion- loop works towards number 2->1
            return num1;
        } else {
            return GCF_Finder(num2, num1 % num2);				//keeps calling until num2=1 or num1 is not divisible by num2
        }
    }
}

