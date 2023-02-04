import java.util.*;

public class Vigenere
{
    static String Entered_text;
    static Scanner sc=new Scanner(System.in); 
    public static String encrypt()
    {
        
System.out.println("Plaese enter the plain text:");
String text = sc.nextLine();
while(!check(text)){
    System.out.println("Please Rewrite a letter");
    text= sc.nextLine();}
Entered_text=("Entered plain text is :"+text);

System.out.println("Plaese enter the key:");
String key = sc.nextLine();
while(!check(key)){
    System.out.println("Please use letter only");
    key= sc.nextLine();}
        String result = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')// sure that it is still capital ASCII
                continue;
            result += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        System.out.print("The Ciphertext Is :" +result);
        return result;
    }
 
    public static String decrypt()
    {
        String result = "";
        System.out.println("Plaese enter the cipher text:");
        String text = sc.nextLine();
        while(!check(text)){
            System.out.println("Please Rewrite a letter");
            text= sc.nextLine();}
        Entered_text=("Entered plain text is :"+text);
        System.out.println("Plaese enter the key:");
        String key = sc.nextLine();
        while(!check(key)){
            System.out.println("Please Rewrite a letter");
            key= sc.nextLine();}
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            result += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
         System.out.print("The Plaintext Is :" +result);
        return result;
    }





   

     static boolean check (String name) {
        char[] chars = name.toCharArray();
    
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
    
        return true;
    }
   
}