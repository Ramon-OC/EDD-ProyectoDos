/**
* Crea objetos frecuencia, se encargan de registrar la cantidad de alumnos registrados por edad
* @author Chávez Zamora Mauro Emiliano - 111001079
* @author Ortiz Castañeda José Ramón - 318357115
* @version 1.0 Mayo 2022
* @since Estructuras de Datos 2022-1.
*/
public class Frecuencia implements Comparable<Frecuencia>{
    private int edad, frecuencia;
    /** Método constructor, recibe la edad y su cantidad de alumnos registrados */
    Frecuencia(int edad, int frecuencia){
        this.edad = edad;
        this.frecuencia = frecuencia;
    }

    /**
     * Devuleve la edad de una frecuencia
     * @return entero con la edad (va de 18 a 24)
     */
    public int getEdad(){
        return edad;
    }

    /**
     * Devuelve la frecuencia de una edad
     * @return entero con la cantidad de alumnos registrados
     */
    public int getFricencia(){
        return frecuencia;
    }

    @Override
    public int compareTo(Frecuencia c) {
        if(this.getFricencia() > c.getFricencia()) {
            return 1;
        } else if (this.getFricencia() < c.getFricencia()) {
            return -1;
        } else {
            return 0;
        }
    }
}
