package threads;

// TODO Thread que corresponde a T2 (en el gráfico de la pregunta 1 del examen).

import java.util.concurrent.Semaphore;
import recursocompartido.RecursoCompartido;

public class T2 extends Thread {

    // TODO Declarar las variables necesarias y asignar sus valores a través de un
    // constructor.
    private Semaphore t1Terminado, t2Terminado;
    RecursoCompartido rc;

    public T2(Semaphore t1Terminado, Semaphore t2Terminado, RecursoCompartido rc) {
        this.t1Terminado = t1Terminado;
        this.t2Terminado = t2Terminado;
        this.rc = rc;
    }

    // TODO En el método adecuado (teniendo en cuenta que esta clase es un Thread)
    // sume los arrays V1 y V2 del recurso compartido y los almacena en V3, llamando
    // al método adecuado de este recurso, en el orden establecido en el gráfico del
    // ejercicio 1 del examen.
    // Luego presentar en pantalla, usando el método presentarArray del recurso
    // compartido, el array suma obtenido.
    @Override
    public void run() {
        try {
            // Esperar que T1 haya terminado
            t1Terminado.acquire();

            // Sumar los arrays
            rc.sumarArrays();

            // Mostrar V3
            System.out.println("El array V3: ");
            rc.presentarArray(rc.getV3());

            // T2 ha terminado
            t2Terminado.release(1);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
