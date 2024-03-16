package org.example.designProblem.item;

import org.example.designProblem.ToastLevels;

public class PopTart implements Item{
    private ToastLevels toastyness;
    public PopTart() {
        this.toastyness = ToastLevels.NOT_TOASTY;
    }
    public void setToastyness(ToastLevels toastyness) {
        this.toastyness = toastyness;
    }
    public ToastLevels getToastyness() {
        return this.toastyness;
    }

    @Override
    public void cook() {
        System.out.println("the pop tart is cooking");
        setToastyness( ToastLevels.getToastLevel(toastyness.getLevel()+1));
    }

    @Override
    public String toString() {
        return "PopTart{" +
                "toastyness=" + toastyness +
                '}';
    }
}
