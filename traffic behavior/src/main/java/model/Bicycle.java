package model;

import java.util.Map;

public class Bicycle extends abstractVehicle {

    public Bicycle(int vehicleX, int vehicleY, Direction valueOf) {

        super(vehicleX, vehicleY, valueOf);
//Req of Collision behaviour is here in NoDays which is 35
        NoDays = 35;
        }

    /**
     * @param theTerrain, theLight of The Car must stop when the traffic light or CROSSWALK is RED or YELLOW.
     * @return    but, if the light of the CROSSWALK is GREEN, it returns travel.
     */
//Req of E,F is here in the method of canPass.
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
            if (theLight == Light.YELLOW) {
                return false;
            }
        }
        return true;
    }

    /**
     * the bicycle prefer to travel in TRAIL, if not, it travels straight. If it cannot move straight ahead, it turns left.
     * if it cannot turn left, it turns right.
     * @return if it can't make all the above direction, return around/reverse
     */
    //Req of A,B,C D is here in the method of chooseDirection

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {

    Direction[] d = {getDirection(), getDirection().left(), getDirection().right()};
        for (Direction getDirection : d) {
                if (theNeighbors.get(getDirection).equals(Terrain.TRAIL)){
                return getDirection;
                }
                }
                for (Direction getDirection : d) {
                if (theNeighbors.get(getDirection)==Terrain.STREET
                || theNeighbors.get(getDirection)==Terrain.CROSSWALK
                || theNeighbors.get(getDirection)==Terrain.LIGHT) {
                return getDirection;
                }
                }
                return getDirection().reverse();
                }
                }
