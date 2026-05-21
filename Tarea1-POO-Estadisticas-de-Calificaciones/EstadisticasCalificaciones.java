import java.util.Scanner; //Importar Scanner para leer por consola

public class EstadisticasCalificaciones {
    public static void main(String[] args){

        Scanner leer = new Scanner(System.in); //declaramos Scanner

        int[] calificaciones = leerCalificaciones(leer); //Llamo el metodo para leer las notas

        mostrarReportes(calificaciones); //Llamo metodo para mostrar en la interfaz los datos

    }

    static int[] leerCalificaciones(Scanner leer) {
        int[] notas = new int[8]; //declaramos el arreglo donde se almacenara las notas
        System.out.println("Ingrese las 8 notas separadas por espacio:");
        while(true){ //Bucle para verificar que los datos sean verdaderos
            String linea = leer.nextLine(); // se lee lo que el usuario ingreso
            String[] partes = linea.split(" "); //Para separar los datos en espacio

            if(partes.length != notas.length){ //Verifica si son los 8 datos exactos ingresados por el usuario
                System.out.println("Deben de ser exactamente 8 calificaciones");
                continue;
            }

            boolean valido = true; //indca si todos los datos son validos

            for(int i=0; i < notas.length; i++){ //verifica si los datos ingresados son numeros de 0 a 100
                partes[i] = partes[i].trim();
                if(!partes[i].matches("-?\\d+")){ //da el mensaje de error si hay letras 
                    System.out.println("Todas las calificaciones deben ser numeros.");
                    valido = false; //indica si los datos son incorrectos
                    break;
                }
                notas[i] = Integer.parseInt(partes[i]); //convierte el texto a numero entero
                if(notas[i] < 0){ //da el mensaje de error si hay negativos
                    System.out.println("No se aceptan calificaciones negativas.");
                    valido = false; //indica si los datos son incorrectos
                    break;
                }
                if(notas[i] > 100){ //da el mensaje de error si es mayor de 100
                    System.out.println("No se aceptan calificaciones mayores de 100.");
                    valido = false; //indica si los datos son incorrectos
                    break;
                }
            }

            if(valido){ //si todo esta bien sale del bucle while
                break;
            }
            System.out.println("Vuelve a ingresar las calificaciones");
        }
        return notas;
    }

    static double calcularPromedio (int[] calificaciones){ //Con este se calcula el promedio
        int suma = 0;
        for(int i=0; i < calificaciones.length; i++){ 
            suma += calificaciones[i];
        }
        return (double) suma / calificaciones.length;
    }

    static int encontrarMaximo(int[] calificaciones){ //se encuentra lacalificacion maxima
        int maximo = calificaciones[0];
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] > maximo){
                maximo = calificaciones[i];
            }
        }
        return maximo;
    }

    static int encontrarMinimo(int[] calificaciones){ //se encuentra lacalificacion minima 
        int minimo = calificaciones[0];
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] < minimo){
                minimo = calificaciones[i];
            }
        }
        return minimo;
    }

    static int contarAprobados(int [] calificaciones){ //cuenta cuantos aprobaron
        int aprobados = 0;
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] >= 70){
                aprobados++;
            }
        }
        return aprobados;
    }

    static void mostrarReportes(int[] calificaciones){ //este llama las demas funciones para muestrar la interfaz
        double promedio = calcularPromedio(calificaciones); //Llama el metodo calcularPromedio
        int maximo = encontrarMaximo(calificaciones); //Llama metodo encontrarMaximo
        int minimo = encontrarMinimo(calificaciones); //Llama metodo encontrarMinimo
        int aprobados = contarAprobados(calificaciones); //Llama metodo contarAprobados
        double porcentajeAprobados = ((double) aprobados / 8) * 100; //creo una variable que va a llevar el
                        //prcentaje de aprobados que sehace dividiendo los aprobados entre las notas totales

        System.out.println("Reporte\n Estadisticos");
        System.out.printf("El promedio de las calificaciones es: %.2f\n", promedio);
        System.out.println("La calificacion minima es: "+ minimo);
        System.out.println("La calificacion maxima es: "+ maximo);
        System.out.println("Analisis de resultados");
        System.out.println("La cantidad de aprobados es: "+ aprobados);
        System.out.println("La cantidad de reprobados es: "+ (8 - aprobados));
        System.out.printf("El porcentaje de aprobados es: %.1f\n", porcentajeAprobados);

    }
}
