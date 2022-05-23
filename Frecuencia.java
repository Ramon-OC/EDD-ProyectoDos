public class Frecuencia implements Comparable<Frecuencia>{
    int edad, frecuencia;
    Frecuencia(int edad, int frecuencia){
        this.edad = edad;
        this.frecuencia = frecuencia;
    }

    public int getEdad(){
        return edad;
    }

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