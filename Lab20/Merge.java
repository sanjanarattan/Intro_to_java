import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class Merge {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("ERROR: can accept only 3 lists");
            return;
        } else {
            String list1 = args[0];
            int[] listOne = listMaker(list1);
            String list2 = args[1];
            int[] listTwo = listMaker(list2);
            String list3 = args[2];
            int[] listThree = listMaker(list3);



            int[] listFinal = mergeList(listOne, listTwo, listThree);
        }
    }

    private static int[] listMaker(final String file) {
        int[] list = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                br.close();
                return new int[0]; 
            }
            String[] fileSplit = line.split(" ");
            int length = fileSplit.length;
            list = new int[length];
            for (int i = 0; i < length; i++) {
                list[i] = Integer.parseInt(fileSplit[i]);
            }
            br.close();
        } catch (FileNotFoundException e) { 
            System.err.println("ERROR: File not found");
        } catch (IOException e) {
            System.err.println("ERROR: Failed to read file");
        } catch (NumberFormatException e) {
            System.err.println("ERROR: contains non-integer value(s)");
        }
        return list;
    }

    private static int[] mergeList(int[] list1, int[] list2, int[] list3) {
        int[] listFinal = new int[list1.length + list2.length + list3.length];
        int i = 0, j = 0, k = 0, m = 0;

        while (i < list1.length && j < list2.length && k < list3.length) {
            int num1 = list1[i];
            int num2 = list2[j];
            int num3 = list3[k];

            if (num1 <= num2 && num1 <= num3) {
                listFinal[m++] = num1;
                i++;
            } else if (num2 <= num1 && num2 <= num3) {
                listFinal[m++] = num2;
                j++;
            } else {
                listFinal[m++] = num3;
                k++;
            }
        }

        while (i < list1.length) {
            listFinal[m++] = list1[i++];
        }

        while (j < list2.length) {
            listFinal[m++] = list2[j++];
        }

        while (k < list3.length) {
            listFinal[m++] = list3[k++];
        }

        return listFinal;
    }
}


        