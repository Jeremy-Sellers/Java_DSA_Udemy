

public class main {
    public static void main(String[] args) {
      Graph myGraph = new Graph();

      myGraph.addVertex("A");
      myGraph.addVertex("B");
      myGraph.addVertex("C");

      myGraph.addEdge("A","B");
      myGraph.addEdge("A","C");
      myGraph.addEdge("B","C");

      myGraph.removeEdge("A","B");
        System.out.println('\n');

      myGraph.printGraph();

    }
}
