package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends SuperKarel {
    /*
     * Precondition: The maze size is at least 3 x 3.
     *               Karel is at the west point with a full bag of beepers
     * Result: Karel marked the second cell from both west and east edges with beepers.
     *         He is circling between these markers and moving them closer every time
     *         he meets them. When the markers meet each other, Karel will find the middle.
     */
    public void run() throws Exception {
        //Place the first marker (beeper) from the west edge.(1)
        putBeeper();
        //In case Karel is facing 1 cell field
        if (frontIsBlocked()) {
        }
        // This part will process if the field is more than 1 cell
        else {
            goToEdge();
            //Place the first marker (beeper) from the east edge.(2)
            putBeeperAndTurnAround();
            move();
            // This part will process until Karel find the oncoming beeper
            // in the next oncoming cell after beeper was placed
            while (noBeepersPresent()) {
                while (noBeepersPresent()) {
                    move();
                }
                pickBeeperAndTurnAround();
                move();
                // Place new beeper one cell closer to the mid. (4)
                putBeeper();
                move();
            }
            // Karel found an oncoming beeper
            theMidIsFound();
        }
    }

    /*
     * Precondition: Karel is moving within the looking circle
     * Result: Karel found an oncoming beeper - found the mid.
     * Karel picked redundant beeper and stood at the edge what he was faced
     */
    private void theMidIsFound() throws Exception {
        if (beepersPresent()) {
            pickBeeper();
            goToEdge();
        }
    }

    /*
     * Precondition: Beeper is in the cell
     * Result: The cell is empty and Karel is ready to go in the opposite direction.
     */
    private void pickBeeperAndTurnAround() throws Exception {
        pickBeeper();
        turnAround();
    }

    /*
     * Precondition: Beeper is not in the cell
     * Result: The beeper is placed and Karel is ready to go in the opposite direction.
     */
    private void putBeeperAndTurnAround() throws Exception {
        putBeeper();
        turnAround();
    }

    /*
     * Precondition: The front is clear
     * Result: Karel is facing east or west edge. The front is blocked
     */
    private void goToEdge() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

}


