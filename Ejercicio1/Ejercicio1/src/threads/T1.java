package threads;

import java.util.concurrent.Semaphore;
import recursocompartido.RecursoCompartido;

// TODO Thread que corresponde a T1 (en el gráfico de la pregunta 1 del examen).
public class T1 extends Thread {

    // TODO Declarar las variables necesarias y asignar sus valores a través de un
    // constructor.
    private Semaphore t1Terminado;
    RecursoCompartido rc;
    private int longitud;

    public T1(Semaphore t1Terminado, int longitud, RecursoCompartido rc) {
        this.t1Terminado = t1Terminado;
        this.longitud = longitud;
        this.rc = rc;
    }

    // TODO En el método adecuado (teniendo en cuenta que esta clase es un Thread)
    // inicie los arrays V1 y V2 del recurso compartido con valores positivos y
    // negativos respectivamente, llamando al método adecuado de este recurso, en el
    // orden establecido en el gráfico del ejercicio 1 del examen.
    @Override
    public void run() {
        // Inicializar V1 y V2
        rc.generarArrays();

        // T1 termino su tarea
        t1Terminado.release(1);
    }

}
