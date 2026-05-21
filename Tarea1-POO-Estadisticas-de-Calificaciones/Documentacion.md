Descripcion del programa
Consiste en ingresar ocho notas y el programa calcula
1. Promedio
2. Calificacion maxima
3. Calificacion minima
4. Porcentaje de las calificaciones pasadas
5. Calificaciones aprobadas
6. calificaciones reprobadas
Mediante diversos metodos.
    Metodo 1: Consiste en leer los datos ingresados por el usuario y validarlos que sean correctos

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

    Metodo 2: Este calcula el promedio mediante el for que va avanzando de 1 en 1 el arreglo sumandolos cada uno para despues dividirlo entre el tamano del mismo retornandolo

    static double calcularPromedio (int[] calificaciones){ //Con este se calcula el promedio
        int suma = 0;
        for(int i=0; i < calificaciones.length; i++){ 
            suma += calificaciones[i];
        }
        return (double) suma / calificaciones.length;
    }

    Metodo 3: Encuentra la calificacion maxima para retornarla

    static int encontrarMaximo(int[] calificaciones){ //se encuentra lacalificacion maxima
        int maximo = calificaciones[0];
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] > maximo){
                maximo = calificaciones[i];
            }
        }
        return maximo;
    }

    Metodo 4: Ecuentra la calificacion minima para retornarla

    static int encontrarMinimo(int[] calificaciones){ //se encuentra lacalificacion minima 
        int minimo = calificaciones[0];
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] < minimo){
                minimo = calificaciones[i];
            }
        }
        return minimo;
    }

    Metodo 5: verifica cada una de las calificaciones para encontrar cual es mayor o igualde 70 para incrementar aprobados y retornarlo

    static int contarAprobados(int [] calificaciones){ //cuenta cuantos aprobaron
        int aprobados = 0;
        for(int i=0; i < calificaciones.length; i++){
            if(calificaciones[i] >= 70){
                aprobados++;
            }
        }
        return aprobados;
    }

    Metodo 6: Llama los demas  metodos (exepto Metodo 1: leerCalificaciones), para mostrar la interfaz al usuario

    static void mostrarReportes(int[] calificaciones){ //este muestra la interfaz
        double promedio = calcularPromedio(calificaciones);
        int maximo = encontrarMaximo(calificaciones);
        int minimo = encontrarMinimo(calificaciones);
        int aprobados = contarAprobados(calificaciones);
        //int reprobados = contarReprobados(calificaciones);
        double porcentajeAprobados = ((double) aprobados / 8) * 100;

        System.out.println("Reporte\n Estadisticos");
        System.out.printf("El promedio de las calificaciones es: %.2f\n", promedio);
        System.out.println("La calificacion minima es: "+ minimo);
        System.out.println("La calificacion maxima es: "+ maximo);
        System.out.println("Analisis de resultados");
        System.out.println("La cantidad de aprobados es: "+ aprobados);
        System.out.println("La cantidad de reprobados es: "+ (8 - aprobados));
        System.out.printf("El porcentaje de aprobados es: %.1f\n", porcentajeAprobados);

    }