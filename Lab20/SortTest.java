import java.io.*;
import java.util.Scanner;

class SortTest {
    public static void main(String[] args) {
        boolean fail = false;
        String fileInput = args[0];
        try {
            File readFile = new File(fileInput);
            Scanner sc = new Scanner(readFile);
            String fileStart = sc.nextLine();
            String[] fileFinal = fileStart.split(" ");
            if (fileFinal.length != 10000) {
                fail=true;
            }
            for (int i = 0; i < fileFinal.length - 1; i++) {
                int current = Integer.parseInt(fileFinal[i]);
                int next = Integer.parseInt(fileFinal[i + 1]);
                if (current > next) {
                    fail = true;
                    break;
                }
            }
        }catch (FileNotFoundException e) {
            fail=true;
        }catch (NumberFormatException e){
            fail=true;
        }

    if (fail) {
        System.out.println("FAIL incorrect element count");
    }else{
        System.out.println("PASS");  
        }
    }
}


