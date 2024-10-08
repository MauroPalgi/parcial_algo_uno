package estructuras;

public class ABParcial extends AB<Integer> {

    public ABParcial(NodoAB<Integer> raiz) {
        super(raiz);
    }

    /**
     * Práctico 1 - Ejercicio 2 - Parte D
     * Retorna true si y solo si todos los elementos del AB son pares
     */
    public boolean todosPares() {
        return todosPares(raiz);
    }

    private boolean todosPares(NodoAB<Integer> nodo) {
        if (nodo == null)
            return true;
        return (nodo.getDato() % 2 == 0) && todosPares(nodo.getIzq()) && todosPares(nodo.getDer());
    }

    public int cantidadEnRango(int inicio, int fin) {
        return cantidadEnRango(raiz, inicio, fin);
    }

    private int cantidadEnRango(NodoAB<Integer> nodo, int inicio, int fin) {
        if (nodo == null)
            return 0;
        if (nodo.getDato() > inicio && nodo.getDato() <= fin) {
            return +1 + cantidadEnRango(nodo.getDer(), inicio, fin) + cantidadEnRango(nodo.getIzq(), inicio, fin);
        }
        return cantidadEnRango(nodo.getDer(), inicio, fin) + cantidadEnRango(nodo.getIzq(), inicio, fin);
    }

    public void imprimirHojas(int nivel) {
        imprimirHojas(raiz, 0, nivel);
    }

    private void imprimirHojas(NodoAB<Integer> nodo, int indice, int nivel) {
        if (nodo == null) {
            return;
        }
        boolean esNivel = indice == nivel;
        boolean esHoja = nodo.getDer() == null && nodo.getIzq() == null;
        if (esNivel && esHoja) {
            System.out.println("Hoja: " + nodo.getDato() + ", Nivel: " + indice);
        }
        if (esNivel)
            return;
        indice += 1;
        imprimirHojas(nodo.getDer(), indice, nivel);
        imprimirHojas(nodo.getIzq(), indice, nivel);

    }

    public int cantidadDeMultiplos(int n) {
        //implementar
        return cantidadDeMultiplos(raiz, n);
    }

    private int cantidadDeMultiplos(NodoAB<Integer> nodo, int n) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getDato() % n == 0) {
            return 1 + cantidadDeMultiplos(nodo.getDer(), n) + cantidadDeMultiplos(nodo.getIzq(), n);
        } else {
            return cantidadDeMultiplos(nodo.getDer(), n) + cantidadDeMultiplos(nodo.getIzq(), n);
        }

    }

    public void imprimirElementosMayoresDelNivel(int nivel, int k) {
        imprimirElementosMayoresDelNivel(raiz, 0, nivel, k);
    }

    private void imprimirElementosMayoresDelNivel(NodoAB<Integer> nodo, int indice, int nivel, int k) {
        if (nodo == null) {
            return;
        }
        if (indice == nivel && nodo.getDato().compareTo(k) >= 0){
            System.out.println("Nivel :" + nivel);
            System.out.println(nodo.getDato());
        }else{
            if(indice == nivel){
                return;
            }else{
                indice += 1;
                imprimirElementosMayoresDelNivel(nodo.getDer(), indice, nivel,k);
                imprimirElementosMayoresDelNivel(nodo.getIzq(), indice, nivel,k);
            }
        }
    }
}
