package com.example.problem_solver.domains.farmer;


import com.example.problem_solver.framework.problem.State;
import java.util.Objects;

/**
 *
 * @author walker
 */
public class FarmerState extends State {

    public FarmerState(String f, String w, String g, String c) {
        this.farmer = f;
        this.wolf = w;
        this.goat = g;
        this.cabbage = c;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        FarmerState other = (FarmerState) object;
        return (this.farmer.equals(other.farmer) &&
                this.wolf.equals(other.wolf) &&
                this.goat.equals(other.goat) &&
                this.cabbage.equals(other.cabbage));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.farmer);
        hash = 67 * hash + Objects.hashCode(this.wolf);
        hash = 67 * hash + Objects.hashCode(this.goat);
        hash = 67 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }


    @Override
    public String toString() {
        String riverString = "   |  |   \n";
        String farmerString = " F |  |   \n";
        String wolfString = " W |  |   \n";
        String goaString = " G |  |   \n";
        String cabString = " C |  |   \n";
        String emptyString = "   |  |   ";

        if (farmer.equals("East")) { farmerString = "   |  | F \n"; }
        if (wolf.equals("East")) { wolfString = "   |  | W \n"; }
        if (goat.equals("East")) { goaString = "   |  | G \n"; }
        if (cabbage.equals("East")) { cabString = "   |  | C \n"; }
        return riverString + farmerString + wolfString + goaString + cabString + emptyString;
    }

    public final String getFarmer() {
        return farmer;
    }

    public final String getWolf() {
        return wolf;
    }

    public final String getGoat() {
        return goat;
    }

    public final String getCabbage() {
        return cabbage;
    }

    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;

}

