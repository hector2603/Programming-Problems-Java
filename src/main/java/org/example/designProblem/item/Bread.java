package org.example.designProblem.item;

import org.example.designProblem.ToastLevels;

public class Bread implements Item{
    private ToastLevels toastyness;
    public Bread() {
        this.toastyness = ToastLevels.NOT_TOASTY;
    }
    public void setToastyness(ToastLevels toastyness) {
        this.toastyness = toastyness;
    }
    public ToastLevels getToastyness() {
        return this.toastyness;
    }

    public void cook() {
        System.out.println("the bread is cooking");
        setToastyness( ToastLevels.getToastLevel(toastyness.getLevel()+1));
    }

    @Override
    public String toString() {
        return "Bread{" +
                "toastyness=" + toastyness +
                '}';
    }
}
