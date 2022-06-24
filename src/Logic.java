import Units.Ork;
import Units.baseUnit;

import java.util.Objects;
import java.util.Random;

public class Logic {
    Logic(String armyname1,String armyname2){Armyname1=armyname1;Armyname2=armyname2;}
    String Armyname1,Armyname2;
    Army armyA = new Army();
    Army armyB = new Army();
    Random rd = new Random();
    Battleground battle = new Battleground();

    public void addUnittoArmy(){
        armyA.addUnit(Armyname1,"Ork","Archer");
        armyA.addUnit(Armyname1,"Ork","Melee");
        armyA.addUnit(Armyname1,"Ork","Goblin");
        armyA.addUnit(Armyname1,"Ork","Goblin");
        armyB.addUnit(Armyname2,"Ork","Melee");
        armyB.addUnit(Armyname2,"Ork","Melee");
        armyB.addUnit(Armyname2,"Ork","Goblin");
    }
    public baseUnit maxInitiativeUnit(){
        int id = 0,id_2 = 0,InitiativeA = 0,InitiativeB=0;
    for (int i =0; i<armyA.myArmy.size();i++){
        for (int j=0; j<armyB.myArmy.size();j++){
            if(armyA.getUnit(i).getActive()&armyB.getUnit(j).getActive()){
                if (armyA.getUnit(i).getInitiative()>=armyB.getUnit(j).getInitiative()){
                    if(InitiativeA<armyA.getUnit(i).getInitiative()){
                        InitiativeA=armyA.getUnit(i).getInitiative();
                        id=i;
                    }
                } else {
                    if(InitiativeB<armyB.getUnit(j).getInitiative()){
                        InitiativeB=armyB.getUnit(j).getInitiative();
                        id_2=j;
                    }
                }
            } else if (armyA.getUnit(i).getActive()){
                if(InitiativeA<armyA.getUnit(i).getInitiative()){
                    InitiativeA=armyA.getUnit(i).getInitiative();
                    id=i;
                }
            } else if (armyB.getUnit(j).getActive()){
                if(InitiativeB<armyB.getUnit(j).getInitiative()){
                    InitiativeB=armyB.getUnit(j).getInitiative();
                    id_2=j;
                }
            }
        }
    }
    if ((InitiativeA==InitiativeB)&(InitiativeB==0)){
        return new Ork("","Zero");
    }
    if (InitiativeA==InitiativeB){
        if (rd.nextInt(2)==0){return armyA.getUnit(id);}
        return armyB.getUnit(id_2);
    }
    if (InitiativeA>InitiativeB){
        return armyA.getUnit(id);
    } else {return armyB.getUnit(id_2);}
    }

    public void replace(Army A){

    for (int i=0;i<A.myArmy.size();i++){
        //A.getUnit(i).setUnitpos(1+i,1);
        battle.reIns(A.getUnit(i));
    }

    }
    public void replace(Army A,Army B){
        for (int i=0;i<A.myArmy.size();i++){
            //A.getUnit(i).setUnitpos(1+i,1);
            battle.reIns(A.getUnit(i));
        }
        for (int i=0;i<B.myArmy.size();i++){
            //B.getUnit(i).setUnitpos(1+i, battle.sizeY);
            battle.reIns(B.getUnit(i));
        }
    }
    public void move(String s,baseUnit a){
        switch (s){
            case "r"->{a.setUnitpos(a.getUnitposX()+1,a.getUnitposY());}
            case "l"->{a.setUnitpos(a.getUnitposX()-1,a.getUnitposY());}
            case "u"->{a.setUnitpos(a.getUnitposX(),a.getUnitposY()-1);}
            case "d"->{a.setUnitpos(a.getUnitposX(),a.getUnitposY()+1);}
            case "ur"->{a.setUnitpos(a.getUnitposX()+1,a.getUnitposY()-1);}
            case "ul"->{a.setUnitpos(a.getUnitposX()-1,a.getUnitposY()-1);}
            case "dr"->{a.setUnitpos(a.getUnitposX()+1,a.getUnitposY()+1);}
            case "dl"->{a.setUnitpos(a.getUnitposX()-1,a.getUnitposY()+1);}
        }
    }
    public void round(){

    }
    public void Startbattle(){
        addUnittoArmy();
        battle.Ins(Math.max(armyA.myArmy.size(), armyB.myArmy.size()), 9);
        battle.setArmyname(Armyname1,Armyname2);
        for (int i=0;i<armyA.myArmy.size();i++){
            armyA.getUnit(i).setUnitpos(1+i,1);
        }
        for (int i=0;i<armyB.myArmy.size();i++){
            armyB.getUnit(i).setUnitpos(1+i,battle.sizeY);
        }
           // System.out.println();
        battle.clear();
        move("d",armyA.getUnit(0));
        replace(armyA,armyB);
        battle.Paint();
        battle.clear();
        move("d",armyA.getUnit(0));
        replace(armyA,armyB);
        battle.Paint();
        baseUnit max = maxInitiativeUnit();
        if (Objects.equals(max.getArmyname(), "Zero")){return;}
        System.out.println(max.getInitiative());
        System.out.println(max.getArmyname());

    }
}
