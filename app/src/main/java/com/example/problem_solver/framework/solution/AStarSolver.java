package com.example.problem_solver.framework.solution;

import com.example.problem_solver.framework.graph.Vertex;
import com.example.problem_solver.framework.problem.Problem;
import com.example.problem_solver.framework.problem.State;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Your name and section here
 */
public class AStarSolver extends StateSpaceSolver {

    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem
     */
    public AStarSolver(Problem problem) {
        super(problem);
        super.getStatistics().setHeader("A* Search");
    }
}