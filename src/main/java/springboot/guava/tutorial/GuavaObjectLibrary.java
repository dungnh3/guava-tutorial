package springboot.guava.tutorial;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;

import com.google.common.base.Objects;

/**
 * @author nguyenhoangdung
 * @apiNote Objects class provides helper functions applicable to all objects such as equals, hashCode, etc
 */
public class GuavaObjectLibrary {

    public static void main(String[] args) {
        Student student1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student student2 = new Student("Suresh", null, 3, null);

        /**
         * static boolean equal(Object a, Object b)
         * determines whether two possibly-null objects are equal
         */
        System.out.println(student1.equals(student2));

        /**
         * static int hashCode(Object...object)
         * generates a hash code for multiple values
         */
        System.out.println(student1.hashCode());
    }
}

@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED, onConstructor = @__(@Inject))
class Student {
    private final String firstName;
    private final String lastName;
    private final int rollNo;
    private final String className;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student) || object == null) {
            return false;
        }
        Student student = (Student) object;
        /**
         * No need to handle null here
         */
        return Objects.equal(firstName, student.firstName)
                && Objects.equal(lastName, student.lastName)
                && Objects.equal(rollNo, student.rollNo)
                && Objects.equal(className, student.className);
    }

    @Override
    public int hashCode() {
        /**
         * No need to compute hashCode by self
         */
        return Objects.hashCode(className, rollNo);
    }
}