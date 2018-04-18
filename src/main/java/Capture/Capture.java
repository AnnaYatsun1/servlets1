package Capture;

import java.util.Random;

public class Capture {
    public static void main(String[] args) {
        callCap();

    }
    public static void callCap(){
        System.out.println(createCap());
    }
    public static String createCap(){
        Random  random= new Random();
        int I = 7+ (Math.abs(random.nextInt()%3));
        System.out.println(I);
        StringBuffer capBuff = new StringBuffer();
        for (int i = 0; i < I; i++) {
            int base = Math.abs(random.nextInt())%62;
           // System.out.println(base);
            int charNum=0;
            if(base<26){
                charNum=65+base;

            }

           else if(base<52){
                charNum= 97+(base-26);

         }
            else {
                charNum= 48+(base-52);

         }
            capBuff.append((char)charNum);

        }
       // capBuff.append((char)charNum);
        return capBuff.toString();
    }

}
