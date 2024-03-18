package model;

import java.util.Map;

 public class Taxi extends abstractVehicle {

    public Taxi(int vehicleX, int vehicleY, Direction valueOf) {

        super(vehicleX, vehicleY, valueOf);
        //Req of Collision behaviour is here in NoDays which is 15
        NoDays =15;
    }

       /**
      *   theTerrain, theLight of The Taxi must stop when the traffic light or CROSSWALK is RED.
      *      * @return    but, if the light of the CROSSWALK is GREEN, it returns travel.
      */

    // Req of C,D is here in the method ofcan pass
    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if (theTerrain == Terrain.CROSSWALK) {

            if (theLight == Light.RED) {
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
      * the Taxi prefer to travel in straight, if not, it travels left. If it cannot move left, it turns right.
      *  @return if it can't make all the above direction, return around/reverse
      */
// Req of A,B is here in the method of chooseDirection
    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {

        if ( theNeighbors.get(getDirection()) != Terrain.WALL
                && theNeighbors.get(getDirection()) != Terrain.GRASS
                && theNeighbors.get(getDirection()) != Terrain.TRAIL)

            return getDirection();

        if (theNeighbors.get(getDirection().right()) != Terrain.WALL
                && theNeighbors.get(getDirection().right()) != Terrain.GRASS
                && theNeighbors.get(getDirection().right()) != Terrain.LIGHT)
            return getDirection().right();

        if (theNeighbors.get(getDirection().left()) != Terrain.WALL
                && theNeighbors.get(getDirection().left()) != Terrain.GRASS
                && theNeighbors.get(getDirection().left()) != Terrain.LIGHT)
            return getDirection().left();

        else
            return getDirection().reverse();
    }
}
