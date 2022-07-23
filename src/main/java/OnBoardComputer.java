public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn =0;
        int velocity = status.Velocity;
        int altitude = status.Altitude;
        // README Hint: a = (speed * speed)/(2 * altitude)
        burn = (velocity * velocity) / (2 * altitude) +99;
        
        System.out.println(burn); /*hack!*/
        return burn;
    }

}
