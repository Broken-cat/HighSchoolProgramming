package SimpleGraph;

import java.util.*;

class Vertex
{
    public int Value;
    public Stack<Integer> ways;
    public Vertex(int val)
    {
      Value = val;
      ways = new Stack<Integer>();
    }
}
  
class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;
    Stack<Integer> freeSlots;
	
    public SimpleGraph(int size)
    {
      max_vertex = size;
      m_adjacency = new int [size][size];
      vertex = new Vertex[size];
      freeSlots = new Stack<Integer>();
      for(int i = size-1; i >= 0; i--)
    	  freeSlots.push(i);
    }
	
    public void AddVertex(int value)
    {
     Vertex ver = new Vertex(value);
     int freeSlot = freeSlots.pop();
     vertex[freeSlot] = ver;
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
      while(!vertex[v].ways.isEmpty()) {
    	  m_adjacency[v][vertex[v].ways.peek()] = 0;
    	  m_adjacency[vertex[v].ways.pop()][v] = 0;
      }
      vertex[v] = null;
      
      freeSlots.push(v);
    }
	
    public boolean IsEdge(int v1, int v2)
    {
     return m_adjacency[v1][v2] == 1 ? true : false;
    }
	
    public void AddEdge(int v1, int v2)
    {
     if(vertex[v1] != null && vertex[v2] != null) {
    	 m_adjacency[v1][v2] = 1;
    	 m_adjacency[v2][v1] = 1;
    	 vertex[v1].ways.push(v2);
    	 vertex[v2].ways.push(v1);
     }
    }
	
    public void RemoveEdge(int v1, int v2)
    {	if (m_adjacency[v1][v2] == 0)return;
    	if(vertex[v1] != null && vertex[v2] != null) {
       	 m_adjacency[v1][v2] = 0;
       	 m_adjacency[v2][v1] = 0;
       	 vertex[v1].ways.removeElement(v2);
       	 vertex[v2].ways.removeElement(v1);
        }
    }
}
