package org.example.designProblem;

public enum ToastLevels {
    NOT_TOASTY(0),
    LIGHTLY_TOASTED(1),
    TOASTY(2),
    DARK_TOAST(3),
    BURNT_TOAST(4);

    private final int level;
    ToastLevels(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }
    public static ToastLevels getToastLevel(int level) {
        return switch (level) {
            case 0 -> NOT_TOASTY;
            case 1 -> LIGHTLY_TOASTED;
            case 2 -> TOASTY;
            case 3 -> DARK_TOAST;
            default -> BURNT_TOAST;
        };
    }
}
