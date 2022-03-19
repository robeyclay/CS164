public class Test {
    public static String breakIt(String value) {
        String temp = "";
        for(int i = 0; i < value.length(); i++) {
            temp += value.charAt(value.length()-(i+1));
            if(temp.length() <= value.length()/2) continue;
            if(value.contains(temp)) break;
        }
        return temp;

    }

    public static void main(String[] args) {
        System.out.println(breakIt("kinnikinnik")); // line 1
        System.out.println(breakIt("sotorotos")); // line 2
        System.out.println(breakIt("annlee")); // line 3
    }
}
