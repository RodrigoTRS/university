package graph;

import java.util.List;

public class GraphMatrix extends DigraphMatrix
{

    public GraphMatrix(List<Vertex> vertices)
    {
        super(vertices);
    }

    public GraphMatrix()
    {
        super();
    }

    @Override
    public void addEdge(Vertex source, Vertex destination)
    {
        super.addEdge(source, destination);
        super.addEdge(destination, source);
    }

    @Override
    public void removeEdge(Vertex source, Vertex destination)
    {
        super.removeEdge(source, destination);
        super.removeEdge(destination, source);
    }

    @Override
    protected GraphMatrix clone() throws CloneNotSupportedException
    {
        return (GraphMatrix)super.clone();
    }
}
