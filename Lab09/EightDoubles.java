import java.util.Scanner;
import java.util.Arrays;

public class EightDoubles {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers space between:");
        double[] Numbers = new double[8];
        double Average=0.0;
        
        //reads 8 doubles and organizes it into array

        for(int i=0; i<8;i++){
            Numbers[i]=sc.nextDouble();
        }
        
        // sorts numbers then prints

        Arrays.sort(Numbers);

        for(int i=0; i<8;i++){
            
            Average=Average+Numbers[i];
        }

        double RoundedAverage=((int) (100*Average))*0.01;

        System.out.println("Minimum "+Numbers[1]);
        System.out.println("Maximum "+Numbers[7]);
        System.out.println("Average "+RoundedAverage);

        // ignore____________________________________________________________________________________________________________
        //double[] NumOrder= new double[8];
        /*for(int i=0;i<8;i++){
            System.out.println(Numbers[i]);
        }*/


        /*for(int i=0;i<8;i++){
            if (i>0&&i<8 && Numbers[i]<Numbers[i-1]){
                NumOrder[i]=Numbers[i-1];
                System.out.println(NumOrder[i]);
                   
            }else if(i>0&&i<8 && Numbers[i]>Numbers[i-1]){
                NumOrder[i]=Numbers[i];
                System.out.println(NumOrder[i]);
            }
        
        }
        for(int i=0; i<8;i++){
            System.out.println(Numbers[i]);
        }*/
        
    }   
}

