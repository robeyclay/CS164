
public class Coffee {
    /*
     * STEP 2: Declare two enums, types, and sizes, in each class.
     * Types should have the following possible values: HOT, ICED, BLENDED
     * Sizes should have the following possible values: SMALL, MEDIUM, LARGE
     */
    // STUDENT CODE HERE

    /*
     * Each coffee drink object has a type, size, price, and array of flavors.
     */
    public enum types {HOT, ICED, BLENDED}
    public enum sizes {SMALL, MEDIUM, LARGE}
    types type;
    sizes size;
    double price;
    String [] flavors;

    /*
     * Coffee Constructor: Creates a coffee drink object based on a string in the format "SizeLetter TypeLetter Flavors"
     * STEP 3: Use two switch statements to initialize the type and size of the object with the appropriate enumeration.
     * The default value for size should small, and the default value for type should be hot.
     */
    public Coffee(String orderLine) {
        String sizeStr = orderLine.substring(0,1);
        switch(sizeStr) {
            case "M":
                size = sizes.MEDIUM;
                break;
            case "L":
                size = sizes.LARGE;
                break;
            default:
                size = sizes.SMALL;
        }

        String typeStr = orderLine.substring(2,3);
        switch(typeStr) {
            case "I":
                type = types.ICED;
                break;
            case "B":
                type = types.BLENDED;
                break;
            default:
                type = types.HOT;
        }

        flavors = orderLine.substring(4).split(" ");
        calculatePrice();
    }

    /*
     * Helper methods getSizeIndex and getTypeIndex are used for the orderInfo() method in the order class.
     * STEP 4: Use a switch statement for both methods to return the appropriate index for each enumeration.
     * SMALL - 0, MEDIUM - 1, LARGE - 2
     * HOT - 0, ICED - 1, BLENDED - 2
     * Each switch statements default case should be 0.
     */

    public int getSizeIndex(sizes s){
        switch(s) {
            case MEDIUM:
                return 1;
            case LARGE:
                return 2;
            default:
                return 0;
        }
    }

    public int getTypeIndex(types t){
        switch(t) {
            case ICED:
                return 1;
            case BLENDED:
                return 2;
            default:
                return 0;
        }
    }


    /*
     * The calculatePrice method uses a switch statement and conditional expressions to assign the price variable for the coffee object.
     * The prices should be as follows:
     * 	Small - Hot/Iced - 3.0
     * 		  - Blended - 3.5
     *  Medium - Hot/Iced - 4.0
     *  	   - Blended - 4.5
     *  Large - Hot/Iced - 5.0
     *  	  - Blended - 5.5
     *
     *  An additional charge for any flavor that is not chocolate, caramel, or vanilla, is 50 cents.
     *
     *  STEP 5: Use two switch statements to assign the price.
     *  In the first switch statement, use the size and a conditional expression based on whether the type is blended to assign the price.
     *  In the second switch statement, which is inside the for loop,  use fallthrough to do nothing if the flavor is chocolate, caramel, or vanilla. Otherwise, add 50 cents to the price.
     */
    public void calculatePrice() {
        price = 0.0;
        switch(size) {
            case MEDIUM:
                price =(type == types.BLENDED) ? 4.5 : 4.0;
                break;
            case LARGE:
                price =(type == types.BLENDED) ? 5.5 : 5.0;
                break;
            default:
                price =(type == types.BLENDED) ? 3.5 : 3.0;
        }
        for(int i = 0; i < flavors.length; i++){
            switch(flavors[i]) {
                case "chocolate":
                case "vanilla":
                case "caramel":
                    break;
                default:
                    price += 0.5;
            }
        }
    }

}
