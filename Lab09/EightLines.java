import java.util.Scanner;

public class EightLines {
    public static void main(String[] args) {

        int count=0;
        int i=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 8 lines:");
        String words="";

        //read each line until 8 lines are read
    
        while (sc.hasNextLine() && count<8) {
            words=words+" "+(sc.nextLine());
            i++;
            count++;
            if (count==8){
                break;
            }
        }
        
        // split and print array value at i

        if (count==8){
            String[] Words=words.split(" ");
                for(i=0;i<Words.length;i++){
                    System.out.println(Words[i]);
                    
                }
                
        }
        
    

        
        //ignore______________________________________________________________________________________________________________
        
        //String words="";
        //String Words="";
        /*if (count!=8){
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Length err");
            while (sc.hasNextLine()) {
                words = sc2.nextLine();
                count++;
            }
        }*/
        /*if (count==8){
            String[] Words=words.split(" ");
            for (int i = 0; i < 8; i++) {
                System.out.println(Words[i]);
            }*/
        //}
    }
}



