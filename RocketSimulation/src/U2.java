public class U2 extends Rocket {
    public static int budget = 120; //$120 Million
    public static int maxWeight = 29000;
    public static int rockWeight = 18000;
    public static int cargoLimit = maxWeight - rockWeight ;
    public  int weightOfCargo = 0;

    public boolean land(){
        double randDouble = Math.random() * 8 + 1; //weight the random number same with probality of explosion
        double chanceOfExplo = 8 * weightOfCargo / (double) cargoLimit;
        return  chanceOfExplo <= randDouble;
    }

    public boolean launch(){
        double randDouble = Math.random() * 4 + 1; //weight the random number same with probality of explosion
        double chanceOfExplo = 4 * randDouble / (double) cargoLimit;
        return  chanceOfExplo <= randDouble;
    }
    
}
