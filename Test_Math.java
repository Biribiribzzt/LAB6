public class Test_Math {
    public static void main(String[] args) {
        
        int x = 5;

        Fibonacci fib = new Fibonacci();
        Factorial fac = new Factorial();
        int fibResult = fib.fib(x);
        int facResult = fac.fac(x);

        System.out.println("Fibonacci of " + x + " is: " + fibResult);
        System.out.println("Factorial of " + x + " is: " + facResult);

    }
}
