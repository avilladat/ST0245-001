import java.util.ArrayList;
import java.util.LinkedList;

public class Quatree {
    private ReaderBees beesMinsAndMax;
    private final double cienMetrosEnGrados = 100 / 111325.2;
    

    public Quatree(ReaderBees beesMinsAndMax){
        this.beesMinsAndMax = beesMinsAndMax;
    }

    public void showBeesInCollision(){

        double[] minsAndMax = {beesMinsAndMax.getMinLat(), beesMinsAndMax.getMinLon(), beesMinsAndMax.getMinAlt(),
        beesMinsAndMax.getMaxLat(), beesMinsAndMax.getMaxLon(), beesMinsAndMax.getMaxAlt()};

        double[] origin = {0.0,0.0,0.0};
        collisions(beesMinsAndMax.getFirstQuatree(), beesMinsAndMax.getSecondQuatree(), 
        beesMinsAndMax.getThirdQuatree(), beesMinsAndMax.getFourthQuatree(), minsAndMax, origin);
    }

    public void collisions(LinkedList<Bee> firstQuatree, LinkedList<Bee> secondQuatree, 
        LinkedList<Bee> thirdQuatree, LinkedList<Bee> fourthQuatree, double[] minsAndMax, double[] origin){

            //División del primer cuadrante
            if (firstQuatree.size() > 1){
                double hipLatLon = Math.sqrt((Math.pow(minsAndMax[3] - origin[0], 2) + Math.pow(minsAndMax[4] - origin[1], 2)));
                hipLatLon *= 111325.2;
                double hipLatLonAlt = Math.sqrt(Math.pow(hipLatLon, 2) + Math.pow(minsAndMax[5] - origin[2], 2));
                if (hipLatLonAlt <= 100){
                    choque(firstQuatree);
                }
                else{
                    double[] newOrigin = {minsAndMax[3] / 2, minsAndMax[4] / 2, minsAndMax[5]};
                    Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> pareja = divide(firstQuatree, newOrigin);
                    ArrayList<LinkedList<Bee>> quatrees = pareja.first;
                    ArrayList<Double> newMinsAndMaxArray = pareja.second;
                    double[] newMinsAndMax = {newMinsAndMaxArray.get(0), newMinsAndMaxArray.get(1), newMinsAndMaxArray.get(2), 
                        newMinsAndMaxArray.get(3), newMinsAndMaxArray.get(4), newMinsAndMaxArray.get(5)};

                    collisions(quatrees.get(0), quatrees.get(1), quatrees.get(2), 
                    quatrees.get(3), newMinsAndMax, newOrigin);
                }
            }
            //División del segundo cuadrante
            if (secondQuatree.size() > 1){
                double hipLatLon = Math.sqrt((Math.pow(minsAndMax[0] - origin[0], 2) + Math.pow(minsAndMax[4] - origin[1], 2)));
                hipLatLon *= 111325.2;
                double hipLatLonAlt = Math.sqrt(Math.pow(hipLatLon, 2) + Math.pow(minsAndMax[5] - origin[2], 2));
                if (hipLatLonAlt <= 100){
                    choque(secondQuatree);
                }
                else{
                    double[] newOrigin = {minsAndMax[0] / 2, minsAndMax[4] / 2, minsAndMax[5]};
                    Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> pareja = divide(secondQuatree, newOrigin);
                    ArrayList<LinkedList<Bee>> quatrees = pareja.first;
                    ArrayList<Double> newMinsAndMaxArray = pareja.second;
                    System.out.println(newMinsAndMaxArray);
                    double[] newMinsAndMax = {newMinsAndMaxArray.get(0), newMinsAndMaxArray.get(1), newMinsAndMaxArray.get(2), 
                        newMinsAndMaxArray.get(3), newMinsAndMaxArray.get(4), newMinsAndMaxArray.get(5)};

                    collisions(quatrees.get(0), quatrees.get(1), quatrees.get(2), 
                    quatrees.get(3), newMinsAndMax, newOrigin);
                }
            }
            //División del tercer cuadrante
            if (thirdQuatree.size() > 1){
                double hipLatLon = Math.sqrt((Math.pow(minsAndMax[0] - origin[0], 2) + Math.pow(minsAndMax[1] - origin[1], 2)));
                hipLatLon *= 111325.2;
                double hipLatLonAlt = Math.sqrt(Math.pow(hipLatLon, 2) + Math.pow(minsAndMax[5] - origin[2], 2));
                if (hipLatLonAlt <= 100){
                    choque(thirdQuatree);
                }
                else{
                    double[] newOrigin = {minsAndMax[0] / 2, minsAndMax[1] / 2, minsAndMax[5]};
                    Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> pareja = divide(thirdQuatree, newOrigin);
                    ArrayList<LinkedList<Bee>> quatrees = pareja.first;
                    ArrayList<Double> newMinsAndMaxArray = pareja.second;
                    double[] newMinsAndMax = {newMinsAndMaxArray.get(0), newMinsAndMaxArray.get(1), newMinsAndMaxArray.get(2), 
                        newMinsAndMaxArray.get(3), newMinsAndMaxArray.get(4), newMinsAndMaxArray.get(5)};

                    collisions(quatrees.get(0), quatrees.get(1), quatrees.get(2), 
                    quatrees.get(3), newMinsAndMax, newOrigin);
                }
            }
            //División del cuarto cuadrante
            if (fourthQuatree.size() > 1){
                double hipLatLon = Math.sqrt((Math.pow(minsAndMax[3] - origin[0], 2) + Math.pow(minsAndMax[1] - origin[1], 2)));
                hipLatLon *= 111325.2;
                double hipLatLonAlt = Math.sqrt(Math.pow(hipLatLon, 2) + Math.pow(minsAndMax[5] - origin[2], 2));
                if (hipLatLonAlt <= 100){
                    choque(fourthQuatree);
                }
                else{
                    double[] newOrigin = {minsAndMax[3] / 2, minsAndMax[1] / 2, minsAndMax[5]};
                    Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> pareja = divide(fourthQuatree, newOrigin);
                    ArrayList<LinkedList<Bee>> quatrees = pareja.first;
                    ArrayList<Double> newMinsAndMaxArray = pareja.second;
                    double[] newMinsAndMax = {newMinsAndMaxArray.get(0), newMinsAndMaxArray.get(1), newMinsAndMaxArray.get(2), 
                        newMinsAndMaxArray.get(3), newMinsAndMaxArray.get(4), newMinsAndMaxArray.get(5)};

                    collisions(quatrees.get(0), quatrees.get(1), quatrees.get(2), 
                    quatrees.get(3), newMinsAndMax, newOrigin);
                }
            }
    }

