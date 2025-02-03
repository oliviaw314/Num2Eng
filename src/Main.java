public class Main {
    public static void main(String[] args) {
        System.out.println(num2Eng(0));
        System.out.println(num2Eng(10));
        System.out.println(num2Eng(18));
        System.out.println(num2Eng(20));
        System.out.println(num2Eng(43));
        System.out.println(num2Eng(126));
        System.out.println(num2Eng(400));
        System.out.println(num2Eng(909));
    }

    public static String num2Eng(int integer) {
        if (integer<0 || integer>999) {
            throw new IllegalArgumentException("Invalid number!");
        }
        else {
            //this string zero is not needed in any other integers other than the integer 0 itself
            if (integer==0) {
                return "zero";
            }

            StringBuilder string = new StringBuilder();
            String[] oneDig = {"one","two","three","four","five","six","seven","eight","nine"};
            String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
            String[] twoDig = {"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};

            //handle 3 digit place
            if (integer>=100) {
                //find which single digit corresponds to the hundred (have to minus 1 as array starts from 0 rather than 1)
                string.append(oneDig[(integer/100)-1]);
                string.append(" hundred");
                //finds remaining digits to convert to eng
                integer%=100;
                if (integer>0) {
                    // if there are still more digits to convert
                    string.append(" ");
                }
            }

            //handle 2 digit place
            if (integer>9) {
                // if integer is in the teens - handle both 2 digit and 1 digit
                if (integer<20) {
                    if (integer==10) {
                        string.append("ten");
                        return string.toString();
                    }
                    //if below 20, looking at the last digit to determine which teens it should be
                    string.append(teens[(integer%10)]);
                    return string.toString();
                }
                // if integer is not in the teens; 20 or above
                else {
                    string.append(twoDig[(integer/10)-2]);
                    integer%=10;
                    if (integer>0) {
                        string.append(" ");
                    }
                }
            }

            //handle 1 digit place - outside of prev BIG if statement so that it can be accessed by both 2/3 digit numbers and 1 digit numbers
            if (integer>0) {
                string.append(oneDig[integer-1]);
            }

            return string.toString();
        }
    }

    /*
    preparing:
    1 = one
    2 = two
    -----------------etc
    11 = eleven
    12 = twelve
    13 = thirteen
    15 = fifteen
    19 = nineteen
    -----------------etc
    10 = ten
    20 = twenty
    -----------------etc
    100 = one hundred
    200 = two hundred
    -----------------etc
    20+1 = twenty one
    20+2 = twenty two
    -----------------etc
    (hundred & tenth combination)
    100+20 = one hundred twenty
    (hundred, tenth & single combination)
    100+30+6 = one hundred thirty six
    (hundred & single combination) - remember do NOT say ZERO
    900+2 = nine hundred two
     */
}