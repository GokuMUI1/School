public class Main {
  public static void main(String[] args) {
// Data Tpyes
    // Integer types
    byte aSingleByte = 100; // -128 to 127
    short aSmallNumber = 20000; // -32,768 to 32,767
    int anInteger = 2147483647; // -2147483648 to 2147483647
    long aLargeNumber = 9223372036854775807L; // -9223372036854775808 to 9223372036854775807

    // decimal types
    double aDouble = 1.79769313; // 4.9E-324 to 1.7976931348623157E308
    float aFloat = 3.4028F; // 1.4E-45 to 3.4028235E38

    //booleans
    boolean isWeekend = false;
    boolean isWorkday = true;

    //characters
    char copyrightSymbol = '\u00A9' ;
    System.out.println("This is the copyright symbol: " + copyrightSymbol);
    char percentSymbol = '%';
    System.out.println("This is the percent symbol " + percentSymbol);

    // change double in int
    double number1 = 5.8;
    int number2 = (int)number1; 

    System.out.println(number2); // the 5.8 turn into 5 because int can only hold full number and not decimal
    

  }
}
