package chapter3.making.decisions;

public class LoopExample {

    public static void main(String[] args)
    {
        //        forLoopWithMultipleTerms();
        nestedLoop();
    }

    //[Label]
    //A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it.
    //if, switch, loops statement can have label as optional

    //[NOTES] A nested loop is a loop that contains another loop
    // including while, do/while, for, for-each
    private static void nestedLoop()
    {
        //nested loop with for-each
        int[][] myComplexArr = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
        System.out.println("-------------nested loop with for-each------------");

        for (int[] mySimpleArr : myComplexArr) {
            for (int i : mySimpleArr) {
                //            for (int i = 0; i < mySimpleArr.length; i++) {
                if (i == 2) {
                    break;  //break only terminate the nearest inner loop; not terminate all loops
                }
                System.out.print(i + "\t");
                //                System.out.print(mySimpleArr[i] + "\t");
            }
            System.out.println();
        }

        //nested loop with while & do-while
        System.out.println();
        System.out.println("-------------nested loop with while & do-while------------");

        int hungryHippopotamus = 8;
        while (hungryHippopotamus > 0) {
            do {
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus > 5);
            hungryHippopotamus--;
            System.out.print(hungryHippopotamus + ",");
        }
    }

    private static void forLoopWithMultipleTerms()
    {
        int x = 0;
        //[Compile Error] variables in the initialization block must have the same type
        // for (long y = 0, int z = 4; x < 5 && y < 10; x++, y++) {
        for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");

            // [Bad Practice] should not modify loop variables as it can lead to an unexpected result
            y = 11;
        }
        System.out.print(x + " ");
        // System.out.println(y); // [Compile Error] using loop variable 'y' outside the loop
    }
    private static void infiniteForLoop()
    {
        // the important to have an infinite loop is leave booleanExpression blank
        // for (int x = 0; ; x++)
        for (; ; ) {
            System.out.println("You're in infinite loop!");
        }
    }
}