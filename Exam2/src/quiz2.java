public class quiz2 {
    char [] classArr;

    // Step 1
    public quiz2(char c1, char c2, char c3) {
        // student code here
        this.classArr = new char[]{c1, c2, c3};
    }

    // Step 2
    public String arrayToUpperCaseString() {
        // student code here
        String upperCase = "";
        for (int i  = 0; i < this.classArr.length; i++) {
            upperCase += this.classArr[i];
        }
        upperCase = upperCase.toUpperCase();
        return upperCase;
    }

    // Step 3
    public static String arrayToReverseString(char [] arr){
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        return reverse;
    }
    // student code here


    public static void main(String[] args) {
        //  test your methods here!
        quiz2 testArr = new quiz2('a','p','q');
        System.out.println(testArr.arrayToUpperCaseString());
        System.out.println(arrayToReverseString(new char[]{'a','b','c','d'}));
    }

}