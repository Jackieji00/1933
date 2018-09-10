public class ArmorImplementation implements Armor{
    private int slotID;
    private int rate;
    public ArmorImplementation(int newSlotID,int newRate){
        slotID = (newSlotID >= 0&&newSlotID<=5) ? newSlotID : 0;
        rate = newRate >=0 ? newRate:0;
    }
    public int getSlot(){
        return slotID;
    }
    public int getRating(){
        return rate;
    }
}
