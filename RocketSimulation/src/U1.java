public class U1 extends Rocket {

    public static int budget = 100; //$100 Million
    public static int maxWeight = 18000;
    public static int rockWeight = 10000;
    public static int cargoLimit = 8000 ;
    public int weightOfCargo = 0;

    public boolean land(){
        double randDouble = Math.random() + 1;
        double chanceOfExplo = 1 * (weightOfCargo / (double)cargoLimit);  // Change of exploding changed to from 1% to 40%
//        System.out.println("land" + chanceOfExplo);
        return  chanceOfExplo <= randDouble;
    }

    public boolean launch(){
        double randDouble = Math.random() * 5 + 1;
        double chanceOfExplo = 5 * (weightOfCargo / (double)cargoLimit);
//        System.out.println("launch " + chanceOfExplo);
        return  chanceOfExplo <= randDouble;
    }
}
