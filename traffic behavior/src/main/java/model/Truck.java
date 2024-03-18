package model;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Truck extends abstractVehicle {
    //method
    public Truck(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);
//Req of Collision behaviour is here in NoDays which is 0
        super.NoDays=0;
    }
    /**
     *   theTerrain, theLight of The Truck travel without stopping in the traffic light, but it will stop when the CROSSWALK light is RED.
     *      * @return    but, if the light of the CROSSWALK is GREEN/YELLOW, it returns randomly.
     */

    // Req of A,C,D is here in the method of canPass
    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        /////.

        if (theTerrain == Terrain.CROSSWALK) {
            if (theLight == Light.RED) {
                return false;
            }
        }
        return true;
    }
    /**
     *      the Truck travel randomly whether left, straight, or straight
     *       @return if it can't make all the above direction, return around/reverse
     *
     */
// Req of A,B is here in the method of chooseDirection
        @Override
        public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
            ArrayList<Direction> hi = new ArrayList<Direction>();

            if (theNeighbors.get(getDirection().right()) != Terrain.WALL
                    && theNeighbors.get(getDirection().right()) != Terrain.TRAIL
                    && theNeighbors.get(getDirection().right()) != Terrain.GRASS) {

                hi.add(getDirection().right());
            }
            if (theNeighbors.get(getDirection().left()) != Terrain.WALL
                    && theNeighbors.get(getDirection().left()) != Terrain.TRAIL
                    && theNeighbors.get(getDirection().left()) != Terrain.GRASS) {
                hi.add(getDirection().left());
            }
            if (theNeighbors.get(getDirection()) != Terrain.WALL
                    && theNeighbors.get(getDirection()) != Terrain.TRAIL
                    && theNeighbors.get(getDirection()) != Terrain.GRASS) {

                hi.add(getDirection());
            }

            if (hi.isEmpty())
                return getDirection().reverse();

            Random random = new Random();
            int r = random.nextInt();
            r = r % hi.size();
            r = Math.abs((r));
            return hi.get(r);
        }
    }
