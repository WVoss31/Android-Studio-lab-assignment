package com.example.problem_solver.domains.farmer;

import com.example.problem_solver.framework.problem.Problem;

/**
 *
 * @author walker
 */
public class FarmerProblem extends Problem{
    public FarmerProblem() {
        super();
        super.setName("Welcome to the Farmer, Wolf, Goat, and Cabbage Problem");
        super.setIntroduction("A farmer and his wolf, goat, and cabbage come to the edge of a river they wish to cross. There is a boat "
                + "at the river's edge that only the farmer can row. The farmer can take at most one other object besides himself on a crossing, "
                + "but if the wolf is ever left with the goat, the wolf will eat the goat; similarly, if the goat is left with the cabbage, the goat will eat the "
                + "cabbage. Devise a sequence of crossings of the river so that all four characters arrive safely on the other side.");
        super.setMover(new FarmerMover());
        super.setInitialState(new FarmerState("West", "West", "West", "West"));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new FarmerState("East", "East", "East", "East"));
    }
}