import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void longestCrosses() {
        Field field = new Field(3);
        field.addCross(0,0);
        field.addZero(1,0);
        field.addCross(1,1);
        field.addZero(0,1);
        field.addCross(2,2);
        assertEquals(3, field.longestCrosses()); // главная диаональ
        field.clean(1,1);
        field.addCross(2,1);
        field.addCross(2,0);
        assertEquals(3, field.longestCrosses()); // вертикаль
        field.clean(1,0);
        field.clean(2,1);
        field.addCross(1,0);
        assertEquals(3, field.longestCrosses()); // горизонталь
        field.clean(1,0);
        field.addCross(1,1);
        field.addCross(0,2);
        assertEquals(3, field.longestCrosses()); // побочная диагональ
    }

}