package org.example.designProblem.item;

import org.example.designProblem.ToastLevels;

public interface Item {
    void setToastyness(ToastLevels toastyness);
    ToastLevels getToastyness();
    void cook();
}
