class Factor{
    public static long factor(long value){
        //System.out.println(i+""+counter);
        int i=1;
        long counter=value;
        if (value==1){
            value=(long)value;
            return value=(long)value;
        }else{
            while (i<counter){
                if(i<value){
                    value=value*i; 
                    i++; 
                    //System.out.println(i+""+value;
                }
            }
        return (long)value;
        }
    }
}

class Power{
    public static double power(double x, int p){
        //System.out.println(x+ "input");
        double counter=x;
        while (p>0){
            if (p>0){
                //System.out.println(p+ "p in for loop");
                //System.out.println(counter+" "+x);
                counter=counter*x;
                p=p-1;
            }
        }
        return (double)counter;
    }
}

public class Cosine {
    public static void main (String[ ]args){    
        double value;
        try {
            value=Double.parseDouble(args[0]);
            //System.out.println(value in main);
            long Value= Factor.factor((long)value);
            //System.out.println(Value+"factor in main");
            double Pow=Power.power((Value),3);
            //System.out.println(Pow+"power in main");
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number");
            return;
        }

    }
    
}
