import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

public class Encode {
    public static void main(String[] args) {

        HashMap<Integer, String> code_map = new HashMap<>();
        StringBuilder huffer = new StringBuilder();
        String book = "codebook";
        int temp;

        try {
            FileInputStream codebook = new FileInputStream(book);
            Scanner scanner = new Scanner(codebook);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                int ascii = Integer.parseInt(parts[0]);
                String huffman = parts[1];
                code_map.put(ascii, huffman);
            }

            codebook.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("ERROR READING CODEBOOK");
            return;
        }

        try {
            
            BufferedReader ascii_input = new BufferedReader(new FileReader(args[0]));//read args 0=input
            BufferedWriter huffy_output = new BufferedWriter(new FileWriter(args[1]));//update args 1=output

            while ((temp = ascii_input.read()) != -1) { //keep going until end of file
                char c = (char) temp;
                if (c==1||c==2||c==3||c==5||c==6||c > 254|| Character.isISOControl(c)) {
                    continue; // Skip illegal characters
                }
                String code = code_map.get((int) c);
                if (code == null) {
                    continue; // Skip characters not in the codebook
                }
                huffer.append(code);
            }

            huffer.append((char)4);//EOT
            huffy_output.write(huffer.toString());//convert stringbuilder to string
            ascii_input.close();
            huffy_output.close();

        } catch (IOException e) {
            System.out.println("Invalid file(s)");
        }
    }
}

    






//_______________________________________________________________________________________________________________________________


//TODO:___________________________-
//close all scanners
//why do i havee to use buffer
//buffre v scanneer??
//why cant i save output???
//comments

//https://www.geeksforgeeks.org/character-isisocontrol-method-with-examples-in-java/

//Errors:__________________________-


//HUH??????????                                           Sunday update: Cannot treat stringbuilder as string
/*huffy_output.write(huffer);
                        ^
    method Writer.write(char[]) is not applicable
      (argument mismatch; StringBuilder cannot be converted to char[])
    method Writer.write(String) is not applicable
      (argument mismatch; StringBuilder cannot be converted to String)
    method BufferedWriter.write(int) is not applicable
      (argument mismatch; StringBuilder cannot be converted to int)
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output */


//scanner error-> use buffer instead
/*java.util.Scanner[delimiters=\p{javaWhitespace}+][position=0][match valid=false]
[need input=false][source closed=false][skipped=false][group separator=\x{2c}][decimal separator=\x{2e}]
[positive prefix=][negative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\QNaN\E][infinity string=\Q∞\E] */


//Old Code:__________________________-


//StringBuilder outComp = new StringBuilder();

           /*  if (in.hasNextLine()) {
                String inputString = in.nextLine();
                for (int i=0;i < inputString.length();i++) {
                    char c = inputString.charAt(i);
                    if (c > 127 || Character.isISOControl(c)) {
                        i++;
                        continue; // Skip illegal characters
                    }
                    String code = codeMap.get((int) c);
                    if (code == null) {
                        i++;
                        continue; // Skip characters not in the codebook
                    }
                    outComp.append(code);
                }
                outComp.append("1011000011011");
                System.out.println(outComp);
                input.close();
            }*/
            /*for (int i = 0; i < inputText.length(); i++) {
                if ((int) inputText.charAt(i) == 1 || (int) inputText.charAt(i) == 2 || (int) inputText.charAt(i) == 3 ||(int) inputText.charAt(i) == 5 || (int) inputText.charAt(i) == 6 || (int) inputText.charAt(i) > 254) {
                    continue;
                }

                String huffCompare = codeMap.get((int) inputText.charAt(i));
                if (huffCompare == null || huffCompare.length() == 0) {
                    System.out.println("FAIL: cannot find huffman code for " + inputTemp);
                    return;
                }
            }
            input.close();
            output.close()
            System.out.println("PASS: files match");
        } catch (IOException e) {
            System.out.println("FAIL: error reading file: " + e.getMessage());
        }
    }*/

    //buffer read scanner