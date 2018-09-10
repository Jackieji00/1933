public class BattleboatsBoard{
  private int[][] board;
  private int m;
  private int n;
  private int numBoats;
  private int[][] hitten;
  private int[][] userSee;
  private boolean debug;

  public BattleboatsBoard(int newM, int newN){
    //generate the board
    if(newN>=3 && newM>=3 && newN <=12 & newM<=12){
      this.m = newM;
      this.n = newN;
      board = new int[m][n];
      hitten= new int[m][n];
      userSee = new int[m][n];
    }
  }

  public void quantityBoats(){
    //calculate how many boats in the board
    if(m==3f||n==3){
      numBoats = 1;
    }else if((m<=5&&m>3)||(n<=5&&n>3)){
      numBoats = 2;
    }else if ((m<=7&&m>5)||(n<=7&&n>5)){
      numBoats = 3;
    }else if ((m<=9&&m>7)||(n<=9&&n>7)){
      numBoats = 4;
    }else if ((m<=12&&m>9)||(n<=12&&n>9)){
      numBoats = 6;
    }
  }

  public void boatsGenerator(boolean d){
    //how many boats need to be generated
    quantityBoats();
    int num = numBoats;
    int im,in;
    this.debug = d;
    while(num!=0){
      do{
        //generate the ship's position
        im = (int)Math.floor(12*Math.random());
        in = (int)Math.floor(12*Math.random());
      }while(im >=m || in >=n || board[im][in]!=0);
      //mark the ship on board
      board[im][in] = num;
      int r = (int)Math.floor(2*Math.random());
      if (r == 1){
        //the ship is vertical
        try{
          board[im][in+1] = num;
          board[im][in+2] = num;
        }catch(IndexOutOfBoundsException e){
          //if index out of bound, then change everything back and re-generate the boat
          board[im][in] = 0;
          if(in+1<m){
            board[im][in+1] = 0;
          }
          num++;
        }
      }else{
        //the ship is horizontal
        try{
          board[im+1][in] = num;
          board[im+2][in] = num;
        }catch(IndexOutOfBoundsException e){
          //if index out of bound, then change everything back and re-generate the boat
          board[im][in] = 0;
          if(im+1<m){
            board[im+1][in] = 0;
          }
          num++;
        }
      }
      num--;
    }
  }
  public boolean boatSunk(int w, int h){
    //check if it is the last hit
    int boatmark = board[w][h];
    int hits =0;
    for(int i = 0; i<m; i++){
      for(int j = 0; j<n;j++){
        if(hits ==2){
          break;
        }
        if (board[i][j]==boatmark&&hitten[i][j]==1){
          //if the ship part is same boat as the location and this part has been hitten
          hits++;
        }
      }
    }
    if(hits ==2){
      numBoats --;
      return true;
    }else{
      return false;
    }
  }
  public String hit(int w,int h){
    try{
      //check if user has attecked this place
      if(hitten[w][h]==0){
        if(board[w][h]!=0){
          // check if there is a ship
          if (boatSunk(w,h)){
            //mark this place
            this.hitten[w][h] = 1;
            return "sunk";
          }else{
            //mark this place
            this.hitten[w][h] = 1;
            return "hit";
          }
        }else{
          this.hitten[w][h] = 1;
          return "miss";
        }
      }else{
        return "penalty";
      }
    }catch(IndexOutOfBoundsException e){
      return "penalty";
    }
  }
  public void drone(int w,int h){
    if(w<0||w>m||h<0||h>n){
      //check if out of bound
    }else{
      for(int i = w-1; i<=w+1; i++){
        for(int j = h-1; j<=h+1;j++){
          try{
              userSee[i][j] = board[i][j];
              // System.out.println(i+" "+j);
          }catch(IndexOutOfBoundsException e){
          }
        }
      }
    }
  }
  public boolean endGame(){
    if (numBoats ==0){
      return true;
    }
    return false;
  }
  public void show(){
    System.out.println("this is a ship map");
    System.out.println("b stands for boats");
    System.out.println("~ stands for unknown");
    for(int i =0;i<this.m;i++){
      if(debug){
        for(int element:board[i]){
          if(element !=0 && element!=-1){
            System.out.print("b ");
          }else if (element == -1){
            System.out.println("x ");
          }else{
            System.out.print("~ ");
          }
        }
      }else{
        for(int element:userSee[i]){
          if(element !=0 && element!=-1){
            System.out.print("b ");
          }else if (element == -1){
            System.out.println("x ");
          }else{
            System.out.print("~ ");
          }
        }
      }
      System.out.print("\n");
    }
    System.out.println("this is a map that show which part has hitten");
    System.out.println("o stands for part has not been hit");
    System.out.println("x stands for part has been hitten");
    for(int j =0;j<this.m;j++){
        for(int el:hitten[j]){
          if (el == 0){
            System.out.print("o ");
          }else{
            System.out.print("x ");
          }
        }
        System.out.print("\n");
      }
  }
  public static void main(String[] args) {

  }
}
