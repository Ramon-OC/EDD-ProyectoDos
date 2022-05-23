import java.util.Queue;
import java.util.LinkedList;

/**
* Clase que simula el comportamiento de un nodo de un arbol
* @author
* @author Ortiz Castañeda José Ramón - 318357115
* @version 1.0 Mayo 2022
* @since Estructuras de Datos 2022-2
*/
class NodoArbol{

    NodoArbol nodoIzq, nodoDer;
    int datos, nivel;

    /**
     * Método constructor de un nodo
     * @param datosNodo informacion que se alamcena en el nodo
     */
    public NodoArbol(int datosNodo) {
        datos = datosNodo;
        nodoIzq = nodoDer = null;
    }

    /**
     * Se le asigna una posicion en el árbol
     * @param nivel nivel dentro de la estructura
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtener el nivel de un nodo
     * @return entero con el nivel del nodo
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Inserta el valor comparando los datos del nodo izquierdo y derecho
     * @param valorInsertar valor que se agrega
     */
    public void insertar(int valorInsertar){
        if(valorInsertar < datos) {
            if(nodoIzq==null) {
                nodoIzq = new NodoArbol(valorInsertar);
            } else {
                nodoIzq.insertar(valorInsertar);
            }
        } else if(valorInsertar > datos) {
            if(nodoDer==null) {
                nodoDer = new NodoArbol(valorInsertar);
            } else {
                nodoDer.insertar(valorInsertar);
            }
        }
    }
}

/** Clase que simula el comportamiento de un árbol */
public class Arbol {

    NodoArbol raiz;
    /** Método constructor, inicializa la raiz en null */
    public Arbol(){
        raiz = null;
    }

    /**
     * Insertar un nodo en el árbol
     * @param valorInsertar valor que se agrega 
     */
    public void insertarNodo(int valorInsertar) {
        if(raiz==null) {
            raiz = new NodoArbol(valorInsertar);
        } else {
            raiz.insertar(valorInsertar);
        }
    }

    /** 
     * 
     * 
     * @return una cadena con la información de los niveles
    */
    public String toString(){
        int nivel = 0;
        Queue<NodoArbol> queue = new LinkedList<NodoArbol>();
        raiz.setNivel(nivel); // El nivel por defecto de la raiz será cero
        queue.add(raiz);

        String a = "";
        int nivelTemporal = 0;

        while (!queue.isEmpty()){
            NodoArbol tempNodo = queue.poll();
            int auxNivel = tempNodo.getNivel();
            
            if(nivelTemporal!=auxNivel){
                a+=" -> "; // poner fecha
                nivelTemporal=nivelTemporal+1;
            }

            // Agrgar los especios
            a+=tempNodo.datos+" ";

            if (tempNodo.nodoIzq != null) { // izquierdo
                tempNodo.nodoIzq.setNivel(auxNivel+1);
                queue.add(tempNodo.nodoIzq);
            }

            if (tempNodo.nodoDer != null) { // Derecho mientras el nodo no sea null
                tempNodo.nodoDer.setNivel(auxNivel+1);
                queue.add(tempNodo.nodoDer);
            }
        }
    return a;
    }

}