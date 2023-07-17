class Card {
    
    int value;
    String suit;
    
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;

        if (suit.equals("S")||suit.equals("s")) {
            this.suit = "S";
        } else if (suit.equals("H")||suit.equals("h")) {
            this.suit = "H";
        } else if (suit.equals("C")||suit.equals("c")) {
            this.suit = "C";
        } else if (suit.equals("D")||suit.equals("d")) {
            this.suit = "D";
        }else{
            this.suit="ERROR";
        }
        
        if (this.value>=2&&this.value<=14){
            this.value=value;
            }else{
                this.value=0;
        }  
    }   
    
    public Card(String input) {

        if (input.charAt(0) >= '2' && input.charAt(0) <= '9') {
            value = input.charAt(0);
        } else if (input.charAt(0) == '1') {
            if (input.charAt(1) == '0') {
                value = 10;
            }else{
                value=0;
            }
        } else if (input.charAt(0) == 'J' || input.charAt(0) == 'j') {
            value = 11;
        } else if (input.charAt(0) == 'Q' || input.charAt(0) == 'q') {
            value = 12;
        } else if (input.charAt(0) == 'K' || input.charAt(0) == 'k') {
            value = 13;
        } else if (input.charAt(0) == 'A' || input.charAt(0) == 'a') {
            value = 14;
        } else {
            value = 0;    
        }

        if (input.charAt(input.length() - 1) == 's' || input.charAt(input.length() - 1) == 'S') {
            suit = "S";
        } else if (input.charAt(input.length() - 1) == 'h' || input.charAt(input.length() - 1) == 'H') {
            suit = "H";
        } else if (input.charAt(input.length() - 1) == 'c' || input.charAt(input.length() - 1) == 'C') {
            suit = "C";
        } else if (input.charAt(input.length() - 1) == 'd' || input.charAt(input.length() - 1) == 'D') {
            suit = "D";
        } else {
            suit="ERROR";
        } 
    }
    public int value() {
        return value;
    }
    public String suit() {
        return suit;
    }
    public String print(){
        return(value+""+suit);
    }
    
}

class Deck {

    private Card[] allMyCards;
    public Deck() {
        allMyCards = new Card[52];
        int index = 0;
        String[] suits = {"s", "h", "c", "d"};
        int value = 2;
        while (value <= 14) {
            int i = 0;
            while (i < 4) {
                    allMyCards[index] = new Card(value, suits[i]);
                    index++;
                    i++; 
            }
            value++;
        }
    }
    public void print() {
        int i = 0;
        while (i < 52) {
            System.out.println(allMyCards[i].print());
            i++;
        }
    }
}


class MyCardDeck {
    public static void main(String[] args) {
        if (args.length == 2) {
            int value;
            String suit = args[1];
            try {
                value = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                switch (args[0].toUpperCase()) {
                    case "J":
                        value = 11;
                        break;
                    case "Q":
                        value = 12;
                        break;
                    case "K":
                        value = 13;
                        break;
                    case "A":
                        value = 14;
                        break;
                    default:
                        value=0;
                        return;
                }
            }
            Card card = new Card(value, suit);
            System.out.println(card.print()); 
        } else if (args.length == 1) {
            String input = args[0];
            Card card = new Card(input);
            System.out.println(card.print()); 
        } else if (args.length==0) {
            Deck deck=new Deck();
            deck.print();
        }
    }
}





