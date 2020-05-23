import java.util.*;
class SnakeLadder
{
  static{
    System.out.println("Ladders");
     System.out.println("6-37 , 9-50 , 15-67");
     System.out.println("21-57 , 24-88 ,35-95");
     System.out.println("47-70 , 64-99 ,72-91");
     System.out.println("Snakes");
     System.out.println("30-4 , 36-13 , 40-11");
     System.out.println("43-2 , 54-23 , 65-19");
     System.out.println("75-17 , 84-33 `, 92-5");
     System.out.println("98-14");
  }
   int board[];String players[];
   SnakeLadder(int size)
   {
     Scanner sc=new Scanner(System.in);
     board=new int [size];
     players=new String[size];
     for(int i=0;i<size;i++)
     {
      System.out.println("Enter Name of "+(i+1)+" Player");
      players[i]=sc.nextLine();
    }
   }
   static void information(int t,String name)
   {
     for(int i=0;i<10;i++)
       {
        int k;
        int j=k=t+i;
        j=runner(j);
        if(j>k)
          System.out.println(name+", You have a ladder ahead at possition "+k);
        else if(j<k)
          System.out.println(name+", You have a snake ahead at possition "+k);
       }
    }
    static int roll()
   {
      return((int)(Math.random()*5)+1);   
   }
   static int runner(int t)
   {
    switch(t)
     {
       case 6:t=37;break;
       case 7:t=23;break;
       case 9:t=50;break;
       case 15:t=67;break;
       case 21:t=57;break;
       case 29:t=88;break;
       case 35:t=95;break;
       case 47:t=70;break;
       case 64:t=99;break;
       case 72:t=91;break;
      
       case 30:t=4;break;
       case 36:t=13;break;
       case 40:t=11;break;
       case 43:t=2;break;
       case 54:t=23;break;
       case 65:t=19;break;
       case 75:t=17;break;
       case 84:t=33;break;
       case 98:t=14;break;
       case 92:t=5;break;
     }
     return t;
   }
   static int execute(int t)
   {
     int u=roll();
     System.out.println("You got "+u);
     if(t==0 && u==1)
      t=1;
     else if(t!=0 && (t+u)<=100)
      t=t+u;
     t=runner(t);
     return  t;
   }
   public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Number of Players");
    int n=sc.nextInt();
    sc.nextLine();
    SnakeLadder sl=new SnakeLadder(n);
    display(sl);
    for(int x=0;sl.board[x%n]<100;x++)
    {
      information(sl.board[x%n],sl.players[x%n]);
      System.out.println(sl.players[x%n]+" your turn.");
      System.out.print(sl.players[x%n]+" Press a key to roll dice : ");
      String k=sc.nextLine();
      sl.board[x%n]=execute(sl.board[x%n]);
      display(sl);
      if(sl.board[x%n]==100)
      {
        System.out.println(sl.players[x%n]+" wins");
        System.out.println("Game Ends");
        System.exit(0);
      }
    }
   }
   static void display(SnakeLadder sl)
   {
     for(int i=0;i<sl.board.length;i++){
      System.out.println(sl.players[i]+" is at "+sl.board[i]+" position.");
    }
    System.out.println();
   }
}