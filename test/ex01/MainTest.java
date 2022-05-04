package ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** ????????? ???????????? ????????????? ???????.
 * @author Vitaliy
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    /** ???????? ???????? ???????????????? ?????? {@linkplain Calc} */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        calc.init(10);
        assertEquals(2, calc.getResult().getDigitsNumberOct());
        assertEquals(1, calc.getResult().getDigitsNumberHex());
        calc.init(100);
        assertEquals(3, calc.getResult().getDigitsNumberOct());
        assertEquals(2, calc.getResult().getDigitsNumberHex());
        calc.init(200);
        assertEquals(3, calc.getResult().getDigitsNumberOct());
        assertEquals(2, calc.getResult().getDigitsNumberHex());
        calc.init(300);
        assertEquals(3, calc.getResult().getDigitsNumberOct());
        assertEquals(3, calc.getResult().getDigitsNumberHex());
        calc.init(400);
        assertEquals(3, calc.getResult().getDigitsNumberOct());
        assertEquals(3, calc.getResult().getDigitsNumberHex());
    }
    /** ???????? ????????????. ???????????? ?????????????? ??????. */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        int decimalNumber;
        for(int ctr = 0; ctr < 1000; ctr++) {
            decimalNumber = (int)(Math.random() * 1000);
            DigitsNumberDTO numbers = calc.init(decimalNumber);
            try {
                calc.save();
            } catch (IOException e) {
                Assertions.fail(e.getMessage());
            }
            calc.init((int)(Math.random() * 1000));
            try {
                calc.restore();
            } catch (Exception e) {
                Assertions.fail(e.getMessage());
            }
            assertEquals(numbers.digitsNumberOct, calc.getResult().getDigitsNumberOct());
            assertEquals(numbers.digitsNumberHex, calc.getResult().getDigitsNumberHex());
            assertEquals(decimalNumber, calc.getResult().getDecimalNumber());
        }
    }
}