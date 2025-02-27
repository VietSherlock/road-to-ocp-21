package chapter3.making.decisions;

public class SwitchExample {

    private SwitchExample() {}

    public static String switchExpressionWithPatternMatching(Number height)
    {
        //example for switch expression with Pattern Matching
        return switch (height) {
            case Integer i -> "Rounded: " + i;
            case Double i -> "Precise: " + i;
            case Number i -> "Unknown: " + i;
        };
    }

    public static String switchExpressionWithYield(int fish, int length)
    {
        //switch expression must be exhaustive
        //it means all cases have to covered
        return switch (fish) {
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
    }
}