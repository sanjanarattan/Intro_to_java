class DoubleRing {
    private class Node {                    //declaring node / values (2"children")
        private final char m_val; 
        Node prev;
        Node next;

        Node(char c) { 
            m_val = c; 
            prev = null; 
            next = null; 
        }

        public char val() { 
            return m_val; 
        }
    }
    
    private Node m_current;                 // current node in the ring

    DoubleRing () { 
        m_current = null; 
    }

    char current() {
        if (m_current == null) {
            return (char) 0;                // return null 
        }
        return m_current.val();             // current node
    }

    void next() {
        if (m_current != null) {
            m_current = m_current.next;    // move to the next node
        }
    }
    
    void add(Node n) {
        // if the list is empty
        if (m_current == null) {
            n.prev = n; // new node=prev node
            n.next = n; // new node=next node
            m_current = n; // new node=current node
        } else {
            n.prev = m_current; 
            n.next = m_current.next; 
            m_current.next.prev = n; 
            m_current.next = n; 
    }}
    

    void add(char c) {
        add(new Node(c));
    }

    void remove() throws IndexOutOfBoundsException {
        if (m_current == null) {
            throw new IndexOutOfBoundsException("ERROR: empty"); // throw an exception if the ring is empty
        } else if (m_current.prev == m_current) {
            m_current = null;
        } else {
            m_current.prev.next = m_current.next;
            m_current.next.prev = m_current.prev;
            m_current = m_current.next;
        }
    }
    
    void PrintRing() {
        if (m_current == null) {
            System.out.println("Empty ring");
            return;
        }
    
        System.out.print(m_current.val() + " "); 
    
        Node node = m_current.next; //current
        while (node != m_current) { 
            System.out.print(node.val() + " "); 
            node = node.next; // move to the next node
        }
    }
    
    public class Double {
        public static void main(String[] args) {

    DoubleRing ring = new DoubleRing();

    for(char c = 'a'; c <= 'z'; c++) {
        ring.add(c); 
        ring.next();
    }
    
        ring.add('!');
        ring.remove(); // a
        
        ring.next(); // c
        ring.remove(); // c
        
        ring.next(); // d
        ring.remove(); // d
        
        ring.add('@'); 
        ring.next(); // f
        ring.next(); // g
        
        ring.add('#'); 
        ring.remove(); // g
        ring.next(); //i
        ring.add('$');
        ring.next(); // k
        ring.remove(); // k
        ring.next(); //l
        ring.next(); // m
        ring.next(); // n
        ring.next(); //  o
        ring.next(); // p
        ring.next(); // q
        ring.remove(); // q
        ring.next(); // s
        ring.next(); // t
        
        ring.PrintRing(); // print the remaining characters in the ring
}
}
}
        



//MY NOTES
/*n.prev and n.next are used to keep track of the 
previous and next nodes of n in the double-linked list. 
A double-linked list allows traversal in both directions,
Each node in a double-linked list has a reference to 
the previous node (prev) and the next node (next).When calling n.prev or n.next, 
we are accessing the prev and next fields of the Node instance n. */