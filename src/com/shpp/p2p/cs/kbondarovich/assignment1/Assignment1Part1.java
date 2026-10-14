package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends SuperKarel {
    /*
     * Precondition: Karel is at his starting position
     * Result: Karel repaired all columns
     */
    public void run() throws Exception {

        goUpAndBuildTheColumn();

        while (frontIsClear()) {
            findThePlaceForNextColumn();
            goUpAndBuildTheColumn();
        }
    }

    /*
     * Precondition: Karel is facing north at the base of the column
     * Result: Karel went through the column,
     *          put beepers into empty cells,
     *          returned to the starting position,
     *          and faced south.
     */
    private void goUpAndBuildTheColumn() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
                move();
            } else {
                move();
            }
        }
        if (noBeepersPresent()) {
            putBeeper();
        }
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    /* Precondition: Karel is facing east at the base of the just repaired column
     * Result: Karel made 4 steps and is stood on the 5th cell.
     */
    private void findThePlaceForNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

}
