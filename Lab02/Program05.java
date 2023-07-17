class Program05 {
	public static void main(String[] args) {
		int radius= 5 ;
		int height = 10 ;
		double baseArea = (double) Math.PI*(radius * radius);
		double coneVolume = (double) (1.0/3.0)*baseArea*height;
		System.out.println("The volume of our cone is " + coneVolume);
	}
}