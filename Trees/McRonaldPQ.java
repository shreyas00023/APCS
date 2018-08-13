import java.util.*;
public class McRonaldPQ{
   private static PriorityQueue<Customer> line = new PriorityQueue<Customer>();
   private static final int openmins = 1020;
   public static void main(String[] args)
   {
      int numsenior = 0, numjunior = 0, numsoph = 0, numfresh = 0;
      int highsenior = 0, highjunior = 0, highsoph = 0, highfresh = 0;
      double totalsenior = 0, totaljunior = 0, totalsoph = 0, totalfresh = 0;
      double avgsenior, avgjunior, avgsoph, avgfresh;
      for(int k = openmins; k>0; k--){
                 int chance = (int)(Math.random()*4+1);
         if(chance == 1){
            add(line);   
         }
              }
      avgsenior = totalsenior/numsenior;
      avgjunior = totaljunior/numjunior;
      avgsoph = totalsoph/numsoph;
      avgfresh = totalfresh/numfresh;
      System.out.println("Customer"+"\t"+"Total Served"+"\t"+"Longest Wait"+"\t"+"Average Wait");
      System.out.println("Senior"+"\t"+totalsenior+"\t"+highsenior+"\t"+avgsenior);
      System.out.println("Junior"+"\t"+totaljunior+"\t"+highjunior+"\t"+avgjunior);
      System.out.println("Sophomore"+"\t"+totalsoph+"\t"+highsoph+"\t"+avgsoph);
      System.out.println("Freshman"+"\t"+totalfresh+"\t"+highfresh+"\t"+avgfresh);
   
   }
   private static void add(PriorityQueue pq){
   int waitadd = 0;
            if(pq.size() != 0){
            for(Customer c: pq)
               waitadd+= c.getOrderTime();
               }           
             int chance2 = (int)(Math.random()*4+1);
            if(chance2 == 1)
               pq.add(new Senior(waitadd, ""+numsenior));
            else if(chance2 == 2)
               pq.add(new Junior(waitadd, ""+numjunior));
            else if(chance2 == 3)
               pq.add(new Sophomore(waitadd, ""+numsoph));
            else
               pq.add(new Freshman(waitadd, ""+numfresh));  
   }
}
class Customer implements Comparable<Customer>{
   private int ordertime;
   private int totalwait;
   private String name;
   public Customer(int n, String m){
      ordertime = (int)(Math.random()*5+2);
      totalwait = ordertime + n;
      name = m;
   }
   public int getOrderTime(){
      return ordertime;
   }
   public void subOrderTime(){
      ordertime--;
   }
   public int getTotalWait(){
      return totalwait;
   }
   public void addTotalWait(int x){
      totalwait += x;
   }
   @Override
   public String toString(){
      return name;
   }
   public int compareTo(Customer other){
      if(this.getCompareValue()>other.getCompareValue())
         return -1;
      if(this.getCompareValue()<other.getCompareValue())
         return 1;
      return 0;
   }
   public int getCompareValue(){
      return 0;
   }
}
class Senior extends Customer{
   private int ordertime;
   private int totalwait;
   private String name;
   public Senior(int n, String m){
      super(n, m);
   }
   public int getCompareValue(){
      return 4;
   }
}
class Junior extends Customer{
   private int ordertime;
   private int totalwait;
   private String name;
   public Junior(int n, String m){
      super(n, m);
   }
   public int getCompareValue(){
      return 3;
   }
}
class Sophomore extends Customer{
   private int ordertime;
   private int totalwait;
   private String name;
   public Sophomore(int n, String m){
      super(n, m);
   }
   public int getCompareValue(){
      return 2;
   }
}
class Freshman extends Customer{
   private int ordertime;
   private int totalwait;
   private String name;
   public Freshman(int n, String m){
      super(n, m);
   }
   public int getCompareValue(){
      return 1;
   }
}
