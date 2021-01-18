
class Vertex {
	public int Value;
	public boolean Hit;
	public Stack<Integer> ways;
	public Vertex from;
	public ArrayList<Vertex> fromList;
	public Vertex(int val) {
		Value = val;
		ways = new Stack<Integer>();
		Hit = false;
		fromList = new ArrayList<Vertex>();
	}
}

class SimpleGraph {
	Vertex[] vertex;
	int[][] m_adjacency;
	int max_vertex;
	Stack<Integer> freeSlots;

	public SimpleGraph(int size) {
		max_vertex = size;
		m_adjacency = new int[size][size];
		vertex = new Vertex[size];
		freeSlots = new Stack<Integer>();
		for (int i = size - 1; i >= 0; i--)
			freeSlots.push(i);
	}

	ArrayList<Vertex> dfs;

	public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
		for (int i = 0; i < vertex.length; i++)
			vertex[i].Hit = false;
		dfs = new ArrayList<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex current = vertex[VFrom];
		stack.push(current);
		current.Hit = true;
		go: while (!stack.isEmpty()) {
			current = stack.pop();
			dfs.add(current);
			for (int i = 0; i < current.ways.size(); i++) {
				if (vertex[current.ways.get(i)].Value == vertex[VTo].Value) {
					stack.push(vertex[VTo]);
					vertex[VTo].Hit = true;
					dfs.add(vertex[VTo]);
					break go;
				}
				if (vertex[current.ways.get(i)].Hit == false) {
					vertex[current.ways.get(i)].Hit = true;
					stack.push(vertex[current.ways.get(i)]);
				}

			}
		}
		if (vertex[VTo].Hit == false)
			dfs.clear();
		return dfs;
	}

	public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
		for (int i = 0; i < vertex.length; i++)
			vertex[i].Hit = false;
		dfs = new ArrayList<Vertex>();
	    Deque <Vertex> queue = new LinkedList<Vertex>();
		Vertex current = vertex[VFrom];
		queue.add(current);
		current.Hit = true;
		go: while (!queue.isEmpty()) {
			current = queue.poll();
			for (int i = 0; i < current.ways.size(); i++) {
				if (vertex[current.ways.get(i)].Hit == false) {
					vertex[current.ways.get(i)].Hit = true;
					queue.add(vertex[current.ways.get(i)]);
					vertex[current.ways.get(i)].from = current;
				}
				if (vertex[current.ways.get(i)].Value == vertex[VTo].Value) {
					queue.add(vertex[VTo]);
					vertex[VTo].Hit = true;
					break go;
				}

				
			}
		}
		if (vertex[VTo].Hit == false)
			dfs.clear();
		else {
			current = queue.getLast();
			while(current.Value != vertex[VFrom].Value) {
				dfs.add(current);
				current = current.from;
			}
			dfs.add(current);
			Collections.reverse(dfs);
		}
		return dfs;
	}
	
	//boolean isTriangle;
	public ArrayList<Vertex> WeakVertices()
    {
		ArrayList<Vertex> res = new ArrayList<Vertex>();
		for(int i = 0 ; i < vertex.length; i++)
			res.add(vertex[i]);
		
		for(int i = 0; i < vertex.length; i++) {
			for (int j = 0; j < vertex[i].fromList.size(); j++) {
				//System.out.print(vertex[i].fromList.get(j).Value);
				for (int k = 0; k < vertex[i].fromList.get(j).fromList.size() ;k++) {
					if(vertex[i].fromList.contains(vertex[i].fromList.get(j).fromList.get(k)))
						res.remove(vertex[i]);
					//System.out.print(vertex[i].fromList.get(j).fromList.get(k).Value);
				}
			//	System.out.println();
			}
			
		}
		
		return res;
    }
	

	public void printT(ArrayList<Vertex> vertex2) {
		for(int i = 0; i < vertex2.size(); i++)
			System.out.print(vertex2.get(i).Value+ " ");
		System.out.println();
	}


	public void AddVertex(int value) {
		Vertex ver = new Vertex(value);
		int freeSlot = freeSlots.pop();
		vertex[freeSlot] = ver;
	}

	// здесь и далее, параметры v -- индекс вершины
	// в списке vertex
	public void RemoveVertex(int v) {
		while (!vertex[v].ways.isEmpty()) {
			m_adjacency[v][vertex[v].ways.peek()] = 0;
			m_adjacency[vertex[v].ways.pop()][v] = 0;
		}
		vertex[v] = null;

		freeSlots.push(v);
	}
	
	

	public boolean IsEdge(int v1, int v2) {
		return m_adjacency[v1][v2] == 1 ? true : false;
	}

	public void AddEdge(int v1, int v2) {
		if (vertex[v1] != null && vertex[v2] != null) {
			m_adjacency[v1][v2] = 1;
			m_adjacency[v2][v1] = 1;
			vertex[v1].ways.push(v2);
			vertex[v2].ways.push(v1);
			vertex[v2].fromList.add(vertex[v1]);
			vertex[v1].fromList.add(vertex[v2]);
		}
	}

	public void RemoveEdge(int v1, int v2) {
		if (m_adjacency[v1][v2] == 0)
			return;
		if (vertex[v1] != null && vertex[v2] != null) {
			m_adjacency[v1][v2] = 0;
			m_adjacency[v2][v1] = 0;
		}
	}
}
