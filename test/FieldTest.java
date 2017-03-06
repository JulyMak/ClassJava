import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void addZero() {
        Field field = new Field(3);
        field.addZero(2,0);
        field.addZero(1,1);
        field.addZero(2,1);
        assertEquals('0', field.getElement(2,0));
        assertEquals('0', field.getElement(1,1));
        assertEquals('0', field.getElement(2,1));

    }

    @Test
    public void addCross() {
        Field field = new Field(3);
        field.addCross(2,0);
        field.addCross(0,1);
        field.addCross(1,2);
        assertEquals('X', field.getElement(2,0));
        assertEquals('X', field.getElement(0,1));
        assertEquals('X', field.getElement(1,2));
    }

    @Test
    public void clean() {
        Field field = new Field(3);
        field.addZero(2,0);
        field.addCross(0,1);
        field.addZero(2,1);
        field.addCross(1,2);
        field.clean(2,0);
        field.clean(0,1);
        field.clean(2,1);
        field.clean(1,2);
        assertEquals(0, field.getElement(2,0));
        assertEquals(0, field.getElement(0,1));
        assertEquals(0, field.getElement(2,1));
        assertEquals(0, field.getElement(1,2));
    }

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

    @Test
    public void longestZeroes() {
        Field field = new Field(3);
        field.addZero(0,0);
        field.addCross(1,0);
        field.addZero(1,1);
        field.addCross(0,1);
        field.addZero(2,2);
        assertEquals(3, field.longestZeroes()); // главная диаональ
        field.clean(1,1);
        field.addZero(2,1);
        field.addZero(2,0);
        assertEquals(3, field.longestZeroes()); // вертикаль
        field.clean(1,0);
        field.clean(2,1);
        field.addZero(1,0);
        assertEquals(3, field.longestZeroes()); // горизонталь
        field.clean(1,0);
        field.addZero(1,1);
        field.addZero(0,2);
        assertEquals(3, field.longestZeroes()); // побочная диагональ

    }

}