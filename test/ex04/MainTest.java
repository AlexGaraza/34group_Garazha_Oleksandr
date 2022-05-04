package ex04;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex02.ViewResult;

/** ???????????? ??????
 * ChangeItemCommand
 * @author Vitaliy
 * @version 4.0
 * @see ChangeItemCommand
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    /** ???????? ?????? {@linkplain ChangeItemCommand#execute()} */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        int decimal;
        int oct;
        int hex;
        int offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            cmd.getItem().setAll(decimal = (int)(Math.random() * 1000), oct = (int)(Math.random() * 5), hex = (int)(Math.random() * 5));
            cmd.setOffset(offset = (int)(Math.random() * 100));
            cmd.execute();
            assertEquals(decimal, cmd.getItem().getDecimalNumber());
            assertEquals(oct * offset, cmd.getItem().getDigitsNumberOct());
            assertEquals(hex * offset, cmd.getItem().getDigitsNumberHex());
        }
    }

    /** ???????? ?????? {@linkplain ChangeConsoleCommand} */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}