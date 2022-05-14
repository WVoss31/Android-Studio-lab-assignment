package com.example.problem_solver.domains.farmer;

import com.example.problem_solver.framework.problem.Mover;
import com.example.problem_solver.framework.problem.State;

/**
 *
 * @author walker
 */
public class FarmerMover extends Mover{
    private final String FARM = "Farmer Goes Alone";
    private final String WOLF = "Farmer Takes Wolf";
    private final String GOAT = "Farmer Takes Goat";
    private final String CABBAGE = "Farmer Takes Cabbage";

    public FarmerMover() {
        super.addMove(FARM, s -> goesAlone(s));
        super.addMove(WOLF, s -> takesWolf(s));
        super.addMove(GOAT, s -> takesGoat(s));
        super.addMove(CABBAGE, s -> takesCabbage(s));
    }

    private FarmerState goesAlone(State s) {
        FarmerState thisFarmerState = (FarmerState) s;
        if (thisFarmerState.getGoat().equals(thisFarmerState.getWolf())) {
            return null;
        }
        else if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage())) {
            return null;
        }
        if ("West".equals(thisFarmerState.getFarmer())) {
            return new FarmerState("East",
                    thisFarmerState.getWolf(),
                    thisFarmerState.getGoat(),
                    thisFarmerState.getCabbage());
        }
        else if (thisFarmerState.getFarmer().equals("East")) {
            return new FarmerState("West",
                    thisFarmerState.getWolf(),
                    thisFarmerState.getGoat(),
                    thisFarmerState.getCabbage());
        }

        return thisFarmerState;
    }

    private FarmerState takesWolf(State s) {
        FarmerState thisFarmerState = (FarmerState) s;
        if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage())) {
            return null;
        }
        else if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getWolf().equals("East"))) {
            return null;
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getWolf().equals("West")) {
            return null;
        }
        if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getWolf().equals("West")) {
            return new FarmerState("East",
                    "East",
                    thisFarmerState.getGoat(),
                    thisFarmerState.getCabbage());
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getWolf().equals("East")) {
            return new FarmerState("West",
                    "West",
                    thisFarmerState.getGoat(),
                    thisFarmerState.getCabbage());
        }

        return thisFarmerState;
    }


    private FarmerState takesGoat(State s) {
        FarmerState thisFarmerState = (FarmerState) s;
        if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getGoat().equals("East"))) {
            return null;
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getGoat().equals("West")) {
            return null;
        }
        if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getGoat().equals("West")) {
            return new FarmerState("East",
                    thisFarmerState.getWolf(),
                    "East",
                    thisFarmerState.getCabbage());
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getGoat().equals("East")) {
            return new FarmerState("West",
                    thisFarmerState.getWolf(),
                    "West",
                    thisFarmerState.getCabbage());
        }

        return thisFarmerState;
    }




    private FarmerState takesCabbage(State s) {
        FarmerState thisFarmerState = (FarmerState) s;
        if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage()) && thisFarmerState.getFarmer().equals(thisFarmerState.getWolf())) {
            return null;
        }
        else if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getCabbage().equals("East"))) {
            return null;
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getCabbage().equals("West")) {
            return null;
        }
        if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getCabbage().equals("West")) {
            return new FarmerState("East",
                    thisFarmerState.getWolf(),
                    thisFarmerState.getGoat(),
                    "East");
        }
        else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getCabbage().equals("East")) {
            return new FarmerState("West",
                    thisFarmerState.getWolf(),
                    thisFarmerState.getGoat(),
                    "West");
        }

        return thisFarmerState;
    }
}