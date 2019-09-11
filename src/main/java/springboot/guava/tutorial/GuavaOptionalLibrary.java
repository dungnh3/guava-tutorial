package springboot.guava.tutorial;

import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.emptyToNull;

public class GuavaOptionalLibrary {

    public static void main(String[] agrs) {

        /**
         * Optional.fromNullable - allow passed parameter to be null
         * Optional.of - throws NulPointerException if passed parameter is null
         */
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> optionalValue1 = Optional.fromNullable(value1);
        Optional<Integer> optionalValue2 = Optional.fromNullable(value2);
        System.out.println("Optional value 1: " + optionalValue1.isPresent());

        /**
         * Optional.or - returns the value if present otherwise returns the default value passed
         */
        Integer valueReplace = optionalValue1.or(0);
        System.out.println("Value replace: " + valueReplace);

        /**
         * Optional.get - gets the value, value should be present
         */
        Integer value = optionalValue2.get();
        System.out.println("Value present: " + value);

        List<String> myList = new ArrayList<>();
        myList.add("Geeks");
        myList.add("for");
        myList.add("GeeksClasses");
        myList.add(null);
        myList.add("GeeksforGeeks");
        myList.add("");
        myList.add("Data Structures");

        displayValuesUsingJavaNulls(myList);

        displayValuesUsingGuavaOptional(myList);
    }

    public static void displayValuesUsingJavaNulls(List<String> myList) {
        System.out.println("Displaying values using Java Nulls");
        for (String str : myList) {
            if (str == null || str.isEmpty()) {
                System.out.println("String: values using Java Nulls");
            } else {
                System.out.println("String: " + str);
            }
        }
        System.out.println();
    }

    public static void displayValuesUsingGuavaOptional(List<String> myList) {
        System.out.println("Display values using Guava Optional");
        for (String str : myList) {
            Optional<String> optionalName = Optional.fromNullable(emptyToNull(str));
            System.out.println("String: " + optionalName.or("Value is empty or not available"));
        }
    }
}
