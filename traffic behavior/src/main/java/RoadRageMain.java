/*
 * TCSS 305 - Road Rage
 */

//package view;

import view.RoadRageGUI;

import java.awt.EventQueue;

/**
 * Runs the Road Rage program.
 *
 */

public final class RoadRageMain {
    
    /**
     * Private constructor to prevent construction of instances.
     */
    private RoadRageMain() {
        // do nothing
    }

    /**
     * Constructs the main GUI window frame.
     * 
     * @param theArgs Command line arguments (ignored).
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoadRageGUI();
            }
        });
    }
}
