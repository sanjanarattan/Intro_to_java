import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        String command2 = "play:dealer:9S:you:9C:AD:2D";
        String command = "bet:300:all:4D:8C";
        //String command="login"

        List<String> history= new ArrayList<>();
        boolean ace=false;
        int funds;
        String reply;

        if (command.contains("login")){
            reply="sprasad112:dojacat";
            System.out.println(reply);
        }else if (command.contains("bet")){
            String[] split_funds = command.split(":");
            funds=Integer.parseInt(split_funds[1]);
            System.out.println(funds);
            for (int i = 0; i < split_funds.length; i++) {
                if (split_funds[i].equals("all")) {
                    for (int j = i + 1; j < split_funds.length; j++) {
                        history.add(split_funds[j]);
                        System.out.println(history);
                    }
                    break;
                }
            }
            if (funds==0){
                reply="bet:0";
                System.out.println(reply);
            }else if (funds>100){
                reply="bet:50";
                System.out.println(reply);
            }else if (funds<101){
                reply="bet:25";
                System.out.println(reply);   
            }
        
        } if (command2.contains("play")) {

            List<String> my_total= new ArrayList<>();
            int MyTotal = 0;
            String[] split = command.split(":");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("you")) {
                    for (int j = i + 1; j < split.length; j++) {
                        my_total.add(split[j]);
                        MyTotal += Values(split[j]);
                        if (Values(split[j])==11){
                            ace=true;
                        }
                    }
                    break;
                    Bust probabiltity=Bust(history,MyTotal);
                }
            }System.out.println(MyTotal);
            if (split.length==6 && (float)MyTotal/Values(split[4])==2.0f){
                System.out.println(Values(split[4]));
                System.out.println("split");
            }else if (ace==true&&MyTotal>21){
                MyTotal-=10;
                System.out.println(MyTotal);
                if (MyTotal<=12){
                    System.out.println("ace less than 12");
                }
            }else if (MyTotal > 11 && MyTotal<21) {
                System.out.println("11-21");
            }else if (MyTotal < 12) {
                System.out.println("less than 12");
            } 

        } /*else if (command.contains("status")) {

            System.out.println("status");

        } else if (command.contains("done")) {
            System.out.println("done");
            
        }*/

    }

    private static int Values(String card) {
        String number = card.substring(0, card.length() - 1);
        Map<String, Integer> cardValues = new HashMap<>();
        cardValues.put("A", 11);
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("J", 10);
        cardValues.put("Q", 10);
        cardValues.put("K", 10);
        return cardValues.getOrDefault(number, 0);
    }

   
private static void Bust(List<String> myCards,int total) {
    for (int n = 0; n < myCards.size(); n++) {
        System.out.println(myCards.get(n));
    }
    
}
}








