public class App {
    public static void main(String[] args) throws Exception {
        double fun_sin;
        double fun_exp;
        for(int i = 0; i < 15; ++i) {
            double  x = Math.PI/15*(1+i);
            fun_sin = Math.sin(x);
            fun_exp= Math.exp(x) / x * Math.log10(x);
            System.out.printf("%10.5f  |  %15.7e  |  %15.7e%n", x, fun_sin, fun_exp);
        }
    }
}
