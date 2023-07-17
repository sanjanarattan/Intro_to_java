import java.util.Scanner;

class WordCounter {

    // first function within class WordCounter checks for "the" //
    // second function checks for "a/an" //
    // both a for loop which checks for each term and adds to a count variable when it occurs //


    double check_for_the(String input) {
        String[] input_split = input.split(" ");
        double total_words = input_split.length;
        double count_marker = 0.0;
        for (int i = 0; i < total_words; i++) {
            String lowercase_input = input_split[i].toLowerCase();
            if (lowercase_input.equals("the")) {
                count_marker += 1.0;
            }
        }
        return (int)((count_marker/total_words)*100);
    }


    double check_for_a(String input) {
        String[] input_split = input.split(" ");
        double total_words = input_split.length;
        double count_marker = 0.0;
        for (int i = 0; i < total_words; i++) {
            String lowercase_input = input_split[i].toLowerCase();
            if (lowercase_input.equals("a")) {
                count_marker += 1.0;
            }else if(lowercase_input.equals("an")) {
                count_marker += 1.0;
            }
        }
        return (int)((count_marker/total_words)*100);
    }
    
}

class Plagiarism {
    public static void main(String[] args) {

        // within the main class, we call for each function and print the return values //
    
        WordCounter words = new WordCounter();
        double percentage_the = words.check_for_the(args[0]);
        double percentage_a=words.check_for_a(args[0]);
        System.out.println("Percentage of THE words is " + (int)percentage_the);
        System.out.println("Percentage of A or AN words is " + (int)percentage_a);
    }
}
