package ex04;

import ex02.View;

/**
 * ?????????? ???????
 * View;
 * ?????? Command
 *
 * @author Vitaliy
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class ViewConsoleCommand implements ConsoleCommand {

    /**
     * ??????, ??????????? ????????? {@linkplain View};
     * ??????????? ????????? ???????? {@linkplain ex01.Item2d}
     */
    private View view;

    /**
     * ?????????????? ???? {@linkplain SaveConsoleCommand#view}
     *
     * @param view ??????, ??????????? ????????? {@linkplain View}
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}