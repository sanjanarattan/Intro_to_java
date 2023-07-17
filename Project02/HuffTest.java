import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HuffTest {
    public static void main(String[] args) {

        String inputarg=args[0];
        String outputarg=args[1];
        String book = "codebook";
        HashMap<Integer, String> code_map = new HashMap<>();

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

        // input file and output file

        try {
            FileInputStream input = new FileInputStream(inputarg);
            Scanner in = new Scanner(input);
            StringBuilder outComp = new StringBuilder();

            if (in.hasNextLine()) {
                String inputString = in.nextLine();
                int i = 0;
                while (i < inputString.length()) {
                    char c = inputString.charAt(i);
                    if (c==1||c==2||c==3||c==5||c==6||c > 254|| Character.isISOControl(c)) {
                        i++;
                        continue; // Skip illegal characters
                    }
                    String code = code_map.get((int) c);
                    if (code == null) {
                        i++;
                        continue; // Skip characters not in the codebook
                    }
                    outComp.append(code);
                    i++;
                }
                //outComp.append("1011000011011");

                FileInputStream output = new FileInputStream(outputarg);
                Scanner out = new Scanner(output);
                String outputString = out.nextLine();

                if (!outputString.equals(outComp.toString())) {
                    int bytePosOutput = -1;
                    int j = 0;
                    for (int p = 0; i < inputString.length(); p++) {
                        char c = inputString.charAt(p);
                        if (c > 127 || Character.isISOControl(c)) {
                            continue; // Skip illegal characters
                        }
                        String inputCode = code_map.get((int) c);
                        if (inputCode == null) {
                            continue; // Skip characters not in the codebook
                        }
                        if (j >= outputString.length()) {
                            break; // End of output file reached
                        }
                        String outputCode = "";
                        while (j < outputString.length()) {
                            char d = outputString.charAt(j);
                            if (d == '0' || d == '1') {
                                outputCode += d;
                                if (inputCode.equals(outputCode)) {
                                    j++;
                                    break;
                                }
                            } else {
                                j++;
                                bytePosOutput++;
                            }
                        }
                    }

                    System.out.println("FAIL");

                } else {
                    System.out.println("PASS");
                }

                input.close();
                output.close();
            }

        } catch (IOException e) {
            System.out.println("ERROR READING FILES");
            return;
        }
    }
}



    
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
            output.close();

            System.out.println("PASS: files match");

        } catch (IOException e) {
            System.out.println("FAIL: error reading file: " + e.getMessage());
        }
    }*/