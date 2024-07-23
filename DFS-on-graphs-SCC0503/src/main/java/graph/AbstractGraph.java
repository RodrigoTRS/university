package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements GraphInterface, Cloneable
{
    protected static final int GRAPHVIZ_IMAGE_WIDTH = 2000;
    protected static final String GRAPHVIZ_FOLDER = "example/";
    protected static final String GRAPHVIZ_FILE_EXTENSION = ".png";
    private int numberOfVertices;
    private List<Vertex> vertices;

    protected AbstractGraph(List<Vertex> vertices)
    {
        numberOfVertices = vertices.size();
        setVertices(vertices);
    }

    protected AbstractGraph()
    {
        vertices = new ArrayList<>();
        numberOfVertices = 0;
    }

    @Override
    public void addVertex(Vertex vertex)
    {
        vertices.add(vertex);
        numberOfVertices = vertices.size();
    }

    public int getNumberOfVertices()
    {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
    }

    public List<Vertex> getVertices()
    {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices)
    {
        this.vertices = vertices;
    }

    public void addEdge(Vertex source, Vertex destination)
    {
        addEdge(source, destination);
    }
}
