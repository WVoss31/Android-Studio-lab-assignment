package com.example.problem_solver.framework.solution;

import com.example.problem_solver.framework.graph.Vertex;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author tcolburn
 */
public class Solution implements Iterator<Vertex> {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        vertexStack = new Stack<>();
        vertexStack.push(end);
        while (vertexStack.peek() != start) {
            vertexStack.push(vertexStack.peek().getPredecessor());
        }
//        vertexStack.push(start);
    }

    /**
     * Gets the length of the solution.
     * This is the number of moves in the solution, not the
     * number of vertices.
     * @return the solution length
     */
    public int getLength() {
        return vertexStack.size()-1;
    }

    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    @Override
    public boolean hasNext() {
//        return vertexStack.peek() != null;
        return this.getLength() != -1;

    }

    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    @Override
    public Vertex next() {
        if (!this.hasNext()) {
            throw new RuntimeException();
        }
//        vertexStack.peek();
        return vertexStack.pop();
    }

    private final Stack<Vertex> vertexStack;
}
