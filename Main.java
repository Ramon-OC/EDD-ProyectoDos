import java.util.*;
/**
* Clase principal del programa, se ejecuta el menú de registro.
* @author // Inserta tu nombre completo y número de cuenta
* @author Ortiz Castañeda José Ramón - 318357115
* @version 1.0 Mayo 2022
* @since Estructuras de Datos 2022-1.
*/
public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion=0;
        boolean salir = true;
        /** Se almacenan los alumnos con un número de cuenta y su edad */
        HashMap<Integer, Integer> alumnos = new HashMap<Integer, Integer>();;
        Frecuencia[] auxUno = new Frecuencia[7];
        Random rand = new Random();

        Arbol a = new Arbol();


        while(salir){
            System.out.println("Escribe una opcion\n"
                            +"  1. Resgistrar alumno\n"
                            +"  2. Ver grafico de edades\n"
                            +"  3. Ver grafico de edades ordenado\n"
                            +"  4. Ver arbol de inserciones\n"
                            +"  5. Salir");
            opcion = entrada.nextInt();
            if(opcion==1) {
                // Registro de alumno desde terminal
                /*
                Scanner sc = new Scanner(System.in);
                System.out.print("Escriba un numero de cuenta: ");
                int numCuenta = sc.nextInt();
                System.out.print("Escriba la edad: ");
                int edad = sc.nextInt();
                alumnos.put(numCuenta, edad);*/

                /*
                Scanner sc = new Scanner(System.in);
                System.out.print("Escriba un numero de cuenta: ");
                int numCuenta = sc.nextInt();
                System.out.print("Escriba la edad: ");
                int edad = sc.nextInt();
                alumnos.put(numCuenta, edad);*/

                for(int i=0; i<=3; i++){
                    Integer numCuenta;
                    do{
                        numCuenta = rand.nextInt(300000000, 500000000);
                    }while(alumnos.containsKey(numCuenta));
                    int edad = rand.nextInt(18, 25);
                    alumnos.put(numCuenta, edad);
                    a.insertarNodo(numCuenta);
                }
                

                /*
                alumnos.put(1, 18);
                alumnos.put(2, 18);
                alumnos.put(3, 19);
                alumnos.put(4, 20);
                alumnos.put(5, 20);
                alumnos.put(6, 20);
                alumnos.put(7, 21);
                alumnos.put(8, 22);
                alumnos.put(9, 22);
                alumnos.put(10, 23);
                alumnos.put(11, 23);
                alumnos.put(12, 24);
                alumnos.put(13, 24);
                alumnos.put(14, 24);*/

            }else if(opcion==2){ // Ver grafico de edades
                int index = 0;
                for(int i=18; i<=24; i++){
                    int occurrences = Collections.frequency(alumnos.values(), i);
                    auxUno[index] = new Frecuencia(i,occurrences);
                    index++;
                }
                HistogramPanel.createAndShowGUI(auxUno, "Grafico de Edades");
            }else if(opcion==3){ // Ver grafico de edades ordenado
                int index = 0;
                for(int i=18; i<=24; i++){
                    int occurrences = Collections.frequency(alumnos.values(), i);
                    auxUno[index] = new Frecuencia(i,occurrences);
                    index++;
                }
                Arrays.sort(auxUno); 
                HistogramPanel.createAndShowGUI(auxUno, "Grafico de Edades Ordenadas");
            }else if(opcion==4){
                System.out.println(a.toString());
            }else if(opcion==5){
                salir = false;
            }
        }
    }
}

