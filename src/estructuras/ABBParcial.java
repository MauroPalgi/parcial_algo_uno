package estructuras;

public class ABBParcial extends ABB<Integer> {


    public ABBParcial() {
    }

    /**
     * Práctico 1 - Ejercicio 2 - Parte D
     * Retorna true si y solo si todos los elementos del AB son pares
     */
    public ListaDoble<Integer> obtenerListaDecreciente() {
        ListaDoble<Integer> lista = new ListaDoble<>();
        cargarListaDecRec(raiz, lista);
        return lista;
    }

    private void cargarListaDecRec(NodoABB<Integer> nodo, ListaDoble<Integer> lista) {
        if (nodo == null) {
            return;
        }

        // Primero recorremos el subárbol derecho (valores mayores)
        cargarListaDecRec(nodo.getDer(), lista);

        // Luego agregamos el valor del nodo actual al final de la lista
        lista.agregarFinal(nodo.getDato());

        // Finalmente, recorremos el subárbol izquierdo (valores menores)
        cargarListaDecRec(nodo.getIzq(), lista);
    }


}
