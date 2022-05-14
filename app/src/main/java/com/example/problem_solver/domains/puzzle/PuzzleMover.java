package com.example.problem_solver.domains.puzzle;

import com.example.problem_solver.framework.problem.Mover;
import com.example.problem_solver.framework.problem.State;
import com.example.problem_solver.domains.puzzle.PuzzleState.Location;

/**
 *
 * @author walker
 */
public class PuzzleMover extends Mover {
    public static final String slideTile1 = "Slide Tile 1";
    public static final String slideTile2 = "Slide Tile 2";
    public static final String slideTile3 = "Slide Tile 3";
    public static final String slideTile4 = "Slide Tile 4";
    public static final String slideTile5 = "Slide Tile 5";
    public static final String slideTile6 = "Slide Tile 6";
    public static final String slideTile7 = "Slide Tile 7";
    public static final String slideTile8 = "Slide Tile 8";

    public PuzzleMover() {
        super.addMove(slideTile1, s -> Slide(s, 1));
        super.addMove(slideTile2, s -> Slide(s, 2));
        super.addMove(slideTile3, s -> Slide(s, 3));
        super.addMove(slideTile4, s -> Slide(s, 4));
        super.addMove(slideTile5, s -> Slide(s, 5));
        super.addMove(slideTile6, s -> Slide(s, 6));
        super.addMove(slideTile7, s -> Slide(s, 7));
        super.addMove(slideTile8, s -> Slide(s, 8));

    }

    private PuzzleState Slide(State s, int num) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(num);
        Location l2 = state.getLocation(0);

        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }


    private boolean valid_move(Location tileL, Location blankL) {
        return ((tileL.getColumn() - 1 == blankL.getColumn() || tileL.getColumn() + 1 == blankL.getColumn())
                && (tileL.getRow() == blankL.getRow()))
                || ((tileL.getRow() - 1 == blankL.getRow()
                || tileL.getRow() + 1 == blankL.getRow())
                && tileL.getColumn() == blankL.getColumn());
    }
}