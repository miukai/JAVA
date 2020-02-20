import java.util.Scanner;
import java.util.Random;
class HighLowgame{
  public static void main(String...args){
    Title title = new Title();
    Mondai mondai = new Mondai();
    Choice choice = new Choice();
    Kekka kekka = new Kekka();
    //タイトルの表示
    title.hyouji();
    for(int y = 1; y == 1;){
      Random randoms = new Random();
      int randomValue = randoms.nextInt(9)+1;
      //問題表示
      mondai.hyouji(randomValue);
      //ｈかｌを選ばせる
      char z = choice.hyouji();
          //ｈかｌが入力されなかった場合ループを抜ける
        if ((z != 'h') && (z != 'l')){
          break;
        }
      //結果表示メソッド
      //引数として、プレイヤー選択したｈかｌの入った変数cと、問題カードの値を渡す
      y = kekka.hyouji(choice.c,randomValue);
    }
    System.out.println("--GAME" + "OVER--");
  }
}

//タイトル
class Title{
  public void hyouji(){
    for(int i = 0;i < 14;i++){
      System.out.print('*');
    }
    System.out.println(" ");
    System.out.println("* High & Low *");
    for(int i = 0;i < 14;i++){
      System.out.print('*');
    }
    System.out.println(" ");
  }
}

//問題
class Mondai{
  public void hyouji(int randomValue){
    System.out.println("[Q hyouji]");

    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
    System.out.print("   ");
    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
    System.out.println(" ");

    System.out.print("*   *   * * *");
    System.out.println(" ");

    System.out.print("* " + randomValue + " *   * * *" );
    System.out.println(" ");

    System.out.print("*   *   * * *");
    System.out.println(" ");

    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
      System.out.print(" " + " " + " ");
     for(int i = 0;i < 5; i++){
       System.out.print('*');
    }
    System.out.println(" ");
  }
}

//ｈかｌを選ぶ
class Choice{
  // ｈかｌを格納する変数
  char c;
  public char hyouji(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("High Low ? (h/l)");
      String str = scanner.next();
      c = str.charAt(0);
    if(c == 'h'){
    System.out.println("->High Choice");
    }else if (c == 'l'){
      System.out.println("->Low Choice");
    }else if ((c != 'l') && (c != 'h')){
      System.out.println("Error");
    }
    return c;
  }
  }

//問題クラスを継承する
class Kekka extends Mondai{
  public int hyouji(char c,int randomValue){
    Random random = new Random();
    int randomValue1 = random.nextInt(9)+1;
    int x = 1;
    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
    System.out.print("   ");
    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
    System.out.println(" ");
    System.out.print("*   *   *   *");
    System.out.println(" ");

    System.out.print("* " +  randomValue + " *   * " + randomValue1 + " *"  );
    System.out.println(" ");

    System.out.print("*   *   *   *");
    System.out.println(" ");

    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }
    System.out.print("   ");
    for(int i = 0;i < 5; i++){
      System.out.print('*');
    }System.out.println(" ");
    if((randomValue > randomValue1) && (c == 'l')){
      System.out.println("->You WIN!");
      x = 1;
    }else if ((randomValue < randomValue1) && (c == 'h')){
      System.out.println("->You WIN!");
      x = 1;
    }else if ((randomValue == randomValue1) && (c == 'h')){
      System.out.println("->You WIN!");
      x = 1;
    }else if((randomValue == randomValue1) && (c == 'l')){
      System.out.println("->You WIN!");
      x = 1;
    }
      else if ((randomValue > randomValue1) &&(c == 'h')){
      System.out.println ("->You Lose...");
      x = 0;
    }else if ((randomValue < randomValue1) && (c == 'l')){
      System.out.println ("->You Lose...");
      x = 0;
    }
    return x;
  }
}