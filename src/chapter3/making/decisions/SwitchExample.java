package chapter3.making.decisions;

public class SwitchExample {

    public static void main(String[] args)
    {
        switchExpressionWithYield(5, 9);
        switchExpressionWithPatternMatching(null);
        switchStatementWithCaseNull();
    }

    public static void switchStatementWithCaseNull()
    {
        //Normally, switch statement isn't required be exhaustive, but with Pattern Matching
        Number zooPatrons = Integer.valueOf(1_000);
        switch (zooPatrons) {
            case Integer i -> System.out.println("Integer: " + i);
            case Number n -> System.out.println("Number: " + n);
        }

        //switch statement is considered to use pattern matching if case null is used
        //Therefore, it requires exhaustive
        String fish = null;
        switch (fish) {
            case "ClownFish":
                System.out.println("Hello!");
                break;
            case "BlueTang":
                System.out.println("Hello again!");
                break;
            case null:
                System.out.println("What type of fish are you");
                break;
            default:
                break;
            //            case null:
            //                System.out.println("Does not compile because default clause dominates the case null
            //                clause");
        }
    }

    public static void switchExpressionWithPatternMatching(Number height)
    {
        //example for switch expression with Pattern Matching
        var result = switch (height) {
            case Integer i when i > 10 -> "Joseph"; //using when to handle ranges
            case Integer i -> "Daniel";
            case Double num when num <= 15.5 -> "Peter";
            case Double num -> "Kelly";
            //case null clause is supported in Java 21; without it and switch variable is null => a NPE will be thrown
            case null -> "Null";
            case Number num -> "Ralph"; //move this line up will make other cases is dominated and cause compile error
        };
        System.out.println(result);
    }

    public static void switchExpressionWithYield(Integer fish, int length)
    {
        //switch expression must be exhaustive
        //it means all cases have to covered
        var result = switch (fish) {
            case 1 -> "Goldfish";       //this is case expression
            case 2 -> {yield "Trout";}  //this is case block
            case 3 -> {
                if (length > 10)
                    yield "Blowfish";   //yield acted as return statement in case block
                else
                    yield "Green";
            }
            case 4 -> {
                throw new RuntimeException("Unsupported value");
            }
            default -> "Swordfish";
        };

        System.out.println(result);
    }
}