import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class Shift {
    static String Entered_text;
  static Scanner sc = new Scanner (System.in);

  public static StringBuffer encrypt() {

    String str = new String(); int key = 0;  
    StringBuffer result= new StringBuffer();
   
    System.out.print("Enter the String for Encryption:");
    str = sc.nextLine();
    Entered_text=("Entered plain text is :"+str);

    System.out.println("\nEnter Shift Key:");
    key = sc.nextInt();

      for (int i=0; i<str.length(); i++) {
            if(((Character.isWhitespace(str.charAt(i))))){
                char ch = ' ';
            result.append(ch); } //space condition
            else{
          if (Character.isUpperCase(str.charAt(i))){
              char ch = (char)(((int)str.charAt(i) + key - 65) % 26 + 65);
              result.append(ch);
          }
          else {
              char ch = (char)(((int)str.charAt(i) + key - 97) % 26 + 97);
              result.append(ch);
          }
       
         
      
     }    }  
                     
      System.out.print("The Ciphertext Is :" +result);
      return result;
  }

  public static StringBuffer decrypt(){
    String str = new String(); int key = 0; 
    StringBuffer result= new StringBuffer();
   
    System.out.print("Enter the String for Decryption:");
    str = sc.nextLine();
    Entered_text=("Entered plain text is :"+str);

    System.out.println("\nEnter Shift Key:");
    key = sc.nextInt();

      for (int i=0; i<str.length(); i++) {
        if(((Character.isWhitespace(str.charAt(i))))){
            char ch = ' ';
        result.append(ch); } //space condition
        else {
          if (Character.isUpperCase(str.charAt(i))){
              char ch = (char)(((int)str.charAt(i) - key - 65 +26 ) % 26 + 65);
              result.append(ch);
          }
          else {
              char ch = (char)(((int)str.charAt(i) - key - 97 +26) % 26 + 97);
              result.append(ch);
          }}
      }
      System.out.print("The Plaintext Is :" +result);
      return result;
  }   
  }