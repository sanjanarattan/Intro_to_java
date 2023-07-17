class FloatLimits{
    //this code determines the limit of float and double variable types
    public static void main(String[] args) {

        //utilize a while loop to determine min float value;add if statement to compare and print value before 0
        float float_test=1.0f;
        float buffer1=1.0f;
        while (float_test>0){
            buffer1/=2;
            if (buffer1 != 0) {
                float_test/=2.0f;
            }
            else{
                float_test=float_test;
                break;
            }
        }
        System.out.println("Smallest positive float is " +float_test);

        //utilize a while loop to determine min double value; add if statement to compare and print value before 0
        double double_test=1.0;
        double buffer2=1.0;
        while (double_test>0){
            buffer2/=2;
            if (buffer2 != 0) {
                double_test/=2.0;
            }
            else{
                double_test=double_test;
                break;
            }
        }
        System.out.println("Smallest positive double is " +double_test);
    }
}