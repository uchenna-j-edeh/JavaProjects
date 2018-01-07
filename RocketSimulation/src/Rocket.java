public class Rocket implements SpaceShip{

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean carry(Item item) {
        return false;
    }

    public boolean canCarry(Item item) {
        return false;
    }

}
