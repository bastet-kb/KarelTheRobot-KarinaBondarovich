package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

    /*
     * Precondition: Karel is in the center cell of the first reactor element.
     * Result: Karel cleaned the reactor and disposed all waste.
     */

    public void run() throws Exception {

        // Check whether there is a new element.
        while (frontIsClear()) {

            /*
             * Precondition: Karel is in the empty cell of the element.
             * Result: Karel cleaned the element.
             */
            if (noBeepersPresent()) {
                // Check if the north cell has the beepers and clean it. Back to the hall. Face east.
                cleanTheLeftElement();
                // Check if the south cell has the beepers and clean it. Back to the hall. Face east.
                cleanTheRightElement();
            }
            // Check whether there is a new element and go into it.
            goToTheNextElement();

        }
        // This part will proceed if the element's central cell has a beeper
        // (no cleaning needed)
        while (beepersPresent() && frontIsClear()) {
            goToTheNextElement();
        }
    }
    /*
     * Precondition: Karel is in the center cell of the reactor element.
     * The beeper is not present in this cell.
     * Result: Karel checked the north part of the element whether the cleaning is needed.
     * Removed all waste and/or turn back to the central cell and faced the east.
     */
    private void cleanTheLeftElement() throws Exception {
        turnLeft();
        move();
        // Check whether cleaning is needed. If beepers present clean the part.
        if( beepersPresent()){
            while (beepersPresent()){
                pickBeeper();
            }
        }
        /*
         * Precondition: The north part of the reactor is empty.
         * Result: Karel turn around and returned to the central cell and faced the east.
         */
        if (noBeepersPresent()){
            turnAround();
            move();
            turnLeft();}

    }
    /*
     * Precondition: Karel is in the center cell of the reactor element.
     * The beeper is not present in this cell.
     * Result: Karel checked the south part of the element whether the cleaning is needed.
     * Removed all waste and/or turn back to the central cell and faced the east.
     */
    private void cleanTheRightElement() throws Exception {
        turnRight();
        move();
        // Check whether cleaning is needed. If beepers present clean the part.
        if ( beepersPresent()){
            while (beepersPresent()){
                pickBeeper();
            }
        }
        /*
         * Precondition: The south part of the reactor is empty.
         * Result: Karel turn around and returned to the central cell and faced the east.
         */
        if (noBeepersPresent()){
            turnAround();
            move();
            turnRight();}

    }
    /*
     * Precondition: Karel is in the center cell of the reactor element. Karel is faced east.
     * Result: If the next element is existed in the reactor
     * Karel moved there into the central cell.
     */
    private void goToTheNextElement() throws Exception {
        for (int i = 0; i < 2 && frontIsClear(); i++) {
            move();
        }
    }
    /*
     * Precondition: None
     * Result: Karel turned 180 degrees counterclockwise from his starting direction.
     * (opposite direction)
     */
    private void turnAround() throws Exception{
        turnLeft();
        turnLeft();
    }
    /*
     * Precondition: None
     * Result: Karel turned 240 degrees counterclockwise from his starting direction.
     * (right)
     */
    private void turnRight() throws Exception  {
        turnLeft();
        turnLeft();
        turnLeft();
    }


}




