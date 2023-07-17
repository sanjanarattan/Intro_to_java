class Cubes {
	public static void main(String[] args) {
        //3 variables
		int start=0;//this keeps track of number being cubed by adding 1 each loop
        int buffer=0;//this is the variable that the operation is actually performed on
        int cube_value=0;//this is the final value after buffer is cubed
        while (cube_value<2000){
            start+=1;
            buffer=start;
            cube_value=buffer*buffer*buffer;
            if (cube_value>=2000){//this breaks the while loop right before reaching 2000
                break;
            }
            else{
                System.out.println(cube_value);
            }
            
        }

		
		
	}
}