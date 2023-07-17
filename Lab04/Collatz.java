class Collatz {
	static int runSteps(int n) {
		int numberOfSteps = 0;//variable keeps track of number of loops

		while (n!=1){//condidtional where loop only occurs if 1 hasn't been reached yet
			if (n%2==0){//even number conditional followed by operations
				n/=2;
				numberOfSteps+=1;
			}
			else{//odd number conditional followed by operations
				n=(3*n+1);
				numberOfSteps+=1;
			}
		
				
		}//while
		
		return numberOfSteps;//returns number of loops
	}
	
	static public void main(String[] args) {
		int currentNumber = 1;
		while (currentNumber <= 200) {
			System.out.println(currentNumber + " " + runSteps(currentNumber));
			currentNumber++;
		}
	}
} // end class Collatz