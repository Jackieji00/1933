public class WeaponImplementation implements Armor{
    private int damage;
    public WeaponImplementation(int newDamage){
      damage = newDamage >=0 ? newDamage:0;
    }
    public int getDamage(){
        return damage;
    }
}
