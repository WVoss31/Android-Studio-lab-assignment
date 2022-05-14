package com.example.problem_solver;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.problem_solver.domains.farmer.FarmerProblem;
import com.example.problem_solver.domains.puzzle.PuzzleProblem;
import com.example.problem_solver.framework.graph.Vertex;
import com.example.problem_solver.framework.problem.State;
import com.example.problem_solver.framework.solution.AStarSolver;
import com.example.problem_solver.framework.solution.Solution;
import com.example.problem_solver.framework.solution.SolvingAssistant;

public class farmer_interactive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_interactive);
        problem = new FarmerProblem();
        //creating and setting up the states
        currentView = (TextView) findViewById(R.id.farmer_currentState);
        finalView = (TextView) findViewById(R.id.farmer_GoalState);
        currentView.setText(problem.getInitialState().toString());
        finalView.setText(problem.getFinalState().toString());

        //initializing the farmer message and move counts
        message = (TextView) findViewById(R.id.farmer_message);
        count = (TextView) findViewById(R.id.farmer_move_counter);

        //gonna work with the move buttons now
        movesView = (LinearLayout) findViewById(R.id.farmer_moves);
        assistant = new SolvingAssistant(problem);
        reset = (Button) findViewById(R.id.farmer_reset);
        reset.setOnClickListener(e -> {
            assistant.reset();
            currentView.setText(problem.getInitialState().toString());
            message.setText("");
            count.setText(Integer.toString(0));
        });
        makeMoveButtons();
        solve = (Button) findViewById(R.id.farmer_solve);
        solve.setOnClickListener(e -> {
            next.setEnabled(true);
            solve.setEnabled(false);
            A_Star = new AStarSolver(problem);
            A_Star.solve();
            solution = A_Star.getSolution();
            Stats.setText(A_Star.getStatistics().toString());
        });

        next = (Button) findViewById(R.id.farmer_next);
        next.setEnabled(false);
        next.setOnClickListener(e -> {
            Vertex v = solution.next();
            State state = (State) v.getData();
            assistant.update(state);
            currentView.setText(problem.getCurrentState().toString());
            count.setText(assistant.getMoveCount());
            if (assistant.isProblemSolved()) {
                message.setText("Congratulations!");
                next.setEnabled(false);
                solve.setEnabled(true);
            }
        });
    }

    private void makeMoveButtons() {
        problem.getMover().getMoveNames().forEach(e -> {
            Button button = new Button(movesView.getContext());
            button.setOnClickListener(view -> {
                button.setTag(e);
                assistant.tryMove(e);
                if (!assistant.isMoveLegal()) {
                    message.setText("Illegal Move");
                }
                else {
                    NumCount++;
                    count.setText(Integer.toString(NumCount));
                }
                if (problem.getCurrentState().equals(problem.getFinalState())) {
                    message.setText("Congratulations!");
                    next.setEnabled(false);
                }
                currentView.setText(problem.getCurrentState().toString());
            });
            button.setText(e);
            movesView.addView(button);
        });
    }

    private LinearLayout movesView;
    private SolvingAssistant assistant;
    private FarmerProblem problem;
    private TextView message;
    private TextView count;
    private int NumCount;
    private Button next, solve, reset;
    private TextView currentView, finalView;
    private AStarSolver A_Star;
    private TextView Stats;
    private Solution solution;
}