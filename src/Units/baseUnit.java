package Units;
public abstract class baseUnit {
    protected String nameClass;
    protected double XP,Damage;
    protected int Armor,initiative;
    protected int unitposX=1,unitposY=1;
    protected boolean Active=true,Live;
    protected String Armyname = "";

    public abstract String toString(int a);
    public abstract String toString();
    public void setXP(int XP) {this.XP = XP;}
    public double getXP(){return XP;}

    public void setDamage(int damage) {Damage = damage;}
    public double getDamage() {return Damage;}

    public void setArmor(int armor) {Armor = armor;}
    public int getArmor() {return Armor;}

    public void setInitiative(int initiative) {this.initiative = initiative;}
    public int getInitiative() {return initiative;}

    public void setActive(boolean active) {Active = active;}
    public boolean getActive() {return Active;}

    public void setLive(boolean live) {this.Live = live;}
    public boolean getLive() {return Live;}

    public void setArmyname(String name){Armyname = name;}
    public String getArmyname(){return Armyname;}

    public void setUnitpos(int x,int y){unitposX=x;unitposY=y;}
    public int getUnitposX(){return unitposX;}
    public int getUnitposY(){return unitposY;}

    public void setNameClass(String s){nameClass=s;}
    public String getNameClass(){return nameClass;}
}
