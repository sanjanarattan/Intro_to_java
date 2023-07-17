
public class ParseWords {

    public static void main(String[] args) {
        
        String input=args[0];
        String[] words=input.split(":");
        for (int i=0; i<words.length;i++) {
            if (words[0].equals(":")) {
                System.out.println("BLANK");
            } else if (words[i].equals("")) {
                System.out.println("BLANK");
            } else {
                System.out.println(words[i]);
            }
        }
        
    }

}
