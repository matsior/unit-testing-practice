package p7;

public class Fibonacci {

//    public static int fibonacci(int n) {
//        int t1 = 0;
//        int t2 = 1;
//
//        for (int i = 1; i <= n; i++) {
//            int sum = t1 + t2;
//            t1 = t2;
//            t2 = sum;
//        }
//        return t1;
//    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
