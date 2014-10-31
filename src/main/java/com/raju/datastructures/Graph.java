package com.raju.datastructures;

import java.util.LinkedList;
import java.util.List;

public class Graph<E> {

	private E data;
	private List<Graph<E>> nodes = new LinkedList<Graph<E>>();
	
	public Graph(E data) {
		this.data = data;
	}
	
	public boolean addNode(Graph<E> node) {
		return nodes.add(node);
	}
	
	public boolean removeNode(Graph<E> node) {
		return nodes.remove(node);
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public List<Graph<E>> getNodes() {
		return nodes;
	}
	
	public void setNodes(List<Graph<E>> nodes) {
		this.nodes = nodes;
	}
	
	// Depth First approach!
	public boolean hasConnection(Graph<E> endNode) {
		if (this.equals(endNode)) {
			return true;
		}
		for (Graph<E> node : nodes) {
			if (node.hasConnection(endNode)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Graph<E> other = (Graph<E>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	public static void main(String args[]) {
		Graph<String> bangalore = new Graph<String>("Bangalore");
		Graph<String> mysore = new Graph<String>("Mysore");
		Graph<String> udupi = new Graph<String>("Udupi");
		Graph<String> mangalore = new Graph<String>("Mangalore");
		Graph<String> ooty = new Graph<String>("Ooty");
		
		bangalore.addNode(mysore);
		bangalore.addNode(mangalore);
		
		udupi.addNode(ooty);
		
		mysore.addNode(ooty);
		
		mangalore.addNode(udupi);
		
		System.out.println(bangalore.hasConnection(udupi));
		System.out.println(udupi.hasConnection(mysore));
	}
}
