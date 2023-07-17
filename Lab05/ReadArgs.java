class ReadArgs{
    public static void main(String[] args) {

        int x=args.length;

        System.out.println("Program called with " + x + " arguments:");

        for (int i = 0; i < args.length; i++) {

            System.out.println(args[i]);
        }

    }
}