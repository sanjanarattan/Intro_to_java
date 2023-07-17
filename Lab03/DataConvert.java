class DataConvert{
    //this code determines the limit of float and double variable types
    public static void main(String[] args) {
        float var1=2.5f;
        int var2=(int) var1;
        System.out.println("2.5 cast to int gives " +var2);

        float var3=-4.5f;
        int var4=(int) var3;
        System.out.println("-4.5 cast to int gives "+var4);

        double var5=(1.0/3.0);
        float var6=(float)var5;
        System.out.println("double 1/3 = "+var5+ " but float 1/3 " +var6);

        int var7=256;
        byte var8=(byte) var7;
        System.out.println("byte value of 256 is "+var8);

        int var9=257;
        byte var10=(byte)var9;
        System.out.println("byte value of 257 is "+var10);

        int var11=258;
        byte var12=(byte)var11;
        System.out.println("byte value of 258 is "+var12);

        int var13=511;
        byte var14=(byte) var13;
        System.out.print("byte value of 511 is "+var14);



    }
    
}
