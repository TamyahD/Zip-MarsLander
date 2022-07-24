import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimulationTest {

    @Test
    public void runSimulationLanding() {
        int[] burns = {200, 200, 200, 200, 200, 200, 200, 200, 200,
                100, 100, 100, 100,
                150, 125, 120, 100, 100, 100, 103,
                100, 100, 100, 100};
/*
        int[] burns = {161, 161, 161, 161, 160, 160, 160, 160, 159,
                159, 158, 157, 155,
                153, 149, 143, 134, 124, 113, 106,
                103, 103, 99};
*/
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

    @Test
    public void runSimulationCrash() {
        int[] burns = {0,0,0,0,0};
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(Vehicle.DEAD, okay); //Vehicle.CRASH may need to change to Vehicle.DEAD
    }

    @Test
    public void runSimulationComputer() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(10000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

    @Test
    public void runSimulationComputerRandom() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(Simulation.randomaltitude()));
        //Simulation game = new Simulation(new Vehicle(15000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

}