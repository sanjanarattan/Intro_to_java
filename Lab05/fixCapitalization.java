import java.util.Scanner;

class fixCapitalization {
    public static void main(String[] args) {

        String capit = args[0];
        StringBuilder fixedText = new StringBuilder(capit.length());

        // iterate over each character in the input text //
        // rules: first letter of each sentence is capital; and 2 chars before punctuation //
        // for loop checks for these and everything else is set to lowercase //


        for (int i = 0; i < capit.length(); i++) {
            char current = capit.charAt(i);
            if (i == 0) {

                fixedText.append(Character.toUpperCase(current));

            } else if (i >= 2 && capit.charAt(i - 2) == '.') {
                
                fixedText.append(Character.toUpperCase(current));
            
            }else if (i >= 2 && capit.charAt(i - 2) == '!') {
                
                fixedText.append(Character.toUpperCase(current));
            
            }else if (i >= 2 && capit.charAt(i - 2) == '?') {
                
                fixedText.append(Character.toUpperCase(current));
                    
                        
            }else{

                fixedText.append(Character.toLowerCase(current));
                
            }
        }

        System.out.println( fixedText.toString());
    }
}

