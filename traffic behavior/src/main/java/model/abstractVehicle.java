package model;

public abstract class abstractVehicle implements Vehicle {
    public int startX;
    public int startY;
    private int theX;
    private int theY;
    private Direction theDir;
    protected int NoDays;
    private int DeathTime;
    private Boolean isAlive = true;
    ///constructs of abstract vehicle
    public abstractVehicle(int vehicleX, int vehicleY, Direction valueOf) {
  theX=vehicleX;
  theY=vehicleY;
  theDir=valueOf;
        startX = vehicleX;
        startY = vehicleY;
    }
    /**
     *  The other object. when the any vehicle collide with another vehicle
     */
    @Override
    public void collide(Vehicle theOther) {
        if (NoDays > theOther.getDeathTime()) {
            isAlive = false;
            getImageFileName();
        }
    }

    /**
     * @return the number of updates between this vehicle's death
     */
       @Override
    public int getDeathTime() {
        return NoDays;
    }

    /**
     * @return the file name of the image for this Vehicle object
     */
    @Override
    public String getImageFileName() {
        return getClass().getSimpleName().toLowerCase() + (isAlive ? ".gif" : "_dead.gif");
    }

    /**
     * @return this Vehicle object's direction
     */
    @Override
    public Direction getDirection() {

       return theDir;
    }

    /**
     * @return this Vehicle object's y-coordinate.
     */
    @Override
    public int getX() {
        return theX;
    }

    /**
     * @return the Vehicle object's y-coordinate.
     */
    @Override
    public int getY() {
        return theY;
    }

    /**
     * @return  whether this Vehicle object is alive and should move on the map.
     *    true if the object is alive, false otherwise.
     */
    @Override
    public boolean isAlive() {
        return isAlive;
    }

    /**
     *  dead vehicle that 1 movement round has passed, so that it will become 1 move closer to revival.
     */
    @Override
    public void poke() {
        if (!this.isAlive() && this.DeathTime < NoDays) {
            DeathTime++;
        } else {
            isAlive = true;
            DeathTime= 0;
        }
    }

    /**
     * Moves the vehicle back to its original position
     */
    @Override
    public void reset() {
        theX = startX;
        theY = startY;
        isAlive = true;
    }

    /**
     * @param theDir The new direction. Sets this object's facing direction to the given value
     */
    @Override
    public void setDirection(Direction theDir) {
        this.theDir = theDir;
    }

    /**
     * @param theX The new x-coordinate. Sets this object's x-coordinate to the given value.
     */
    @Override
    public void setX(int theX) {

        this.theX=theX;

    }

    /**
     * @param theY The new y-coordinate. Sets this object's y-coordinate to the given value.
     */
    @Override
    public void setY(int theY) {
        this.theY=theY;
    }
}
