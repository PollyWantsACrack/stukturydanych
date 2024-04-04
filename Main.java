import java.util.HashMap;
import java.util.Map;

class Graph {
    private Map<Integer, Map<Integer, Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int u, int v, int weight) {
        // Dodajemy krawędź między wierzchołkami u i v z wagą
        graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, weight);
        graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, weight); // Graf nieskierowany - dodajemy krawędź w obu kierunkach
    }

    public Map<Integer, Integer> getNeighbors(int u) {
        // Zwracamy sąsiadów wierzchołka u wraz z wagami
        return graph.getOrDefault(u, new HashMap<>());
    }

    public Integer getWeight(int u, int v) {
        // Zwracamy wagę krawędzi między wierzchołkami u i v
        if (graph.containsKey(u) && graph.get(u).containsKey(v)) {
            return graph.get(u).get(v);
        }
        return null;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2, 5);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 4, 7);
        g.addEdge(1, 4, 2);

        // Sprawdzamy sąsiadów wierzchołka 1 wraz z wagami
        System.out.println("Sąsiedzi wierzchołka 1:");
        System.out.println(g.getNeighbors(1));

        // Sprawdzamy wagę krawędzi między wierzchołkami 1 i 4
        System.out.println("Waga krawędzi między wierzchołkami 1 i 4:");
        System.out.println(g.getWeight(1, 4));
    }
}
