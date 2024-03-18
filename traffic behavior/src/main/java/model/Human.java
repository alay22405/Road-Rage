package model;

import java.util.Map;

public class Human extends abstractVehicle {

    public Human(int theX, int theY, Direction theDir) {

        super(theX, theY, theDir);
        //req of Collision behaviour is here in the below NoDays 45.
  NoDays=45;
       
    }
    /**
     * @param theTerrain, theLight of The Human must not travel in the traffic light. However, Humans, can travel when the CROSSWALK is RED or YELLOW only.
     * @return    but, if the light of the CROSSWALK is GREEN, it returns false.
     */
//Req of E,F is here in the method of canPass.

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if (theTerrain == Terrain.CROSSWALK) {

            if (theLight == Light.GREEN) {
                return false;
            }
        }
        return true;
    }

    /**
     *    the Human travels randomly whether straight, left, or right
     *      @return but, if it can't make all the above direction, return around/reverse
     */
//Req of A,B,C,D is here in the method of chooseDirection
    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {

        Direction[] d = {getDirection(), getDirection().left(), getDirection().right()};
        for (Direction theDirection : d) {
            if (theNeighbors.get(theDirection) == Terrain.CROSSWALK) {
                return theDirection;
            }
        }

        for (Direction theDirection : d) {
            if (theNeighbors.get(theDirection).equals(Terrain.GRASS)
                    || theNeighbors.get(theDirection).equals(Terrain.TRAIL)) {
                return theDirection;
            }
        }
        return getDirection().reverse();
    }
}
