package graph;

public interface GraphInterface
{
    void addVertex(Vertex vertex);

    void addEdge(Vertex source, Vertex destination);

    void removeEdge(Vertex source, Vertex destination);

    boolean edgeExists(Vertex source, Vertex destination);

    boolean hasAnyEdge(Vertex vertex);

    Vertex getFirstConnectedVertex(Vertex vertex);

    Vertex getNextConnectedVertex(Vertex source, Vertex currentConnection);

    String toString();
}
