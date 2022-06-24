package Units;

import java.util.Objects;

public class Ork extends baseUnit{
    protected int Rage;


    public Ork(String name,String nameArmy){
        switch (name){
            case "Melee"-> {
                setNameClass("Melee");
                setXP(100);
                setArmor(8);
                setDamage(20);
                setInitiative(3);
                setArmyname(nameArmy);
            }
            case "Archer" -> {
                setNameClass("Archer");
                setXP(60);
                setArmor(3);
                setDamage(15);
                setInitiative(4);
                setArmyname(nameArmy);
            }
            case "Goblin" -> {
                setNameClass("Goblin");
                setXP(40);
                setArmor(2);
                setDamage(50);
                setInitiative(9);
                setArmyname(nameArmy);
            }
            default -> {
                setXP(100);
                setArmor(8);
                setDamage(20);
                setInitiative(3);
                setArmyname(nameArmy);
            }
        }
        Rage=0;
    }


    @Override
    public double getDamage() {
        if (Rage>=10){return Damage*2;}
        return Damage+(Damage*(0.1)*Rage);
    }
    public void setRagePP(){Rage++;}
    public void setRage(int rage) {Rage = rage;}
    public int getRage(){return Rage;}
    @Override
    public String toString(int a) {
        String Red ="\033[0;31m",
                Blue="\033[0;34m",
                Reset="\033[0m";
        if (Objects.equals(nameClass, "Melee")&a==0) {
            return Red+" M "+Reset;
        } else if (Objects.equals(nameClass, "Melee")&a==1){return Blue+" M "+Reset;}

        if (Objects.equals(nameClass, "Archer")&a==0) {
            return Red+" A "+Reset;
        } else if (Objects.equals(nameClass, "Archer")&a==1){return Blue+" A "+Reset;}
        if (Objects.equals(nameClass, "Goblin")&a==0) {
            return Red+" G "+Reset;
        } else if (Objects.equals(nameClass, "Goblin")&a==1){return Blue+" G "+Reset;}

        return " + ";
    }
    @Override
    public String toString() {
        if (Objects.equals(nameClass, "Melee")) return " M ";
        if (Objects.equals(nameClass, "Archer")) return " A ";
        if (Objects.equals(nameClass, "Goblin")) return " G ";
        return " + ";
    }

}
