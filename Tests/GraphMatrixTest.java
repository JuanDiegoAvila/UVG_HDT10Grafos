import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixTest {

    @org.junit.jupiter.api.Test
    void addEdge() {
        ArrayList<String[]> datos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        datos.add(new String[]{"Mixco","Antigua",30+""});
        datos.add(new String[]{"Antigua","Escuintla",25+""});
        GraphMatrix grafo = new GraphMatrix(datos);

        int  s = grafo.getIndex("Escuintla");
        int ll = grafo.getIndex("Mixco");
        int tiempo = 40;

        grafo.addEdge(s,ll,tiempo);
        assertEquals(grafo.getEdge(s,ll),40);

    }

    @org.junit.jupiter.api.Test
    void removeEdge() {
        ArrayList<String[]> datos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        datos.add(new String[]{"Mixco","Antigua",30+""});
        datos.add(new String[]{"Antigua","Escuintla",25+""});
        GraphMatrix grafo = new GraphMatrix(datos);
        grafo.removeEdge(0,1);
        assertEquals(grafo.getEdge(0,1),8888);
    }

    @org.junit.jupiter.api.Test
    void floydS() {
        ArrayList<String[]> datos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        datos.add(new String[]{"Mixco","Antigua",30+""});
        datos.add(new String[]{"Antigua","Escuintla",25+""});
        GraphMatrix grafo = new GraphMatrix(datos);
        grafo.floydS();
        assertEquals(grafo.getEdge(0,2),55);
    }
}