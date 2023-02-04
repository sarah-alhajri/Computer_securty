import java.io.*;
import java.math.*;
import java.util.*;

public class Sec_pro {
 static Scanner myReader = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("Output.txt");  
	      BufferedWriter buffer = new BufferedWriter(file);

        System.out.println("What cryptosystem do you want to use? ");
        System.out.println("1- Shift Cipher \n2- RSA Algorithm \n3- Viginere Algorithm ");
        int c=myReader.nextInt();
        while ( c > 3 || c < 1) {
	         System.out.println("Please select valid number from 1 to 3 !!!!");
	         c = myReader.nextInt();}
    
        System.out.println(" do you want to 1-Encryption or 2-Decryption?");
        int c2=myReader.nextInt();
         while ( c2 > 2 || c2 < 1) {
	         System.out.println("Please select valid number from 1 to 2 !!!!");
	         c2 = myReader.nextInt();}   
        switch(c){
            case 1:
                if(c2==1){
                // go to enc
                StringBuffer result = Shift.encrypt();
                buffer.write(Shift.Entered_text+"\n");
                buffer.write("The Ciphertext is : "+result.toString()+"\n");
                }
                if(c2==2){
                // go to dec
                StringBuffer result =Shift.decrypt();
                buffer.write(Shift.Entered_text+"\n");
                buffer.write("The Plaintext is :" +result.toString()+"\n");
                }
                              
        break;
        //////////
        case 2:
              if(c2==1){
                /// go to enc
                BigInteger result =RSA.Encryption();
                buffer.write(RSA.Entered_text+"\n");
                buffer.write("The Ciphertext is : "+result+"\n");
              }
                if(c2==2){
                    // go to dec
                BigInteger result =RSA.Decryption();
                buffer.write(RSA.Entered_text+"\n");
                buffer.write("The Plaintext is : " +result+"\n");
                }
                
	       
        break;
        /////////
        case 3:
        if(c2==1){
          /// go to enc
          String result = Vigenere.encrypt();
          buffer.write(Vigenere.Entered_text+"\n");
          buffer.write("The Ciphertext is :"+result+"\n");
            }
          if(c2==2){
              // go to dec
              String result = Vigenere.decrypt();
              buffer.write(Vigenere.Entered_text+"\n");
          buffer.write("The Plaintext is :" +result+"\n");
          }
          
   
  break;
        ////////
        }
         buffer.close();
    }
  }