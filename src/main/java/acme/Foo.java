package acme;

public class Foo
{
    public static void main(String[] args)
    {
        System.err.println("Hello (Foo) World!");
        
        for (int i = 0; i < args.length; ++i) {
            System.err.printf(" * arg#%d: %s%n", i, args[i]);
        }
    }
}
