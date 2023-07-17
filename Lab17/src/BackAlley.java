import java.util.ArrayList;
import java.util.Random;
public class BackAlley {
    public static void main(String[] args) {

        int stack = 20; // player starts with a stack of $20
        ArrayList<Integer> myList = new ArrayList<Integer>();

        while (stack>0) {
        	
            int total = Dice.twodice();
            
            if (total == 7 || total == 11) {
                stack +=1;
                System.out.println("$" + stack + " win");
            } else if (total == 2 || total == 3 || total == 12) {
                stack -=1;
                System.out.println("$" + stack + " lose");
            } else {
                int point=total;
                total=0;
                while(total!=point) {
                    total = Dice.twodice();
                    myList.add(total);
                }
                if (total==point) {
      
                   if (myList.contains(7)) {
                	   stack-=1;
                       System.out.println("$" + stack + " lose");
                	   myList.removeAll(myList);
   
                	   }else {
                		   stack+=1;
                           System.out.println("$" + stack + " win");
                    	   myList.removeAll(myList);

                   }
                }
                
            }
        }
    }

    class Die {
        public static int roll() {
            Random rand = new Random();
            int die = rand.nextInt(0,7);
            return die;
        }
    }

    class Dice {
        public static int twodice() {
            int die1 = Die.roll();
            int die2 = Die.roll();
            return die1 + die2;
        }
    }
}


