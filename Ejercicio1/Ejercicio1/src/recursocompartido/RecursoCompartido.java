package recursocompartido;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class RecursoCompartido {
    private final int LIMITE;
    private int[] V1, V2, V3, V4;
    private Semaphore semaforo;

    public RecursoCompartido(int size) {
        // TODO Crear un semáforo al valor adecuado, iniciar la variable LIMITE al valor
        // pasado por parametro y crear los 4 arrays V1, V2, V3 y V4 de tamaño LIMITE

        // Semaforo con un solo permiso para la inclusion mutua
        this.semaforo = new Semaphore(1, true);
        this.LIMITE = size;

        // Arrays de size indicado
        V1 = new int[LIMITE];
        V2 = new int[LIMITE];
        V3 = new int[LIMITE];
        V4 = new int[LIMITE];
    }

    public void presentarArray(int[] array) {
        for (int i = 0; i < LIMITE; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    /**
     * TODO Método llamado generarArrays que inicia los arrays V1 y V2 de tamaño
     * LIMITE.Inicia V1 con valores positivos aleatorios entre 0 y 10, e inicia V2
     * con
     * valores negativos entre 0 y -10.Finalmente presenta V1 y V2 en pantalla
     * llamando
     * al método presentarArray de esta clase.El metodo no devuelve nada.
     */
    public void generarArrays() {
        Random random = new Random();
        for (int i = 0; i < LIMITE; i++) {
            V1[i] = random.nextInt(11);
            V2[i] = -random.nextInt(11);
        }
        System.out.println("Array V1: ");
        presentarArray(V1);

        System.out.println("Array V2: ");
        presentarArray(V2);
    }

    /**
     * TODO Método llamado sumarArrays que suma los valores de los arrays V1 y V2,
     * y los almacena en V3.Por ejemplo, si V1=(5,4,2,7) y V2=(-3,-6,-2,-2),
     * entonces V3=(2,-2,0,5).Esta tarea se debe hacer en exclusión mutua usando
     * el semáforo declarado en el constructor.El metodo no devuelve nada.
     * 
     * @throws Exception Si se produce cualquier error.
     */

    public void sumarArrays() throws Exception {
        semaforo.acquire();
        try {
            for (int i = 0; i < LIMITE; i++) {
                V3[i] = V1[i] + V2[i];
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            semaforo.release();
        }
    }

    /**
     * TODO Método llamado calcularPtoMedio que almacena en cada posición de V4
     * el punto medio de las correspondientes posiciones de V2 y V3 utilizando
     * la expresión (int)((V2+V3)/2.0).Por ejemplo, si V2=(-2,-3,-9,-8) y
     * V3=(4,-3,10,-6), entonces V4=(1,-3,0,-7).Esta tarea se debe hacer en
     * exclusión mutua usando el semáforo declarado en el constructor.El metodo
     * no devuelve nada.
     * 
     * @throws Exception Si se produce cualquier error.
     */
    public void calcularPtoMedio() throws Exception {
        semaforo.acquire();
        try {
            for (int i = 0; i < LIMITE; i++) {
                V4[i] = (V2[i] + V3[i]) / 2;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            semaforo.release();
        }
    }

    public int[] getV3() {
        return V3;
    }

    public int[] getV4() {
        return V4;
    }
}