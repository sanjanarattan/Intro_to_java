public class Fractions {
    public static void main(String[] args){
        double value;

        //single command line arguement conditional

        if (args.length == 1){

            try {

                // code will try to parse as an int and return a decimal double if no error
                // this method is to account for integer inputs

                value = Double.parseDouble(args[0]);
                System.out.println(value);

                // nfe for inputs with " ", or "/ " 
                // for each conditional, the code splits long inputs into smaller ones
                // whole numbers w/ fractions are split into whole and num/den then added togther ("1 1/2")
                // negative of such are multiplied by -1
                // fractions are split into num/den

            } catch (NumberFormatException nfe) {

                if (args.length ==1 && args[0].contains("/") && args[0].contains(" ") && args[0].contains("-")){

                    String negative[]=args[0].split("-");
                    String Whole[]=negative[1].split(" ");
                    int whole=Integer.parseInt(Whole[0]);
                    String division2[]=Whole[1].split("/");
                    int num2=Integer.parseInt(division2[0]);
                    int den2=Integer.parseInt(division2[1]);
                    double fraction = (float)num2/den2;
                    double value2=(float)(whole+fraction);
                    System.out.println(value2*-1);

                }else if (args.length ==1 && args[0].contains("/") && args[0].contains(" ")){

                    String space[]=args[0].split(" ");
                    int whole=Integer.parseInt(space[0]);
                    String division2[]=space[1].split("/");
                    int num2=Integer.parseInt(division2[0]);
                    int den2=Integer.parseInt(division2[1]);
                    double fraction = (float)num2/den2;
                    double value2=(float)(whole+fraction);
                    System.out.println(value2);

                }else if (args.length == 1 && args[0].contains("/")) {

                    String division[] = args[0].split("/");
                    int num = Integer.parseInt(division[0]);
                    int den = Integer.parseInt(division[1]);
                    value = (float) num / den;   
                    System.out.println(value);

                }else {
                    System.out.println("System.err");
                }
            }

            // extra code to account for 2 args for cases such as 1 1/2

        } else if (args.length ==2 &&args[1].contains("/")) {

            try {
                value = Double.parseDouble(args[1]);
                System.out.println(value);

            } catch (NumberFormatException nfe) {

                if (args.length==2 && args[1].contains("/")){
                    String space[]=args[0].split(" ");
                    int whole=Integer.parseInt(space[0]);
                    String division2[]=args[1].split("/");
                    int num2=Integer.parseInt(division2[0]);
                    int den2=Integer.parseInt(division2[1]);
                    double fraction = (float)num2/den2;
                    double value2=(float)(whole+fraction);
                    System.out.println(value2);
                    
                } else {
                    System.out.println("System.err");
                }
            }

        }else {
            
            System.out.println("System.err");
        }
    }   
} 





    