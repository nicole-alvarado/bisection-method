import java.util.function.DoubleFunction;

public class Main {
    /**
     * Implementación del método de bisección para encontrar raíces de funciones.
     * 
     * @param f Función a evaluar
     * @param a Extremo a del intervalo
     * @param b Extremo b del intervalo
     * @param TOL Tolerancia para el criterio de parada
     * @param N Número máximo de iteraciones
     * @return La solución aproximada o null si el método fracasa
     */
    public static Double biseccion(DoubleFunction<Double> f, double a, double b, double TOL, int N) {
        // Paso 1
        int i = 1;
        double FA = f.apply(a);
        
        // Verificar que f(a) y f(b) tengan signos opuestos
        if (FA * f.apply(b) >= 0) {
            System.out.println("El método de bisección no puede garantizar convergencia para este intervalo.");
            System.out.println("Los valores f(a) y f(b) deben tener signos opuestos.");
            return null;
        }
        
        double p, FP;
        
        
        // Paso 2
        while (i <= N) {
            // Paso 3: Calcular el punto medio pi.
            p = a + (b - a) / 2;
            FP = f.apply(p);
            
            // Imprimir información de la iteración
            System.out.printf("Iteración %d: a = %.10f, b = %.10f, p = %.10f, f(p) = %.10f\n", 
                               i, a, b, p, FP);
            
            // Paso 4: Verificar criterio de parada
            if (FP == 0 || (b - a) / 2 < TOL) {
                System.out.println("Procedimiento terminado satisfactoriamente.");
                return p;
            }
            
            // Paso 5: Incrementar contador
            i = i + 1;
            
            // Paso 6: Actualizar intervalo [a,b]
            if (FA * FP > 0) {
                // Si f(a) y f(p) tienen el mismo signo, mover a
                a = p;
                FA = FP;
            } else {
                // Si tienen signos opuestos, mover b
                b = p;
            }
        }
        
        // Paso 7: El método fracasó después de No iteraciones
        System.out.println("El método fracasó después de " + N + " iteraciones.");
        return null;
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso: encontrar la raíz de f(x) = x^3 - x - 2
        //DoubleFunction<Double> f = x -> Math.pow(x, 3) - x - 2;

        //DoubleFunction<Double> f = x -> Math.pow(x, 3) + 4*Math.pow(x, 2) - 10;
        DoubleFunction<Double> f = x -> Math.pow(x, 3) - 7 * Math.pow(x, 2) + 14 * x - 6;


        double a = 2.7; // Extremo a
        double b = 3.2; // Extremo b
        double TOL = 0.01; // Tolerancia
        int N = 6; // Número máximo de iteraciones

        System.out.println("\nBuscando raíz en el intervalo [" + a + ", " + b + "]");
        Double resultado = biseccion(f, a, b, TOL, N);

        if (resultado != null) {
            System.out.println("La raíz aproximada es: " + resultado);
            System.out.println("f(" + resultado + ") = " + f.apply(resultado));
        }
    }
}