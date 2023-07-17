class Limits{
    //java cannot represent large numbers- use this code to determine limits of data types
    public static void main(String[] args) {

        //utilize a while loop to determine min and max byte value
        byte byte_test_max=0;
        byte byte_test_min=0;
        while (byte_test_max>=0){
            byte_test_max+=1;
        }
        while (byte_test_min<=0){
            byte_test_min-=1;
        }
        System.out.println("Maximum byte value is " + byte_test_max);
        System.out.println("Minimum byte value is "+byte_test_min);

        //utilize a while loop to determine min and max short value
        short short_test_max=0;
        short short_test_min=0;
        while (short_test_max>=0){
            short_test_max+=1;
        }
        while (short_test_min<=0){
            short_test_min-=1;
        }
        System.out.println("Maximum short value is "+short_test_max);
        System.out.println("Minimum short value is "+short_test_min);

        //utilize a while loop to determine min and max int value
        int int_test_max=0;
        int int_test_min=0;
        while (int_test_max>=0){
            int_test_max+=1;
        }
        while (int_test_min<=0){
            int_test_min-=1;
        }
        System.out.println("Maximum int value is "+int_test_max);
        System.out.println("Minimum int value is "+int_test_min);

    }
}