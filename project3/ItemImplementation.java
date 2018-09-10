public class ItemImplementation implements Item{
    private String name;
    private int goldValue;
    private double weight;
    public ItemImplementation(String newName,int newGoldValue,double newWeight){
       this.name = newName == null ? " " :newName;
       this.goldValue = newGoldValue >= 0 ? newGoldValue: 0;
       this.weight = newWeight >= 0 ? newWeight : 0;
    }
    public String getName(){
        return name;
    }
    public int getGoldValue(){
        return goldValue;
    }
    public double getWeight(){
        return weight;
    }
    public double getValueWeightRatio(){
        return goldValue/weight;
    }
}
