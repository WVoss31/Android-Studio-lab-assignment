package com.example.problem_solver.framework.solution;

import com.example.problem_solver.framework.graph.Vertex;
import com.example.problem_solver.framework.problem.Mover;
import com.example.problem_solver.framework.problem.Problem;
import com.example.problem_solver.framework.problem.State;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public abstract class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue
     * (DEQUE) like the GraphSolver.
     * @param problem the problem being solved
     */
    public StateSpaceSolver(Problem problem) {
        super(problem);
        super.setQueue(new LinkedList<>());
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm.
     * @param u the vertex being expanded
     * @return the children of u in the state space search tree
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> ReturnVertexes = new LinkedList<>();
        List<String> moves = getProblem().getMover().getMoveNames();
        for (String m : moves) {
            Vertex next = new Vertex(getProblem().getMover().doMove(m, (State) u.getData()));
            if (next.getData() != null) {
                ReturnVertexes.add(next);
            }
        }
        return ReturnVertexes;
    }
}
