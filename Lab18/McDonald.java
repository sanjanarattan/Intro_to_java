import java.util.Random;
/** filename: McDonald.java
 *
 * The classes in this file implement several types of animals,
 * all derived from the abstract class Animal.
 *
 * The main() method in class McDonald selects ten animals at random,
 * and generates the lyrics of a random "Old McDonald" song.
 *
 * @author Sanjana Prasad
 */

 abstract class Animal {
	public abstract String sound();
	public abstract String toString();

	public void WriteVerse() {
        System.out.println("");
		System.out.println("Old McDonald had a farm, EIEIO,");
		System.out.println("");
        System.out.println("And on his farm he had a " + this.toString());
        System.out.println("");
        System.out.println(", EIEIO,");


		String s = this.sound();
        System.out.println("");
		System.out.println("With a " + s + ", " + s + " here, ");
        System.out.println("");
		System.out.println("a " + s + ", " + s + " there,");
        System.out.println("");
		System.out.println("Here a " + s + ", there a " + s + ", everywhere a " + s + ", " + s + ",");
        System.out.println("");
        System.out.println("Old McDonald had a farm, EIEIO.");
        System.out.println("");

	}
}


// STUDENTS: make 5 classes for 5 different types of animals
// All derived from class Animal.

class Cow extends Animal {
    public String toString() {
        return "cow";
    }
    public String sound() {
        return "moo";
    }
}

class Snake extends Animal {
    public String toString() {
        return "snake";
    }
    public String sound() {
        return "hiss";
    }
}

class Sloth extends Animal {
    public String toString() {
        return "sloth";
    }
    public String sound() {
        return "zzz";
    }
}

class Tiger extends Animal {
    public String toString() {
        return "tiger";
    }
    public String sound() {
        return "roar";
    }
}

class Goose extends Animal {
    public String toString() {
        return "goose";
    }
    public String sound() {
        return "honk";
    }
}

public class McDonald {	

	public static void main(String[] args) {
		//Animal[] myAnimals = new Animal[5]; // a list of Animals.
		// STUDENTS: put your animals into the array.
        Animal[] myAnimals = {new Cow(), new Snake(), new Sloth(), new Tiger(), new Goose()}; // a list of Animals.
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomize = random.nextInt(5);
            Animal animal = myAnimals[randomize];
            animal.WriteVerse();
        }
        System.out.println("((...))");
        System.out.println("( O O )");
        System.out.println (" (`_`)" +  "  moo");

	
		// STUDENTS: add code to write 10 verses of the song,
		// picking at RANDOM which animal in the array to use.
	}

} // end class McDonald
