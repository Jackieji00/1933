public class part6
{
  public static void main(String[] args)
  {
    String number = args[0].substring(1);
    String firstHalf = number.substring(0,number.length()-2);
    System.out.println(number+','+args[0]+','+firstHalf);
    // String last = totoal[1];
    String result = "";
    double num = Double.parseDouble(number);
    System.out.println(num);
    int len = number.length()-3;
    // for(int i : num){
    //   if (len <= 2){
    //     break;
    //   }
    //   result += transfer(i);
    //   if (len == 7){
    //     result+= "million ";
    //   } else if (len == 4){
    //     result += "thousand ";
    //   } else if (len == 3){
    //     result += "hundred";
    //     break;
    //   }
    //   len -= 1;
    // }

  }
  public static String transfer(int a) {
    if (a == 0) {

    } else if (a == 1){
      return "one ";
    } else if (a == 2){
      return "two ";
    } else if (a == 3){
     return "three ";
   } else if (a == 4){
     return "four ";
   } else if (a == 5){
     return "five ";
   } else if (a == 6){
     return "six ";
   } else if (a == 7){
     return "sevne ";
   } else if (a == 8){
     return "eight ";
   } else if (a == 9){
     return "nine ";
   }
  return "";
  }
}
