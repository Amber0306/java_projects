import  java.util.*;
public class Say_Hello_to_You{
       public static void main(String[] args){
               Scanner reader = new Scanner(System.in);
              System.out.print("Enter your name: ");
              String name = reader.next();
              System.out.println("Hello, Mr."+name+"! How old are you?");
              int age = reader.nextInt();
              System.out.println("Really? You are so young!");
       }
}