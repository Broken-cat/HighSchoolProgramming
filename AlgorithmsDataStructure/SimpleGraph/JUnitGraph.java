	package SimpleGraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitGraph {

	@Test
	public void test() {
		SimpleGraph g = new SimpleGraph(6);
		for(int i = 1; i < 7; i++)
			g.AddVertex(i);
		g.AddEdge(0, 1);
		g.AddEdge(0, 2);
		g.AddEdge(1, 0);
		g.AddEdge(1, 3);
		g.AddEdge(2, 4);
		g.AddEdge(3, 5);
		g.AddEdge(4, 2);
		g.AddEdge(4, 3);
		g.AddEdge(4, 5);
		g.AddEdge(5, 3);
		
		g.RemoveEdge(0, 1);
		g.RemoveEdge(5, 3);
		

		for(int i = 0; i < 6;i++)
			for(int j = 0; j < 6;j++)
				g.AddEdge(i, j);
		
		
		g.RemoveVertex(3);
		
	}

}
