import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Decode {

    static class Node {
        String huffystr;
        Node left;
        Node right;

        public Node(String huffystr) {
            //this.huffystr = huffystr;
            this.left = null;
            this.right = null;
            //System.out.println("debug 4 nodestring " + huffystr);
        }
    }

    private static void huffy_tree(Node root, String huffman) {
        Node currentNode = root;
        for (char bit : huffman.toCharArray()) {
            if (bit == '0') {
                if (currentNode.left == null) {
                    currentNode.left = new Node("");
                }
                currentNode = currentNode.left;
            } else if (bit == '1') {
                if (currentNode.right == null) {
                    currentNode.right = new Node("");
                }
                currentNode = currentNode.right;
            }
        }
        currentNode.huffystr = huffman;
        //System.out.println("debug 5 storing to node " + currentNode.huffystr);

    }

    public static void main(String[] args) {

        HashMap<String,Integer> code_map = new HashMap<>();
        String book = "codebook";
        Node root = new Node(""); // Create an empty root Node
        Node curr_node = root; // Initialize current node to root
        int temp;

        try {
            File codebook = new File(book);
            Scanner scanner = new Scanner(codebook);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                int ascii = Integer.parseInt(parts[0]);
                String huffman = parts[1];
                //System.out.println("debug 1: "+ huffman);
                code_map.put(huffman,ascii);
                //System.out.println("hasmap:"+code_map);
                huffy_tree(root, huffman); // Build the Huffman tree
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("ERROR READING CODEBOOK");
            return;
        }

        try {
            BufferedReader huffy_input = new BufferedReader(new FileReader(args[0]));
            BufferedWriter ascii_output = new BufferedWriter(new FileWriter(args[1]));

            while ((temp = huffy_input.read()) != -1) {
                char bit = (char) temp;
                if (bit == '0') {
                    curr_node = curr_node.left;
                } else if (bit == '1') {
                    curr_node = curr_node.right;
                }
                if (curr_node.left == null && curr_node.right == null) {
                    String huffman = curr_node.huffystr;
                    int ascii = code_map.get(huffman);
                    //System.out.println("debug 2: "+ ascii);
                    if (ascii == 4) {
                        break;
                    }
                    char character = (char) ascii;
                    ascii_output.write(character);
                    curr_node = root;
                }
            }

            huffy_input.close();
            ascii_output.close();

        } catch (IOException e) {
            System.out.println("Invalid file");
        }
    }
}
