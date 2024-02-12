package ud5.exercises.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Nested
    class ConstructorsRectangleTest {
        @Test
        @DisplayName("Rectangle(x, y, height, width) should exist")
        void constructorGivenXYHeightWidthShouldExist(){
            Rectangle r = new Rectangle(2, -2, 3, 1);
        }
        @Test
        @DisplayName("Rectangle(x, y, height, width) should set attributes")
        void constructorGivenXYHeightWidthShouldSetAttributes(){
            Rectangle r = new Rectangle(2, -2, 3, 1);
            assertAll(
                    () -> assertEquals(2, r.getX()),
                    () -> assertEquals(-2, r.getY()),
                    () -> assertEquals(3, r.getHeight()),
                    () -> assertEquals(1, r.getWidth())
            );
        }

        @Test
        @DisplayName("Rectangle(x, y, height, width) should set attributes")
        void constructorGivenDifferentXYHeightWidthShouldSetAttributes(){
            Rectangle r = new Rectangle(1, 2, 2, 4);
            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(2, r.getY()),
                    () -> assertEquals(2, r.getHeight()),
                    () -> assertEquals(4, r.getWidth())
            );
        }

        @Test
        @DisplayName("Rectangle(height, width) should exist")
        void constructorGivenHeightWidthShouldExist(){
            Rectangle r = new Rectangle(2, 2);
        }

        @Test
        @DisplayName("Rectangle(height, width) should set attributes")
        void constructorGivenHeightWidthShouldSetAttributes(){
            Rectangle r = new Rectangle(2, 2);
            assertAll(
                    () -> assertEquals(0, r.getX()),
                    () -> assertEquals(0, r.getY()),
                    () -> assertEquals(2, r.getHeight()),
                    () -> assertEquals(2, r.getWidth())
            );
        }
    }

    @Nested
    class AreaTest {
        @Test
        @DisplayName("Rectangle::area() should exist")
        void areaMethodShouldExist(){
            Rectangle r = new Rectangle(2, 2);
            r.area();
        }

        @Test
        @DisplayName("Rectangle::area() should return double")
        void areaMethodShouldReturnDouble(){
            Rectangle r = new Rectangle(2, 2);
            double area = r.area();
        }

        @Test
        @DisplayName("Rectangle::area(2, 2) should return 4")
        void areaMethod_given2x2Rectangle_ShouldReturn4(){
            // Arrange
            Rectangle r = new Rectangle(2, 2);
            // Act
            double area = r.area();
            // Assert
            assertEquals(4, area);
        }

        @Test
        @DisplayName("Rectangle::area(1, 1) should return 1")
        void areaMethod_given1x1Rectangle_ShouldReturn1(){
            Rectangle r = new Rectangle(1, 1);
            double area = r.area();
            assertEquals(1, area);
        }
    }

    @Nested
    class MoveTest {
        /*
        @Test
        @DisplayName("Rectangle::move() should exist")
        void moveMethodShouldExist(){
            Rectangle r = new Rectangle(2, 2);
            r.move();
        }
        */

        @Test
        @DisplayName("Rectangle::move(x, y) should exist")
        void moveMethodWithXYShouldExist(){
            Rectangle r = new Rectangle(2, 2);
            r.move(1, 1);
        }

        /*
        @Test
        @DisplayName("Rectangle(0,0)::move(1,1) should be in (1,1)")
        void moveMethod11_GivenRectangleAt00_ShouldBeAt11(){
            // Arrangle
            Rectangle r = new Rectangle(0, 0, 2, 2);
            // Act
            r.move(1, 1);
            // Assert
            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(1, r.getY())
            );
        }

        @Test
        @DisplayName("Rectangle(0,0)::move(2,2) should be in (2,2)")
        void moveMethod22_GivenRectangleAt00_ShouldBeAt22(){
            Rectangle r = new Rectangle(0, 0, 2, 2);
            r.move(2, 2);
            assertAll(
                    () -> assertEquals(2, r.getX()),
                    () -> assertEquals(2, r.getY())
            );
        }
        */
        @ParameterizedTest(name="Rectangle({0},{1})::move({2},{3}) should be in ({4},{5})")
        @CsvSource({
                "0,0,1,1,1,1",
                "0,0,2,2,2,2",
                "1,1,2,2,3,3",
                "0,0,-1,-1,-1,-1",
        })
        void moveMethod(double x0, double y0, double x1, double y1, double expectedX, double expectedY){
            Rectangle r = new Rectangle(x0, y0, 1, 1);
            r.move(x1, y1);
            assertAll(
                    () -> assertEquals(expectedX, r.getX()),
                    () -> assertEquals(expectedY, r.getY())
            );
        }
    }
}
