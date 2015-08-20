public class Test
{
    public static long add(long x, long y) {
        return x + y;
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double add(String x, String y) {
        return Double.parseDouble(x) + Double.parseDouble(y);
    }

    public static long fib(long n) {
        return n > 0 ? fib(n - 1) + fib(n - 2) : 1;
    }

    public static double fib(double n) {
        return n > 0 ? fib(n - 1) + fib(n - 2) : 1;
    }

    public static double fib(String n2){
        double n = Double.parseDouble(n2);
        return n > 0 ? fib(n - 1) + fib(n - 2) : 1;
    }
}
