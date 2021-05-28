import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        ArrayList<String[]> datos = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("guategrafo.txt"));
            while (input.hasNextLine()) {
                String actual = input.nextLine();
                datos.add(actual.split(" "));
            }
        }catch (Exception ignored){ }

        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        System.out.println("\n Bienvenido a guategrafo !");
        while(!salir){
            System.out.println("\nSeleccione una de las siguientes opciones: ");
            System.out.println("\t[ 1 ] Calcular distancia entre departamentos.");
            System.out.println("\t[ 2 ] Agregar una relacion.");
            System.out.println("\t[ 3 ] Eliminar una relacion.");
            System.out.println("\t[ 4 ] Calcular centro del grafo.");
            System.out.println("\t[ 5 ] Salir.");
            GraphMatrix grafo = new GraphMatrix(datos);
            GraphMatrix original = grafo;

            int opcion = 0;
            while(true){
                try{
                    System.out.print("\t -> ");
                    opcion = scan.nextInt();
                    if(opcion<6 && opcion>0){
                        break;
                    }else{
                        System.out.println("\n Ingrese valores entre 1 y 5.");
                    }
                }catch (Exception e){
                    scan.nextLine();
                    System.out.println("\nIngrese valores enteros ! ! !");
                }
            }

            switch (opcion){
                case 1 -> {
                    grafo = original;
                    scan.nextLine();
                    System.out.print("\nIngrese la ciudad de salida->");
                    String salida = scan.nextLine();

                    System.out.print("\nIngrese la ciudad de llegada->");
                    String llegada = scan.nextLine();

                    int  s = grafo.getIndex(salida);
                    int ll = grafo.getIndex(llegada);

                    grafo.floyd(s, ll);
                }
                case 2 -> {
                    scan.nextLine();
                    System.out.print("\nIngrese la ciudad de salida->");
                    String salida = scan.nextLine();

                    System.out.print("\nIngrese la ciudad de llegada->");
                    String llegada = scan.nextLine();

                    int  s = grafo.getIndex(salida);
                    int ll = grafo.getIndex(llegada);

                    System.out.println("\nIngrese el tiempo que tarda en llegar->");
                    int tiempo = 0;
                    while(true){
                        try{
                            System.out.print("\t -> ");
                            opcion = scan.nextInt();
                            break;
                        }catch (Exception e){
                            scan.nextLine();
                            System.out.println("\nIngrese valores enteros ! ! !");
                        }
                    }

                    original.addEdge(s,ll,tiempo);

                }
                case 3 -> {

                }
                case 4 -> { original.centro();}
                case 5 -> {salir = true;}
            }
        }
    }
}
