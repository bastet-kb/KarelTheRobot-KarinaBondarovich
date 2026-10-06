package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1number3 extends KarelTheRobot {

    /*
     * Precondition: Karel is at the west point with a full bag of beepers
     * Result: Karel drew the chequerboard with beepers on the field.
     *
     */
    public void run() throws Exception {

        // Check if the field consists of only one vertical row
        if (facingEast() && frontIsBlocked()) {

            turnLeft();
            /*
             * Precondition: The board is one vertical line of cells
             * Result: Karel put the beepers into the 1st cell of every two cells.
             */
            putBeepersIntoOneVertical();

        }

        // Precondition: This part will proceed if we are facing
        // a horizontally oriented field
        if (facingEast() && frontIsClear()) {
            /*
             * Precondition: Karel is facing east
             * Result: Karel put beepers into the 1st cell of every two cells.
             *
             */
            putBeeperIntoEveryFirst();
            // Return to the first cell of the current row.
            turnBack();
            // Turn to face new row or check whether it exists.
            turnRight();


            // Precondition: This part will proceed if we are facing a multirow field.
            while (facingNorth() && frontIsClear()) {
                // Make a step into first cell of new row.
                moveIntoNextRow();
                /*
                 * Precondition: Karel is facing east
                 * Result: Karel put the beepers into the 2nd cell of every two.
                 *
                 */
                putBeeperIntoEverySecond();
                // Return to the first cell of the current row.
                turnBack();
                // Turn to face new row or check whether it exists.
                turnRight();

                // Make a step into the first cell of new row if it exists.
                if (frontIsClear()) {
                    moveIntoNextRow();
                }
                // Put beepers into the 1st cell of every two.
                putBeeperIntoEveryFirst();
                turnBack();
                turnRight();

            }
        }
        // This part is for returning Karel to the south-west cell.
        else  {
            turnBack();
            turnRight();
        }
    }

    private void putBeeperIntoEverySecond() throws Exception {
        int i;
        for (i = 2; frontIsClear(); i++) {
            if (i % 2 != 0) {
                putBeeper();
                move();
            } else {
                move();
            }
        }
        if (frontIsBlocked() && i % 2 != 0 && facingEast()) {
            putBeeper();
        }
    }

    private void putBeeperIntoEveryFirst()throws Exception {
        int i;
        for (i = 1; frontIsClear(); i++) {

            if (i % 2 != 0) {
                putBeeper();
                move();
            } else {
                move();
            }
        }
        if (frontIsBlocked() && i % 2 != 0 && facingEast()) {
            putBeeper();
        }
    }

    private void putBeepersIntoOneVertical() throws Exception {
        int i;
        for (i = 1; frontIsClear(); i++) {

            if (i % 2 != 0) {
                putBeeper();
                move();
            } else {
                move();

            }

        }
        if (frontIsBlocked() && i % 2 != 0 && facingNorth()) {
            putBeeper();
        }
    }

    private void moveIntoNextRow () throws Exception {
            move();
            turnRight();
        }

        private void turnRight () throws Exception {
            turnLeft();
            turnLeft();
            turnLeft();
        }


        private void turnBack () throws Exception {
            turnLeft();
            turnLeft();
            while (frontIsClear()) {
                move();
            }
        }




}
