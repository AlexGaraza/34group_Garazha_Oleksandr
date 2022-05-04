package ex05;

import ex01.Item2d;
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
public class MinMaxCommand implements Command /*, Runnable */ {
    /**
     * ?????? ????????? ????????? ?????????
     */
    private int resultMin = -1;
    /**
     * ?????? ????????? ????????? ?????????
     */
    private int resultMax = -1;
    /**
     * ???? ?????????? ??????????
     */
    private int progress = 0;
    /**
     * ??????????? ????????? ???????? {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * ?????????? ???? {@linkplain MinMaxCommand#viewResult}
     *
     * @return ???????? {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * ????????????? ???? {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult ???????? ??? {@linkplain MinMaxCommand#viewResult}
     * @return ????? ???????? {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * ?????????????? ???? {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult ?????? ?????? {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * ?????????? ?????????
     *
     * @return ???? {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * ?????????? ?????????
     *
     * @return ???? {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * ????????? ?????????? ??????????
     *
     * @return false - ???? ????????? ??????, ????? - true
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
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getDigitsNumberOct() < 0) {
                if ((resultMax == -1) ||
                        (viewResult.getItems().get(resultMax).getDigitsNumberOct() <
                                item.getDigitsNumberOct())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) ||
                        (viewResult.getItems().get(resultMin).getDigitsNumberOct() >
                                item.getDigitsNumberOct())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMin).getDigitsNumberOct()));
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMax).getDigitsNumberOct()));
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }
}
