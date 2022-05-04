package ex05;

import ex02.ViewResult;
import ex04.Command;

import java.util.concurrent.TimeUnit;

/**
 * ??????, ????????????
 * ???????????? ??????;
 * ?????? Worker Thread
 *
 * @author Vitaliy
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
@SuppressWarnings("SpellCheckingInspection")
public class MaxCommand implements Command /*, Runnable */ {
    /**
     * ?????? ????????? ????????? ?????????
     */
    public int result = -1;
    /**
     * ???? ?????????? ??????????
     */
    private int progress = 0;
    /**
     * ??????????? ????????? ???????? {@linkplain ex01.Item2d}
     */
    public ViewResult viewResult;

    /**
     * ?????????? ???? {@linkplain MaxCommand#viewResult}
     *
     * @return ???????? {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * ????????????? ???? {@linkplain MaxCommand#viewResult}
     *
     * @param viewResult ???????? ??? {@linkplain MaxCommand#viewResult}
     * @return ????? ???????? {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * ?????????????? ???? {@linkplain MaxCommand#viewResult}
     *
     * @param viewResult ?????? ?????? {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * ?????????? ?????????
     *
     * @return ???? {@linkplain MaxCommand#result}
     */

    public int getResult() {
        return result;
    }

    /**
     * ????????? ?????????? ??????????
     *
     * @return false - ???? ????????? ??????, ????? - true
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * ???????????? ???????????? ?????? {@linkplain CommandQueue};
     * ?????? Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(result).getDigitsNumberOct() <
                    viewResult.getItems().get(idx).getDigitsNumberOct()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max done. Item #" + result +
                " found: " + viewResult.getItems().get(result));
        progress = 100;
    }
}