package estructuras;


public class ABB<T extends Comparable<T>> {

    protected NodoABB<T> raiz;

    public ABB() {
    }

    public ABB(NodoABB<T> raiz) {
        this.raiz = raiz;
    }

    public NodoABB<T> getRaiz() {
        return raiz;
    }

    /**
     * Práctico 1 - Ejercicio 5 - Parte A
     * Inserta el dato pasado como parámetro en el árbol manteniéndolo ordenado.
     */
    public void insertar(T dato) {
        if (raiz == null)
            raiz = new NodoABB<>(dato);
        else
            insertar(raiz, dato);
    }

    private void insertar(NodoABB<T> nodo, T dato) {
        if (nodo.getDato().compareTo(dato) > 0) {
            if (nodo.getIzq() == null)
                nodo.setIzq(new NodoABB<>(dato));
            else
                insertar(nodo.getIzq(), dato);
        } else if (nodo.getDato().compareTo(dato) < 0) {
            if (nodo.getDer() == null)
                nodo.setDer(new NodoABB<>(dato));
            else
                insertar(nodo.getDer(), dato);
        }
    }

    /**
     * Práctico 1 - Ejercicio 5 - Parte B
     * Retorna true sii el dato pasado como parámetro pertenece al ABB.
     */
    public boolean pertenece(T dato) {
        return pertenece(raiz, dato);
    }

    private boolean pertenece(NodoABB<T> nodo, T dato) {
        if (nodo != null) {
            if (nodo.getDato().equals(dato)) {
                return true;
            } else if (nodo.getDato().compareTo(dato) > 0) {
                return pertenece(nodo.getIzq(), dato);
            } else if (nodo.getDato().compareTo(dato) < 0) {
                return pertenece(nodo.getDer(), dato);
            }
        }
        return false;
    }


    public T buscar(T dato) {
        return buscar(raiz, dato);
    }

    private T buscar(NodoABB<T> nodo, T dato) {
        if (nodo != null) {
            if (nodo.getDato().equals(dato)) {
                return nodo.getDato();
            } else if (nodo.getDato().compareTo(dato) > 0) {
                return buscar(nodo.getIzq(), dato);
            } else if (nodo.getDato().compareTo(dato) < 0) {
                return buscar(nodo.getDer(), dato);
            }
        }
        return null;
    }

    /**
     * Práctico 1 - Ejercicio 5 - Parte C
     * Lista en pantalla los elementos del ABB ordenados de menor a mayor.
     */
    public void listarAscendente() {
        listarAscendente(raiz);
    }

    private void listarAscendente(NodoABB<T> nodo) {
        if (nodo != null) {
            listarAscendente(nodo.getIzq());
            System.out.println(" " + nodo.getDato() + " ");
            listarAscendente(nodo.getDer());
        }
    }

    /**
     * Práctico 1 - Ejercicio 5 - Parte D
     * Lista en pantalla los elementos del ABB ordenados de mayor a menor.
     */
    public void listarDescendente() {
        listarDescendente(raiz);
    }

    private void listarDescendente(NodoABB<T> nodo) {
        if (nodo != null) {
            listarDescendente(nodo.getDer());
            System.out.println(" " + nodo.getDato() + " ");
            listarDescendente(nodo.getIzq());
        }
    }

    public String listarDescendenteString() {
        return listarDescendenteString(raiz);
    }

    private String listarDescendenteString(NodoABB<T> nodo) {
        if (nodo != null) {
            return listarDescendenteString(nodo.getDer()) + "|" + nodo.getDato() + "|" + listarDescendenteString(nodo.getIzq());
        }
        return "";
    }

    public int cantElementos() {
        return cantElementos(this.raiz);
    }

    private int cantElementos(NodoABB<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + cantElementos(nodo.getDer()) + cantElementos(nodo.getIzq());
    }

    public void mostrarArbol() {
        mostrarArbol(raiz, 0);
    }

    private void mostrarArbol(NodoABB<T> nodo, int nivel) {
        if (nodo == null)
            return;
        System.out.println(nodo.getDato());
        nivel += 1;
        if (nodo.getDer() != null) {
            System.out.println("\\" + " ".repeat(nivel));
            mostrarArbol(nodo.getDer(), nivel);
        }
        if (nodo.getDer() != null) {
            System.out.println("/");
            mostrarArbol(nodo.getIzq(), nivel);
        }

    }

    public void eliminarNodo(T dato) {
        eliminarNodo(raiz, dato);
    }

    private NodoABB<T> eliminarNodo(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        // Buscar el nodo a eliminar en el subárbol izquierdo o derecho
        if (nodo.getDato().compareTo(dato) > 0) {
            // Si el dato a eliminar es menor, buscar en el subárbol izquierdo
            nodo.setIzq(eliminarNodo(nodo.getIzq(), dato));
        } else if (nodo.getDato().compareTo(dato) < 0) {
            // Si el dato a eliminar es mayor, buscar en el subárbol derecho
            nodo.setDer(eliminarNodo(nodo.getDer(), dato));
        } else {
            // Si encontramos el nodo a eliminar
            // Caso 1: Nodo con un solo hijo o sin hijos
            if (nodo.getIzq() == null) {
                return nodo.getDer();
            } else if (nodo.getDer() == null) {
                return nodo.getIzq();
            }

            // Caso 2: Nodo con dos hijos
            // Buscar el sucesor inorden (mínimo del subárbol derecho)
            NodoABB<T> current = nodo.getDer();
            while (current.getIzq() != null) {
                current = current.getIzq();
            }

            // Reemplazar el valor del nodo con el sucesor
            nodo.setDato(current.getDato());

            // Eliminar el sucesor inorden
            nodo.setDer(eliminarNodo(nodo.getDer(), current.getDato()));
        }

        return nodo;
    }



}
