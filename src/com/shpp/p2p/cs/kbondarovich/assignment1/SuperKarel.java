package com.shpp.p2p.cs.kbondarovich.assignment1;

import com.shpp.karel.*;

public class SuperKarel extends KarelTheRobot{

    /*
     * Precondition: None
     * Result: Karel turned 270 degrees counterclockwise from his starting direction.
     * (right)
     */
    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    /*
     * Precondition: None
     * Result: Karel turned 180 degrees counterclockwise from his starting direction.
     * (opposite)
     */
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

}