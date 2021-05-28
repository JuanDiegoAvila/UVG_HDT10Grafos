import java.util.*;

public class GraphMatrix
{
    int size = 0;
    public Integer[][] matriz;
    public HashMap<String,Integer> posiciones = new HashMap<String,Integer>(); //almacena el nombre de la ciudad, y al vertice al que pertenece.
    ArrayList<String> ciudades;

    public GraphMatrix(ArrayList<String[]> datos){
        ciudades = new ArrayList<>();
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

    public ArrayList<String> c(){
        return ciudades;
    }

    public void addEdge(int s, int ll, int tiempo){
        matriz[s][ll] = tiempo;
    }

    public int getEdge(int s, int ll){
        int valor = matriz[s][ll];
        return valor;
    }

    public void removeEdge(int s, int ll){
        matriz[s][ll] = 8888;
    }
    public void floydS(){
        floyd Floyd = new floyd();
        matriz = Floyd.runFloyd(matriz);
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
        floydS();
        ArrayList<Integer> filas = new ArrayList<>();
        HashMap<Integer,Integer> maximos = new HashMap<Integer,Integer>();
        for(int x = 0; x<size;x++){
            filas.clear();
            for (int y = 0; y<size;y++){
                filas.add(matriz[x][y]);
            }
            maximos.put(x,Collections.max(filas));
        }
        int pos = Collections.min(maximos.entrySet(), Map.Entry.comparingByValue()).getKey();
        int centro = Collections.min(maximos.entrySet(), Map.Entry.comparingByValue()).getValue();
        String departamento = "";

        for(int x = 0; x<size;x++){
            for (int y = 0; y<size;y++){
                if(matriz[pos][y]==centro){
                    departamento = getDepartamento(pos);
                }
            }
        }

        System.out.println("El centro es "+departamento);

    }

    public void copiar(GraphMatrix original){
        int s = original.size;
        for(int x = 0; x<s;x++){
            for(int y = 0; y<s;y++){
                this.matriz[x][y] = original.matriz[x][y];
            }
        }
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
