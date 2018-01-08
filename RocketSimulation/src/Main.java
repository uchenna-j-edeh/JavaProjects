import java.util.ArrayList;

public class Main {

    public static long costOfRocket1() throws Exception{
        ArrayList<Rocket> u1Rockets = new ArrayList();
        U1 rock1 = new U1();

        Simulation sim = new Simulation();
        ArrayList<Item> phase1StuffOnBoard1 = sim.loadItems("Phase1ListOfItems.txt");
        ArrayList<Item> phase2StuffOnBoard1 = sim.loadItems("Phase2ListOfItems.txt");

        ArrayList<U1> ph1Rockets1 = sim.loadU1(phase1StuffOnBoard1);
        for (Rocket r1 : ph1Rockets1) {
            u1Rockets.add(r1);
        }

        ArrayList<U1> ph2Rockets1 = sim.loadU1(phase2StuffOnBoard1);
        for (Rocket r1 : ph2Rockets1) {
            u1Rockets.add(r1);
        }

        int totalPhlRock1 = sim.runSimulation(u1Rockets);
        long value = totalPhlRock1 * rock1.budget;
        return value;
    }

    public static long costOfRocket2() throws Exception{
        ArrayList<Rocket>  u2Rockets = new ArrayList();
        U2 rock2 = new U2();

        Simulation sim2 = new Simulation();
        ArrayList <Item> phase1StuffOnBoard2 = sim2.loadItems("Phase1ListOfItems.txt");
        ArrayList <Item> phase2StuffOnBoard2 = sim2.loadItems("Phase2ListOfItems.txt");

        ArrayList<U2> ph1Rockets2  = sim2.loadU2(phase1StuffOnBoard2);
        for(Rocket r1: ph1Rockets2){
            u2Rockets.add(r1);
        }

        ArrayList<U2> ph2Rockets2 = sim2.loadU2(phase2StuffOnBoard2);
        for(Rocket r2: ph2Rockets2){
            u2Rockets.add(r2);
        }

        int total = sim2.runSimulation(u2Rockets);
        long value = total * rock2.budget ;
        return value;
    }

    public static void main(String [] args) throws Exception{

        //Calculate cost of launching rocket 1
        long cost1 = costOfRocket1();
        System.out.println("U1 -> Total cost spent is: $" + cost1);

        //Calculate cost of launching rocket 2
        long cost2 = costOfRocket2();
        System.out.println("U2 -> Total cost spent is: $" + cost2);

    }
}
