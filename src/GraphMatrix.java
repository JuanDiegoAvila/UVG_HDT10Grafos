import java.util.*;

public class GraphMatrix
{
    int size = 0;
    public Integer[][] matriz;
    public HashMap<String,Integer> posiciones = new HashMap<String,Integer>(); //almacena el nombre de la ciudad, y al vertice al que pertenece.

    public GraphMatrix(ArrayList<String[]> datos){
        ArrayList<String> ciudades = new ArrayList<>();
        for(String[] x: datos){
            //se agregan las ciudades.
            if(!ciudades.contains(x[0])){ ciudades.add(x[0]); }
            if(!ciudades.contains(x[1])){ ciudades.add(x[1]); }
        }
        size = ciudades.size();
        for(int i = 0; i<size;i++){ posiciones.put(ciudades.get(i),i); }

        matriz = new Integer[size][size]; //el tamaño de la matriz se define por la cantidad de ciudades.

        for(int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
                if(x == y){ matriz[x][y] = 0;
                }else{
                    matriz[x][y] = 8888;
                }

            }
        }

        for(String[] i : datos){
            int x = posiciones.get((i[0]));
            int y = posiciones.get(i[1]);
            matriz[x][y] = Integer.valueOf(i[2]); //se ingresan los pesos en las posiciones respectivas.
        }
    }

    public void addEdge(int s, int ll, int tiempo){
        matriz[s][ll] = tiempo;
    }

    public void removeEdge(){

    }

    public void floyd(int s, int ll){
        floyd Floyd = new floyd();
        matriz = Floyd.runFloyd(matriz);
        System.out.println("\nPaso por: ");
        Floyd.path(s,ll,this);
        if(matriz[s][ll]==8888){
            System.out.println("No existe relacion ! ");
        }else{
            System.out.println("Se tardo : \n\t->"+matriz[s][ll]);
        }

    }

    public String getDepartamento(int index){
        for(Map.Entry<String,Integer> entry :posiciones.entrySet() ){
            if(entry.getValue() == index){
                return entry.getKey();
            }
        }
        return "";
    }

    public void centro(){
        ArrayList<Integer> filas = new ArrayList<>();
        ArrayList<Integer> maximos = new ArrayList<>();
        for(int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
                if(matriz[x][y]!=8888){
                    filas.add(matriz[x][y]);
                }
            }
            maximos.add(Collections.max(filas));
        }
        System.out.println("El centro es "+Collections.max(maximos));

    }

    public int getIndex(String departamento){
        return posiciones.getOrDefault(departamento, -1);
    }


    public void print(){
        for(int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
                System.out.print("    "+matriz[x][y]+"    ");
            }
            System.out.println("\n");
        }
    }
}
