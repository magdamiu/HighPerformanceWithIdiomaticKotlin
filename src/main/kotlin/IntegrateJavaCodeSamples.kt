fun main() {
    val number = 10
    // var number = 10
    val interoperable = InteroperableJavaSamples()
    // interoperable.postponeComputation(1000) { println("executed") }
    interoperable.postponeComputation(1000) { println("executed and the number is $number") }
}

/* // no capturing lambda
   public static final void main() {
      InteroperableJavaSamples interoperable = new InteroperableJavaSamples();
      interoperable.postponeComputation(1000, (Runnable)null.INSTANCE);
   }
 */

/* // val
   public static final void main() {
      final int number = 10;
      InteroperableJavaSamples interoperable = new InteroperableJavaSamples();
      interoperable.postponeComputation(1000, (Runnable)(new Runnable() {
         public final void run() {
            String var1 = "executed and the number is " + number;
            boolean var2 = false;
            System.out.println(var1);
         }
      }));
   }
 */

/* // var
   public static final void main() {
      final IntRef number = new IntRef();
      number.element = 10;
      InteroperableJavaSamples interoperable = new InteroperableJavaSamples();
      interoperable.postponeComputation(1000, (Runnable)(new Runnable() {
         public final void run() {
            String var1 = "executed and the number is " + number.element;
            boolean var2 = false;
            System.out.println(var1);
         }
      }));
   }
 */