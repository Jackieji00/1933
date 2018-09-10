import java.util.Scanner;
public class test{
  public static void main(String[] args) {
    int m,n,w,h;
    int turn =1;
    int cannonshot = 0;
    String s1,d,x,y;
    String result;
    boolean debug;

    System.out.println("--------------------");
    System.out.println("Welcome to Battleboat!");
    Scanner scan = new Scanner(System.in);
    System.out.println("Please types in the board size you want:");
    do{
      System.out.print("width(between 3-12): ");
      m = scan.nextInt();
      System.out.print("height(between 3-12): ");
      n = scan.nextInt();
    }while(m>12||m<3||n>12||n<3);
    BattleboatsBoard game = new BattleboatsBoard(m,n);
    System.out.print("Do you want debug mode(true or false): ");
    d = scan.next();
    if(d.equalsIgnoreCase("true")||d.equalsIgnoreCase("false")){
      debug = Boolean.parseBoolean(d);
    }else{
      do{
        System.out.print("Do you want debug mode(true or false): ");
        d = scan.next();
      }while(!d.equalsIgnoreCase("true")&&!d.equalsIgnoreCase("false"));
    }
    debug = Boolean.parseBoolean(d);
    game.boatsGenerator(debug);
    while(true){
        System.out.println("\nturn "+turn);
        game.show();
      do{
        System.out.print("Please types in method you want (cannon or drone):");
        s1 = scan.next();
      }while(!s1.equalsIgnoreCase("cannon")&&!s1.equalsIgnoreCase("drone"));
      do{
        System.out.print("Please types in location: x:  ");
        x= scan.next();
      }while(!isInteger(x));
      do{
        System.out.print("y: ");
        y= scan.next();
      }while(!isInteger(y));
      w = Integer.valueOf(x);
      h = Integer.valueOf(y);
      if (s1.equalsIgnoreCase("cannon")){
        cannonshot++;
        result = game.hit(w,h);
        System.out.println(result);
        if(result.equals("penalty")){
          turn++;
          System.out.println("turn: "+turn+" skipped");
        }
      }else if (s1.equalsIgnoreCase("drone")){
        game.drone(w,h);
        game.show();
        if(m>12||m<3||n>12||n<3){
          turn+= 4;
        }else{
        turn+=3;
        }
        System.out.println("turn: "+Integer.toString(turn-3)+"-"+turn+" skipped");
      }
      if(game.endGame()){
        break;
      }
      turn++;
    }
    System.out.println("--------------------");
    System.out.println("total turn: "+turn);
    System.out.println("total cannon shots: "+cannonshot);
  }
  public static boolean isInteger(String num){
    boolean vaildint;
    try{
     Integer.parseInt(num);
     vaildint = true;
    }catch (NumberFormatException ex){
      vaildint =false;
    }
    return vaildint;
  }
}
