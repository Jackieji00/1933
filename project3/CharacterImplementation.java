public class CharacterImplementation implements Character{
    private Weapon w;
    private Armor a;
    private Item[] inventory;
    // public CharacterImplementation(){
    // }
    public static boolean compareTo(Item v1, Item v2){
        //helpful method to help compare two item by its value-to-weight ratio
        return v1.getValueWeightRatio()< v2.getValueWeightRatio();

    }

    public Iterator<Item> inventory(){
        // bubble sort, sort item increasing
        for (int i = 0; i < n - 1; i++){
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++){
                if (compareTo(arr[j],arr[j + 1])){
                    //swap arr[j] and arr[j+1]
                    Item temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        //store each item in inventory into LinkedList, then convert to iterator
        LinkedList<Item> result = new LinkedList();
        for (Item element:this.inventory){
            result.addFirst(element);
        }
        return result.iterator();
    }

    public void addItem(Item itemTemplate){
        Item[] newArray = new Item[inventory.length+1];
        for (int i =0; i < newArray.length;i++){
            newArray[i] = inventory;
        }
        if(itemTemplate == null){
            throw NullPointerException;
        }else{
            if (itemTemplate instanceof Item){
                Item newItem = itemTemplate;
                newArray[newArray.length-1] = new Item(newItem.getName(),newItem.getGoldValue(),newItem.getWeight());
            }else if (itemTemplate instanceof Weapon){
                Weapon newItem = itemTemplate;
                newArray[newArray.length-1] = new Weapon(newItem.getName(),newItem.getGoldValue(),newItem.getWeight());
            }else if (itemTemplate instanceof Armer){
                Armer newItem = itemTemplate;
                newArray[newArray.length-1] = new Armor(newItem.getName(),newItem.getGoldValue(),newItem.getWeight());
            }
        }
        inventory = newArray;
    }
    public boolean equals(Item item1,Item item2){
        // helpful method to check if two item are same
        if(item1.getName() == item2.getName()){
            return true;
        }else{
            return false;
        }
    }
    public void dropItem(Item item){
        Item[] newArray = new Item[inventory.length-1];
        boolean exist = false;
        for(int i = 0; i < inventory.length;i++){
            if (!exist && i == inventory.length-1){
                break;
            }
            if (!inventory[i].equals(item)){
                newArray[i] = inventory[i];
            }else if (! exist && inventory[i].equals(item)){
                exist = true;
            }else if (exist&&inventory[i].equals(item)){
                newArray[i] = inventory[i];
            }
        }
        if (!exist){
            throw new ItemNotFoundException("item "+item.getName()+" cannot be found.")
        }

    }
    public double getTotalWeight(){};

    public Armor getEquippedArmor(int slot){};
    public int getTotalArmorRating(){};
    public void equipArmor(Armor armor){};
    public void unequipArmor(int slot){};

    public Weapon getEquippedWeapon(){};
    public void equipWeapon(Weapon weapon){};
    public void unequipWeapon(){};

    public void optimizeInventory(double maximumWeight){};
    public void optimizeEquipment(){};

}
