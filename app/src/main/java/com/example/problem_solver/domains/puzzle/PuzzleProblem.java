package com.example.problem_solver.domains.puzzle;

import com.example.problem_solver.framework.problem.Benchmark;
import com.example.problem_solver.framework.problem.Problem;

/**
 *
 * @author Walker Voss
 */
public class PuzzleProblem extends Problem {

    public final String INTRO = "Welcome to the puzzle problem. This is like a sliding puzzle,"
            + " but all the numbers must be in numerical order from the upper left corner, and "
            + "it must circle all the way around the puzzle in a clockwise motion.";

    public PuzzleProblem() {
        super();
        super.setName("Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.addBenchmark(new Benchmark("8-Puz 1", 5, BENCH1, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 2", 10, BENCH2, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 3", 13, BENCH3, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 4", 18, BENCH4, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 5", 20, BENCH5, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 6", 24, BENCH6, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 7", 30, BENCH7, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 8", 30, BENCH8, GOAL));
        super.setInitialState(new PuzzleState(new int[][]{new int[]{2, 8, 3},
                new int[]{1, 6, 4},
                new int[]{7, 0, 5}}));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(new int[][]{new int[]{1, 2, 3},
                new int[]{8, 0, 4},
                new int[]{7, 6, 5}}));
    }

    public static final PuzzleState BENCH1 =
            new PuzzleState(new int[][]{new int[]{2, 8, 3},
                    new int[]{1, 6, 4},
                    new int[]{7, 0, 5}});

    public static final PuzzleState BENCH2 =
            new PuzzleState(new int[][]{new int[]{3, 6, 4},
                    new int[]{1, 0, 2},
                    new int[]{8, 7, 5}});

    public static final PuzzleState BENCH3 =
            new PuzzleState(new int[][]{new int[]{3, 0, 4},
                    new int[]{1, 6, 5},
                    new int[]{8, 2, 7}});

    public static final PuzzleState BENCH4 =
            new PuzzleState(new int[][]{new int[]{2, 1, 3},
                    new int[]{8, 0, 4},
                    new int[]{6, 7, 5}});

    public static final PuzzleState BENCH5 =
            new PuzzleState(new int[][]{new int[]{4, 2, 0},
                    new int[]{8, 3, 6},
                    new int[]{7, 5, 1}});

    public static final PuzzleState BENCH6 =
            new PuzzleState(new int[][]{new int[]{1, 6, 3},
                    new int[]{4, 0, 8},
                    new int[]{7, 2, 5}});

    public static final PuzzleState BENCH7 =
            new PuzzleState(new int[][]{new int[]{5, 6, 7},
                    new int[]{4, 0, 8},
                    new int[]{3, 2, 1}});

    public static final PuzzleState BENCH8 =
            new PuzzleState(new int[][]{new int[]{5, 2, 7},
                    new int[]{8, 0, 4},
                    new int[]{3, 6, 1}});

    private static final PuzzleState GOAL =
            new PuzzleState(new int[][]{new int[]{1, 2, 3},
                    new int[]{8, 0, 4},
                    new int[]{7, 6, 5}});
}
