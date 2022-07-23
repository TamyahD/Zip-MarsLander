public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int v = status.Velocity;
        int a = status.Altitude;
        int burn = (v * v) / (2 * a) + 99;
        
        System.out.println(burn); /*hack!*/
        return burn;
    }

}
