package model;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;

public class Atv extends abstractVehicle {

    /**
     * @param vehicleX this Vehicle object's x-coordinate.
     * @param vehicleY this Vehicle object's y-coordinate.
     * @param valueOf this Vehicle object's Direction.
     *
     */
    public Atv(int vehicleX, int vehicleY, Direction valueOf) {
        //polymorphism
        super(vehicleX, vehicleY, valueOf);
        //Req of Collision behaviour is here in NoDays which is 35
        NoDays=25;
    }

    /**
     * The Atv can travel through all traffic lights, so that it returns true
     */
// Req of D is here in the method of canPas
    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
            return true;
    }

    /**
     * @param theNeighbors Atv can travel on any terrain except the walls.
     * @return So, it randomly goes straight, left or right.
     */
    // Req of A,B,C  is here in the method of chooseDirection
    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        ArrayList<Direction> d=new ArrayList<>();

        if ( theNeighbors.get(getDirection().right()) != Terrain.WALL) {
            d.add(getDirection().right());
        }
         if (theNeighbors.get(getDirection().left()) != Terrain.WALL) {
             d.add (getDirection().left());
         }
        if (theNeighbors.get(getDirection()) != Terrain.WALL) {
            d.add (getDirection());
        }

        Random random = new Random();
        int r = random.nextInt();
        r = r % d.size();
        r=Math.abs((r));
        return d.get(r);
    }
}
