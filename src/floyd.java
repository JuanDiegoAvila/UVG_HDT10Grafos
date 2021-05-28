import java.util.ArrayList;

public class floyd {
    Integer[][] P;
    ArrayList<Integer> visitados;
    public Integer[][] runFloyd(Integer[][] adyacencia)
    {
        P = new Integer[adyacencia.length][adyacencia.length];
        for(int x = 0;x<P.length;x++){
            for(int y = 0;y<P.length;y++){
                P[x][y] = 0;
            }
        }

        for(int k = 0;k<adyacencia.length;k++){
            for(int i = 0;i<adyacencia.length;i++){
                for(int j = 0;j<adyacencia.length;j++){
                    int cambio = adyacencia[i][j];
                    int a = adyacencia[i][k];
                    int b = adyacencia[k][j];

                    if(cambio>a+b){
                        adyacencia[i][j] = (a+b);
                        P[i][j] = k;
                    }

                }
            }
        }
        return adyacencia;
    }
    public void clear(){
        visitados = new ArrayList<>();
    }

    public ArrayList<Integer> path(int q,int r){
        if(P[q][r]!=0){
            path(q,P[q][r]);
            visitados.add(P[q][r]);
            path(P[q][r],r);
        }
        return visitados;
    }





}
