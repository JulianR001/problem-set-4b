
/**
 * this set contains a palidrome checker, 
 * a pig latin translator, 
 * a method to figure out many numer in strictly ascending order in between a min and max and 
 * a times table generator
 *
 * @author (Julian Ryan)
 * @version (23/10/24)
 */
public class problem_set_4B {

    public String Palindrome(String str) {
        boolean palindrome = true;
        String result = new String();
        String newString = new String();
        String nonLetters = ",.:;()[]{}!?@#$%^&* ";
        str = str.toLowerCase();
        String temp = "";

        //ignore spaces and special characters
        for(int y = 0; y < str.length(); y++) {
            String letter = str.substring(y,y+1);
            if(!nonLetters.contains(letter))
                temp += str.charAt(y);
        }
        //rearrange
        for(int x = temp.length(); x > 0; x--) {
            newString += temp.charAt(x - 1);
        }
        //check if string is plaindrome
        //print result
        if(newString.equals(temp))
            return "This string is a palindrome";
        else return "this string is not a palindrome";

    }

    public String pigLatin(String str) {
        String pigLatin = new String();
        String temp = "";
        int prevspace;
        str = " " + str + " ";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                prevspace = str.lastIndexOf(" ", i - 1);
                if(i == str.indexOf(" "))
                    temp = "";
                else 
                    temp = str.substring(prevspace + 1, i);

                if(temp.length() > 2)
                    pigLatin += temp.substring(1, temp.length()) + temp.charAt(0) + "ay ";
                else pigLatin += temp + " ";
            }
        } 
        return pigLatin;
    }

    public int StrictlyAscendingNumbers (int min, int max) {
        int num = 0;
        int n = min;
        int temp = min;
        boolean ascending;
        while(n < max) {
            ascending = true;
            while(temp > 9) {
                if ((temp % 10) <= (temp/10) % 10)
                    ascending = false;
                temp /= 10;
            }
            if(ascending)
                num ++;
            n += 1;  
            temp = n;
        }
        return num;
    }
    
    public void Timestable(int n) {
        
        for(int y = 1; y <= n; y++) {
            
            for(int x = y; x <= n*y; x+=y) {
                System.out.printf("%4d", x);
            }
            System.out.println("");
        }
        
    }

}
