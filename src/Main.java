import estructuras.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        NodoAB<Integer> uno = new NodoAB<>(1);
        NodoAB<Integer> dos = new NodoAB<>(2);
        NodoAB<Integer> tres = new NodoAB<>(3);
        NodoAB<Integer> cuatro = new NodoAB<>(4);
        NodoAB<Integer> cinco = new NodoAB<>(5);
        NodoAB<Integer> seis = new NodoAB<>(6);
        NodoAB<Integer> siete = new NodoAB<>(7);
        NodoAB<Integer> ocho = new NodoAB<>(8);
        NodoAB<Integer> nueve = new NodoAB<>(9);
        NodoAB<Integer> diez = new NodoAB<>(10);


        uno.setIzq(dos);
        uno.setDer(tres);

        dos.setIzq(cuatro);
        dos.setDer(cinco);

        tres.setIzq(seis);
        tres.setDer(siete);

        cuatro.setIzq(ocho);
        cuatro.setDer(nueve);

        // El nodo diez no tiene hijos
        cinco.setIzq(diez);

        // Ahora, tienes un árbol binario con la raíz 'uno' y los otros nodos distribuidos como hijos.
        System.out.println(uno.getDato());
        ABParcial arbol = new ABParcial(uno);
        Number cantidad =  arbol.cantidadEnRango(2,4);
        System.out.println("Cantidad: " + cantidad);
        arbol.imprimirHojas(2);
        System.out.println("Cantidad de Hojas: " + arbol.cantHojas());
        System.out.println("Altura: " + arbol.altura());

        // 15, 8, 21, 35, 47, 7, 6, 9
        // 67, 5, 1, 89, 3, 43, 56
        ABBParcial arbolBinario = new ABBParcial();
        arbolBinario.insertar(15);
        arbolBinario.insertar(8);
        arbolBinario.insertar(21);
        arbolBinario.insertar(35);
        arbolBinario.insertar(47);
        arbolBinario.insertar(7);
        arbolBinario.insertar(6);
        arbolBinario.insertar(9);

        arbolBinario.mostrarArbol();
        ListaDoble<Integer> listaInt =  arbolBinario.obtenerListaDecreciente();
        listaInt.mostrar();
        System.out.println("raiz " + arbolBinario.getRaiz().getDato());
    }
}