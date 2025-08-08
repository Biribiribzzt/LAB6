public class Factorial {
    
    public int fac(int x){
        if (x < 0) {
            return -1; // Factorial is not defined for negative numbers
        } else if (x == 0 || x == 1) {
            return 1; // Base case: factorial of 0 and 1 is 1
        } else {
            return x * fac(x - 1); // Recursive case
        }
    }
}
