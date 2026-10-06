package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.KarelTheRobot;

public class assignment1number2 extends KarelTheRobot {
    /*
     * Precondition: The maze size is at least 3 x 3.
     *               Karel is at the west point with a full bag of beepers
     * Result: Karel marked the second cell from both west and east edges with beepers.
     *         He is circling between these markers and moving them closer every time
     *         he meets them. When the markers meet each other, Karel will find the middle.
     */

    public void run() throws Exception {

        //Place the first marker (beeper) from the west edge.
        move();
        putBeeper();
        goToEdge();
        turnAround();
        move();

        /*
        * Karel needs to check for the marker first,
        * as there can be 3-cell field (edge case).
        */
        if (noBeepersPresent()) {
            //Place the first marker (beeper) from the east edge.
            putBeeper();
            move();
            /*
             * Karel needs to check for the marker first,
             * as there can be 4-cell field (edge case).
             */
            if (noBeepersPresent() ){
                // Look for oncoming marker.
                while (noBeepersPresent()) {
                    move();
                }
                if (beepersPresent()) {
                    // The oncoming marker is found. Start circling.
                    while (frontIsClear() ) {

                        //Start new circle from west edge.
                        pickBeeper();
                        turnAround();
                        move();

                        //Check for oncoming marker.
                        if (noBeepersPresent()) {
                            putBeeper();
                            move();

                            if (beepersPresent()) {
                                // Program will finish, as Karel found the middle.
                                pickBeeper();
                                turnAround();
                                goToEdge();

                            } else {
                                // If Karel processes this part,
                                // that means the field is 6 cells or more.
                                while (noBeepersPresent()) {
                                    move();
                                }
                                if (beepersPresent()) {
                                    // Start a circle part from the east edge.
                                    pickBeeper();
                                    turnAround();
                                    move();
                                    if (noBeepersPresent()) {
                                        /*
                                         * Precondition: No beepers are present in the current cell.
                                         *               Karel isn't facing the wall or edge.
                                         * Result: Karel placed the beeper and checked for beeper in next cell.
                                         *         Went to look the oncoming marker (beeper)
                                         */
                                        putNewAndFindOncoming();
                                    }
                                } else {
                                    // Program will finish, as Karel found the middle.
                                    goToEdge();
                                }
                            }
                        }
                        // Program will finish, as Karel is facing a 5-cell field.
                        else {

                            turnAround();
                            goToEdge();
                        }

                    }

                }
            }
            //Program will finish, as Karel is facing a 4-cell field.
            else {
                pickBeeper();
                goToEdge();
            }
        }
        //Program will finish, as Karel is facing a 3-cell field.
        else {
            goToEdge();
        }



    }


    private void putNewAndFindOncoming() throws Exception {
        putBeeper();
        if (frontIsClear()) {
            move();
            while (noBeepersPresent() && frontIsClear()) {
                move();
            }
        }
    }


    private void goToEdge() throws Exception {
        while (frontIsClear()) {
            move();
        }

    }



    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }




}


