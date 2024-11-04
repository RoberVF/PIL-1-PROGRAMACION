package threads;

// TODO Thread que corresponde a T4 (en el gráfico de la pregunta 1 del examen).

import java.util.concurrent.Semaphore;
import recursocompartido.RecursoCompartido;

public class T4 extends Thread {

    // TODO Declarar las variables necesarias y asignar sus valores a través de un
    // constructor.
    private Semaphore t3Terminado;
    RecursoCompartido rc;

    public T4(Semaphore t3Terminado, RecursoCompartido rc) {
        this.t3Terminado = t3Terminado;
        this.rc = rc;
    }

    // TODO En el método adecuado (teniendo en cuenta que esta clase es un Thread),
    // obtener los arrays V3 y V4 del recurso compartido, haciendo uso de los
    // métodos
    // adecuados de este recurso. Calcular la cantidad de posiciones de V3 que son
    // mayores que la correspondiente posición de v4, y presentar en consola
    // la cantidad obtenida.
    @Override
    public void run() {
        try {
            // T3 ha terminado
            t3Terminado.acquire();

            int[] V3 = rc.getV3();
            int[] V4 = rc.getV4();
            int V3mayorV4 = 0;

            for (int i = 0; i < V3.length; i++) {
                if (V3[i] > V4[i]) {
                    V3mayorV4++;
                }
            }

            System.out.println("Numero de veces que V3 es mayor que V4: " + V3mayorV4);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
