package principal;

import java.util.concurrent.Semaphore;
import recursocompartido.RecursoCompartido;
import threads.T1;
import threads.T2;
import threads.T3;
import threads.T4;

public class Main {
    public static void main(String[] arg) {

        // TODO Crear el recurso compartido y los semáforos necesarios para realizar
        // el ejercicio
        Semaphore t1Terminado, t2Terminado, t3Terminado;

        RecursoCompartido rc = new RecursoCompartido(10);
        t1Terminado = new Semaphore(0, true);
        t2Terminado = new Semaphore(0, true);
        t3Terminado = new Semaphore(0, true);

        // TODO Crear los threads e iniciar su ejecución
        Thread t1 = new T1(t1Terminado, 10, rc);
        Thread t2 = new T2(t1Terminado, t2Terminado, rc);
        Thread t3 = new T3(t2Terminado, t3Terminado, rc);
        Thread t4 = new T4(t3Terminado, rc);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
