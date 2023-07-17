public class TextTriangle {
    public static void main(String[]args){

        int start=97;
        int end=122;
        int i=start;
        
            for (i=start; i <= end; i++){
                
                for (int j = i; j <= end; j++) {
                    System.out.print((char)j);
                }
                System.out.println();
                i=i+1;
            }
        
        

                
    }//psvm

}//pctt
