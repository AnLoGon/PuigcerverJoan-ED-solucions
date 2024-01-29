package ud5.exercices;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud5.exercises.Multiples;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplesTest {
    @Nested
    class MultiplesBelowNumber {
        @Test
        void multipleBelowExist(){
            Multiples m = new Multiples();
            m.multiplesBelow(0, 0);
        }

        @Test
        void multipleBelowShouldReturnList(){
            Multiples m = new Multiples();
            List<Integer> l = m.multiplesBelow(0, 0);
            assertNotNull(l);
        }

        @Test
        void multipleBelow_given0_ShouldReturn0(){
            Multiples m = new Multiples();
            List<Integer> l = m.multiplesBelow(0, 0);
            assertAll(
                () -> assertEquals(1, l.size()),
                () -> assertEquals(0, l.get(0))
            );
        }
    }
}
