package org.example.designProblem.item;

import org.example.designProblem.ToastLevels;

public class Bagel implements Item{
    private ToastLevels toastyness;
    public Bagel() {
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
        System.out.println("the bagel is cooking");
        setToastyness( ToastLevels.getToastLevel(toastyness.getLevel()+1));
    }

    @Override
    public String toString() {
        return "Bagel{" +
                "toastyness=" + toastyness +
                '}';
    }
}
