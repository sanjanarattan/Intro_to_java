import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blackjack {

    //server connection

    DataInputStream dis;
    DataOutputStream dos;

    public Blackjack(DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
    }

    private void write(DataOutputStream dos,String s) throws IOException {
        dos.writeUTF(s);
        dos.flush();
    }

    private String read() throws IOException {
        return dis.readUTF();
    }

    //hashmap for Values

    private static int Values(String x) {
    //String argument 'x' = card value
   
    // remove the last character (which is the suit)
        String number = x.substring(0, x.length() - 1);
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
    }   //The value if key is not found in the map.

    public static void main(String[] args) throws IOException {

        // Command line arguments as Strings
        String ipAddress = args[0];
        String ipPort = args[1];

        // Connect to the server
        Socket socket = new Socket(ipAddress, Integer.parseInt(ipPort));
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Blackjack bj = new Blackjack(dis, dos);

        //Protocols
        String dealer_command = bj.read();
        String reply;
        boolean game=true;
        int funds;
        boolean ace=false;
        while (game==true){
            if (dealer_command.contains("login")){
                reply="sprasad112:dojacat";
                bj.write(dos,reply);

            }else if (dealer_command.contains("bet")){
                String[] split_funds = dealer_command.split(":");
                funds=Integer.parseInt(split_funds[1]);
                if (funds==0){
                    reply="bet:0";
                    bj.write(dos,reply);
                }else if (funds>100){
                    reply="bet:50";
                    bj.write(dos,reply);
                }else if (funds<101){
                    reply="bet:25";
                    bj.write(dos,reply);
                }

            } else if (dealer_command.contains("play")) {

                List<String> my_total= new ArrayList<>();
                int MyTotal = 0;
                String[] split = dealer_command.split(":");
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
                    }
                }
                if (split.length==6 && (float)MyTotal/Values(split[4])==2.0f){
                    reply="split";
                    bj.write(dos,reply);
                }else if (ace==true&&MyTotal>21){
                    MyTotal-=10;
                    if (MyTotal<12){
                        reply="hit";
                        bj.write(dos, reply);
                    }
                }else if (MyTotal > 11 && MyTotal<21) {
                    reply = "stand";
                    bj.write(dos, reply);
                } else if (MyTotal <= 12) {
                    reply = "double";
                    bj.write(dos, reply);
                } 

            } else if (dealer_command.contains("status")) {

                System.out.println(dealer_command);

            } else if (dealer_command.contains("done")) {
                System.out.println(dealer_command);
                game = false;
                socket.close();

            }dealer_command = bj.read();
        }
    }
           
}

