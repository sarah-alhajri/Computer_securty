
import java.io.*;
import java.math.*;
import java.util.*;
public class RSA {
    static String Entered_text;
    static Scanner myReader = new Scanner(System.in);
    
static boolean isPrime(long inputNumber)
{
boolean isItPrime = true;
 
if(inputNumber <= 1) 
{
isItPrime = false;
 
return isItPrime;
}
else
{
for (int i = 2; i<= inputNumber/2; i++) 
{
if ((inputNumber % i) == 0)
{
isItPrime = false;
 
break;
}
}
 
return isItPrime;
}
}

public static double gcd(double a, double h){
	double temp;
	while (true) {
	temp = a % h;
	if (temp == 0)
		return h;
	a = h;
	h = temp;
	}
}


public static BigInteger Decryption(){
System.out.println("Please enter P and Q: ");
int p = myReader.nextInt();
while(!isPrime(p)){
System.out.println("Reenter a PRIME number!");
p = myReader.nextInt();}
        
int q = myReader.nextInt();
while(!isPrime(q)){
System.out.println("Reenter a PRIME number!");
q= myReader.nextInt();}

	int n = p * q;
        int phi = (p - 1) * (q - 1);
        int[] Elist = new int[10]; // list of possible values for e to choose from
        for (int i = 0; i < Elist.length; i++) {
        Elist[i]=0;}

////////////// key generation
        int index=0;
        int e = 2;
         for (e = 2; e < phi && index<Elist.length; e++) {
            if (gcd(e, phi) == 1) {
                  Elist[index]=e;
                  index++;}
                                    }
        System.out.println("Please chose value of e :");
        int i=0;
       while(i<Elist.length && Elist[i]!=0.0){
           System.out.print(Elist[i]+",");
           i++;
       }
        e= myReader.nextInt();
       if (e==0) {
        e=Elist[0];}
      
///////////// find d      
        int k = 1;
	int d = (1 + (k * phi)) / e;
	   if (!(d == (int)d)) {
            k++;
            d = (1 + (k * phi)) / e;}
           ////////////// decrypt        
	System.out.println("Please enter message to decrypt it : " );
        int cmsg= myReader.nextInt();
        Entered_text=("Entered plain text is: "+cmsg);
BigInteger N = BigInteger.valueOf(n);
BigInteger C = BigDecimal.valueOf(cmsg).toBigInteger();
BigInteger msgback = (C.pow(d)).mod(N);
        System.out.println("The Plaintext is :"  + msgback);
return msgback;
};

public static BigInteger Encryption(){
System.out.println("Please enter P and Q: ");
int p = myReader.nextInt();
while(!isPrime(p)){
    System.out.println("Reenter a PRIME number!");
p = myReader.nextInt();}
        
int q = myReader.nextInt();
while(!isPrime(q)){
    System.out.println("Reenter a PRIME number!");
q= myReader.nextInt();}
	int n = p * q;
        int phi = (p - 1) * (q - 1);

        int[] Elist = new int[10]; // list of possible values for e to choose from
      for (int i = 0; i < Elist.length; i++) {
        Elist[i]=0;
    }

////////////// key generation
        int index=0;
        int  e = 2;
         for (e = 2; e < phi && index<Elist.length; e++) {
            if (gcd(e, phi) == 1) {
                  Elist[index]=e;
                  index++;}
                                    }
        System.out.println("Please chose value of e :");
        int i=0;
       while(i<Elist.length && Elist[i]!=0.0){
           System.out.print(Elist[i]+",");
           i++;
       }
        e= myReader.nextInt();
       if (e==0) {
        e=Elist[0];
    }
      
///////////// find d      
        int k = 1;
	long d = (1 + (k * phi)) / e;
	   if (!(d == (int)d)) {
            k++;
            d = (1 + (k * phi)) / e;}

////////////// encrypt
System.out.println("Please enter message to encrypt it : " );
int msg = myReader.nextInt();
Entered_text=("Entered plain text is: "+msg);
BigInteger N = BigInteger.valueOf(n);
BigInteger C = BigDecimal.valueOf(msg).toBigInteger();
BigInteger msgback = (C.pow(e)).mod(N);
        
        System.out.println("The Ciphertext is :" + msgback);
return msgback;
 
}


}

