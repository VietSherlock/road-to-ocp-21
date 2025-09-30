package chapter3.making.decisions;

public class LoopExercise {
    
    public static void main(String[] args)
    {
        //        forLoopWithMultipleTerms();
        //        nestedLoop();
        //        labelWithBreak();
        //        labelWithContinue();

//        int[][] matrix = {{1, 10}, {5, 2}, {2, 2}};
//        int searchValue = 2;
//        int[] results = searchForValue(matrix, searchValue);
//
//        if (results != null) {
//            System.out.printf("Value %d found at: (%d, %d)", searchValue, results[0], results[1]);
//        } else {
//            System.out.printf("Value %d not found.", searchValue);
//        }
        String[] list = " : ".split(":");
        System.out.println(list);
    }

    private static int[] searchForValue(int[][] inputMatrix, int v)
    {
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                if (inputMatrix[i][j] == v) {
                    return new int[]{i, j}; //return statements can be used to exit loops quickly
                    // v = 1; // code placed immediately after return, break, continue in the same block is considered unreachable and will not compile
                }
            }
        }
        return null;
    }

    private static void labelWithContinue()
    {
        CLEANING:
        for (char stable = 'a'; stable <= 'd'; stable++) {
            for (int leopard = 1; leopard <= 3; leopard++) {
                if (stable == 'b' || leopard == 2) {
                    continue CLEANING;  //clean first leopard in each stable but stable 'b'
                    //                    continue; //skip cleaning leopards in stable 'b' and the second leopard in each stable
                }
                System.out.printf("Cleaning: %c,%d %n", stable, leopard);
            }
        }
    }

    //[LABEL]
    //A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it.
    //if, switch, loops statement can have label as optional
    private static void labelWithBreak()
    {
        int[][] twoDimensionalArr = {{1, 10}, {5, 2}, {2, 2}};
        int searchValue = 2;
        int positionX = -1;
        int positionY = -1;

        PARENT_LOOP:
        for (int i = 0; i < twoDimensionalArr.length; i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {
                if (twoDimensionalArr[i][j] == 2) {
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;  //break with label can help break outer loop
                    //                    break;    // break without label only break inner loop
                }
            }
        }

        if (positionX == -1 || positionY == -1) {
            System.out.print("Value " + searchValue + " not found");
        } else {
            System.out.print("Value " + searchValue + " found at: " + "(" + positionX + "," + positionY + ")");
        }
    }

    //[NESTED LOOP] A nested loop is a loop that contains another loop
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
                    break;  //break only terminate the nearest inner loop; not able to terminate outer loops
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