    public Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> divide(LinkedList<Bee> bees, double[] origin){
        ArrayList<LinkedList<Bee>> newQuatrees = new ArrayList<>(4);
        LinkedList<Bee> firstQuatree = new LinkedList<>();
        LinkedList<Bee> secondQuatree = new LinkedList<>();
        LinkedList<Bee> thirdQuatree = new LinkedList<>();
        LinkedList<Bee> fourthQuatree = new LinkedList<>();
        double minLat = Double.POSITIVE_INFINITY, minLon = Double.POSITIVE_INFINITY, minAlt = Double.POSITIVE_INFINITY, 
                                            maxLat = Double.NEGATIVE_INFINITY, maxLon = Double.NEGATIVE_INFINITY, maxAlt = Double.NEGATIVE_INFINITY;
        int cont = 0;
        for(Bee bee: bees){
            if (bee.getLatitud() >= -1*cienMetrosEnGrados - origin[0]){                                         //NO ESTOY SEGURO DE ESTOS IF
                if (bee.getLongitud() >= -1*cienMetrosEnGrados + origin[1]){
                    firstQuatree.addLast(bee);
                }
                if (bee.getLongitud() <= cienMetrosEnGrados + origin[1]){
                    fourthQuatree.addLast(bee);
                }
            }
            if (bee.getLatitud() <= cienMetrosEnGrados + origin[0]){
                if (bee.getLongitud() >= -1*cienMetrosEnGrados + origin[1]){
                    secondQuatree.addLast(bee);
                }
                if(bee.getLongitud() <= cienMetrosEnGrados + origin[1]){
                    thirdQuatree.addLast(bee);
                }
            }

            if (cont == 0) {
                minLat = bee.getLatitud();
                minLon = bee.getLongitud();
                minAlt = bee.getAltura();
                maxLat = bee.getLatitud();
                maxLon = bee.getLongitud();
                maxAlt = bee.getAltura();
            } else {
                if (bee.getLatitud() < minLat) {
                    minLat = bee.getLatitud();
                }
                if (bee.getLongitud() < minLon) {
                    minLon = bee.getLongitud();
                }
                if (bee.getAltura() < minAlt) {
                    minAlt = bee.getAltura();
                }

                if (bee.getLatitud() > maxLat) {
                    maxLat = bee.getLatitud();
                }
                if (bee.getLongitud() > maxLon) {
                    maxLon = bee.getLongitud();
                }
                if (bee.getAltura() > maxAlt) {
                    maxAlt = bee.getAltura();
                }
            }
            cont++;
        }
        ArrayList<Double> minsAndMax = new ArrayList<>(6);
        minsAndMax.add(minLat);
        minsAndMax.add(minLon);
        minsAndMax.add(minAlt);
        minsAndMax.add(maxLat);
        minsAndMax.add(maxLon);
        minsAndMax.add(maxAlt);

        newQuatrees.add(firstQuatree);
        newQuatrees.add(secondQuatree);
        newQuatrees.add(thirdQuatree);
        newQuatrees.add(fourthQuatree);
        
        Pair<ArrayList<LinkedList<Bee>>, ArrayList<Double>> pareja = new Pair<>(newQuatrees, minsAndMax);
        return pareja;
    }

    public LinkedList<Bee> nuevasAbejas(LinkedList<Bee> bees, double[] newOrigin){
        LinkedList<Bee> newBees = new LinkedList<>();
        for (Bee b: bees){
            newBees.addLast(new Bee(b.getLatitud() - newOrigin[0], b.getLongitud() - newOrigin[1], b.getAltura()));
        }
        return newBees;
    }

    public void choque(LinkedList<Bee> bees){
        while (!bees.isEmpty()){
            System.out.println(bees.peek().getLatitud() + ", " + bees.peek().getLongitud() + ", " + bees.peek().getAltura());
            bees.poll();
        }
    }
}
