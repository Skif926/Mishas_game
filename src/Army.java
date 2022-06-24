import Units.*;
import java.util.Vector;

public class Army {
    //public Vector<Class<? extends baseUnit>> myArmy = new Vector();
    public Vector<baseUnit> myArmy = new Vector<>();


    public void addUnit(String nameArmy,String typeArmy, String Variety){
        switch (typeArmy){
            case "Ork" -> {
                myArmy.add(new Ork(Variety,nameArmy));
            }
        }
    }

    public baseUnit getUnit(int i){
        return myArmy.get(i);
    }

}
