public class Task{
    private static int maxPow = -1;
    private static int exp = 0;

    //Coverts a base-10 number to a base-2 number
    public static String toBin(int num){
        if (num < 0){
            num *= -1;
            return "-" + toBin(num);
        }
        if (maxPow == -1){
            maxPow = 1;
            while (maxPow * 2 <= num){
                maxPow *= 2;
            }
        } else{
            maxPow /= 2;
        }
        if (num % maxPow == num && maxPow != 1){
            return "0" + toBin (num);
        } else if (num % maxPow != num && maxPow != 1){
            return "1" + toBin(num - maxPow);
        } else{
            maxPow = -1;
            if (num % maxPow != num){
                return "1";
            } else{
                return "0";
            }
        }
    }
    //Converts a base-2 number into a base-10 number
    public static int toDec(String bin){
        try{
            if (bin.length() > 1){
                if (bin.substring(0,1).equals("-")){
                    return -1 * toDec(bin.substring(1));
                }
            }
            int num = Integer.parseInt(bin.substring(bin.length() - 1));
            int add = num * (int)Math.pow(2, exp);
            exp++;
            return add + toDec(bin.substring(0, bin.length() - 1));
        } catch(Exception ex){
            exp = 0;
            return 0;
        }
    }
    public static void main(String[] args){
        //Testing Triple Digit Number
        String bin1 = toBin(207);
        System.out.println(bin1);
        System.out.println(toDec(bin1));
        System.out.println();
        //Testing Double Digit Number
        String bin2 = toBin(34);
        System.out.println(bin2);
        System.out.println(toDec(bin2));
        System.out.println();
        //Testing Quad Digit Number
        String bin3 = toBin(1723);
        System.out.println(bin3);
        System.out.println(toDec(bin3));
        System.out.println();
        //Testing 0 and 1
        String bin4 = toBin(0);
        String bin5 = toBin(1);
        System.out.println(bin4);
        System.out.println(toDec(bin4));
        System.out.println();
        System.out.println(bin5);
        System.out.println(toDec(bin5));
        System.out.println();
        //Testing Negatives
        String bin6 = toBin(-21);
        System.out.println(bin6);
        System.out.println(toDec(bin6));
    }
}
/*
Testing:
Method is tested by converting an integer into binary and then printing it. After this it is converted back into an integer and then that is also printed.

Bin1:
11001111
207

Bin2:
100010
34

Bin3:
11010111011
1723

Bin4:
0
0

Bin5:
1
1

Bin6:
-10101
-21

Sources:
https://www.youtube.com/watch?v=Xeyks-fwSsM
https://www.thoughtco.com/changing-from-base-10-to-base-2-2312136

 */