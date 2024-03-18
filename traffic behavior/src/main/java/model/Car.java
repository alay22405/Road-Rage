package model;

import java.util.Map;
public class Car extends abstractVehicle {

    //method
    public Car(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);

        //Req of Collision behaviour is here in NoDays which is 15
        NoDays = 15;
    }
    /**
     *   theTerrain, theLight of The Taxi must stop when the traffic light is RED, and stop when the CROSSWALK light is RED/YELLOW.
     *      * @return    but, if the light of the CROSSWALK is GREEN, it returns travel.
     */

    // Req of A,C,D,E is here in the method of canPass

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {

        if (theTerrain == Terrain.CROSSWALK) {

            if (theLight == Light.RED) {
                return false;
            }
            if (theLight == Light.YELLOW) {
                return false;
            }
            return true;
        }
        if (theTerrain == Terrain.LIGHT) {
            if (theLight == Light.RED) {
                return false;
            }
        }
        return true;
    }

    /**
     * the Car prefer to travel in straight, if not, it travels left. If it cannot move left, it turns right.
     *  @return if it can't make all the above direction, return around/reverse
     */
// Req of A,B is here in the method of chooseDirection
    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        Direction[] d = {getDirection(), getDirection().left(), getDirection().right()};
        for (Direction getDirection : d) {
            if (theNeighbors.get(getDirection).equals(Terrain.STREET)
                    || theNeighbors.get(getDirection).equals(Terrain.CROSSWALK)
                    || theNeighbors.get(getDirection).equals(Terrain.LIGHT)) {
                return getDirection;
            }
        }
        return getDirection().reverse();
    }
}


