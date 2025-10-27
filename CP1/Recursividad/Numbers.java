public class Numbers {
    private static double N = 25;

    public static double formula(double z) {
        return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    public static double recursive(double z) {
        if (z==0) {
            return 1.0;
        }
        if (N < 2) {
            return z;
        } else {
            return round(recursive(z, N) / recursive(z, N - 1));
        }
    }

    public static double iterative(double z) {
        if (z==0) {
            return 1.0;
        }
        if (N < 2) {
            return z;
        } else {
            return round(iterative(z, N) / iterative(z, N - 1));
        }
    }

    private static double recursive(double z, double n) {
        return n == 0 ? 0 : n == 1 ? 1 : z*recursive(z, n - 1) + recursive(z, n - 2);
    }

    private static double iterative(double z, double n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        double a=0;
        double b=1;
        double c=0;
        
        for(int i=2; i <= n; i++){
            c=z*b+a;
            a=b;
            b=c;
        }
        return b;
    }

    private static double round(double value) {
        double ROUND = 10000000000.0;
        return Math.round(value * ROUND) / ROUND;
    }


    public static void main(String[] args) {
        String[] metallics = {
                "Platinum", // [0]
                "Golden", // [1]
                "Silver", // [2]
                "Bronze", // [3]
                "Copper", // [4]
                "Nickel", // [5]
                "Aluminum", // [6]
                "Iron", // [7]
                "Tin", // [8]
                "Lead", // [9]
        };
        for (var z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}
// Se utilizó Gemini
