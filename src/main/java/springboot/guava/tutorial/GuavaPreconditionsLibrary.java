package springboot.guava.tutorial;

import com.google.common.base.Preconditions;

public class GuavaPreconditionsLibrary {

    public static void main(String[] args) {

        GuavaPreconditionsLibrary tmp = new GuavaPreconditionsLibrary();

        try {
            System.out.println(tmp.sqrt(-3.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(tmp.sum(null, 3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(tmp.getValue(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public double sqrt(double input) throws IllegalArgumentException {
        Preconditions.checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) {
        a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");

        return a + b;
    }

    public int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");
        return 0;
    }
}
