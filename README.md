# Método de Bisección

Implementación del algoritmo del método de bisección para encontrar raíces de funcioness. Este método divide repetidamente un intervalo en mitades y selecciona el subintervalo donde debe estar la raíz.

## Uso

```java
// Definir la función para la que deseas encontrar la raíz
DoubleFunction<Double> f = x -> Math.pow(x, 3) - x - 2;

// Definir parámetros
double a = 1.0; // Extremo a del intervalo
double b = 2.0; // Extremo a del intervalo
double TOL = 0.0001;    // Tolerancia de error
int N = 100;    // Número máximo de iteraciones

// En esta parte se llama al método de bisección
Double result = biseccion(f, a, b, TOL, N);

```

## Ejemplo de Salida

```
Iteración 1: a = 1.0000000000, b = 2.0000000000, p = 1.5000000000, f(p) = 0.8750000000
Iteración 2: a = 1.0000000000, b = 1.5000000000, p = 1.2500000000, f(p) = -0.0468750000
...
Procedimiento terminado satisfactoriamente.
La raíz aproximada es: 1.2599
f(1.2599) = 0.0001052
```