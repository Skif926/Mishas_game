import Units.baseUnit;

import java.util.Objects;

public class Battleground {
    public Battleground(){}
    int sizeX=5,
        sizeY=5;
    String Armyname1="",Armyname2="";
    String[][] field;
    String  Red = "\033[0;31m",
            Blue = "\033[0;34m",
            Reset = "\033[0m";
    public void setArmyname(String a,String b){Armyname1=a;Armyname2=b;}
    public void Paint(){
        System.out.println(Red+Armyname1+Reset);
        for (int i=0;i<sizeY+2;i++) {
            for (int j = 0; j < sizeX + 2; j++) {
                System.out.print(field[j][i]);
            }
            System.out.println();
        }
        System.out.println(Blue+Armyname2+Reset);
    }
    public void Ins(int x,int y){
        sizeX=x;
        sizeY=y;
        Ins();
    }
    public void Ins(){
        field = new String[sizeX+2][sizeY+2];
        for (int i=0;i<sizeY+2;i++){
            field[0][i]=" | ";
            field[sizeX+1][i]=" | ";
        }
        for (int i=0;i<sizeX+2;i++){
            field[i][0]=" - ";
            field[i][sizeY+1]=" - ";
        }
        for (int i=1;i<sizeX+1;i++){
            for (int j=1;j<sizeY+1;j++){
                field[i][j]="   ";
            }
        }
    }
    public void reIns(baseUnit a){
        int i=0;
        if (Objects.equals(a.getArmyname(), Armyname1)){i=0;}else {i=1;}

        field[a.getUnitposX()][a.getUnitposY()]=a.toString(i);
    }
    public void clear(){
        for (int i=1;i<sizeX+1;i++){
            for (int j=1;j<sizeY+1;j++){
                field[i][j]="   ";
            }
        }
    }
}
