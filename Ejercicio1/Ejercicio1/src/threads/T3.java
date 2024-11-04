package threads;

// TODO Thread que corresponde a T3 (en el gráfico de la pregunta 1 del examen).

import java.util.concurrent.Semaphore;
import recursocompartido.RecursoCompartido;

public class T3 extends Thread {

    // TODO Declarar las variables necesarias y asignar sus valores a través de un
    // constructor.
    private Semaphore t2Terminado, t3Terminado;
    RecursoCompartido rc;

    public T3(Semaphore t2Terminado, Semaphore t3Terminado, RecursoCompartido rc) {
        this.t2Terminado = t2Terminado;
        this.t3Terminado = t3Terminado;
        this.rc = rc;
    }

    // TODO En el método adecuado (teniendo en cuenta que esta clase es un Thread)
    // calcule el punto medio entre cada par de posiciones de los arrays V2 y V3 del
    // recurso compartido, llamando al método adecuado de este recurso, en el orden
    // establecido en el gráfico del ejercicio 1 del examen.
    // Luego presentar en pantalla el array con los valores calculados de los puntos
    // usando el método presentarArray del recurso compartido.
    @Override
    public void run() {
        try {
            // Decir que T2 ha terminado. No hay que especificar que T1 ha terminado porque
            // para que T2 termine, T1 ha debido de terminar
            t2Terminado.acquire();

            // Calcular el punto medio
            rc.calcularPtoMedio();

            // Mostrar por pantalla
            System.out.println("El array V4: ");
            rc.presentarArray(rc.getV4());

            // T3 ha terminado
            t3Terminado.release(1);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
