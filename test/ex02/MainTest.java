package ex02;

import ex01.Item2d;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ????????? ????????????
 * ????????????? ???????.
 *
 * @author Vitaliy
 * @version 2.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    /**
     * ???????? ???????? ???????????????? ?????? {@linkplain ViewResult}
     */
    @Test
    public void testCalc() {
        ViewResult view = new ViewResult(5);
        view.init(100);
        Item2d item = new Item2d();
        int ctr = 0;
        item.setAll(0, 1, 1);
        assertEquals("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr), item);
        ctr++;
        item.setAll(100, 3, 2);
        assertEquals("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr), item);
        ctr++;
        item.setAll(200, 3, 2);
        assertEquals("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr), item);
        ctr++;
        item.setAll(300, 3, 3);
        assertEquals("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr), item);
        ctr++;
        item.setAll(400, 3, 3);
        assertEquals("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr), item);
    }

    /**
     * ???????? ????????????. ???????????? ?????????????? ??????.
     */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        view1.init((int) (Math.random() * 1000));
        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(view1.getItems().size(), view2.getItems().size());
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}