import java.io.File;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Simulation {

    public ArrayList <Item> loadItems (String pathName) throws Exception{
        ArrayList <Item> stuffOnBoard = new ArrayList<Item>();
        File file = new File (pathName);
        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String [] data = line.split("=");
            Item item = new Item();
            item.name = data[0];
            item.weight = Integer.parseInt(data[1]);
            stuffOnBoard.add(item);
        }
        return stuffOnBoard;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) throws Exception{
        ArrayList<U1> result = new ArrayList<U1>();

        U1 rock1 = new U1();
        int total = 0;

        for (Item item : items){
            total += item.weight;
            if (total <= rock1.cargoLimit){
                rock1.weightOfCargo += item.weight;
            }else{
                result.add(rock1);
                rock1 = new  U1();
                rock1.weightOfCargo += item.weight;
                total = item.weight;
            }
        }

        return result;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) throws Exception{
        ArrayList<U2> result = new ArrayList<U2>();

        U2 rock2 = new U2();
        int total = 0;

        for (Item item : items){
            total += item.weight;
            if (total <= rock2.cargoLimit){
                rock2.weightOfCargo += item.weight;
            }else{
                result.add(rock2);
                rock2 = new  U2();
                rock2.weightOfCargo += item.weight;
                total = item.weight;
            }
        }

        return result;
    }

    public int runSimulation(ArrayList<Rocket> rockets) throws Exception{
//        ArrayList<Rocket> rockets = new ArrayList<Rocket>();

        int totalRockets = 0;
        for (Rocket rocket: rockets){

            boolean  launchStatus = rocket.launch();
            boolean  landStatus = rocket.land();
            totalRockets++;
            while (!(landStatus && launchStatus)){
                launchStatus = rocket.launch();
                landStatus = rocket.land();
                totalRockets++;
            }
        }

        return totalRockets;
    }
}
