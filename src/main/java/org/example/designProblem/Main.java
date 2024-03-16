package org.example.designProblem;

import org.example.designProblem.Toaster.ComplexToaster;
import org.example.designProblem.Toaster.DoubleToaster;
import org.example.designProblem.Toaster.SimpleToaster;
import org.example.designProblem.Toaster.Toaster;
import org.example.designProblem.item.Bagel;
import org.example.designProblem.item.Bread;
import org.example.designProblem.item.Item;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Item bread = new Bread();
        Item bagel = new Bagel();
        Toaster toaster = new SimpleToaster();
        toaster.insert(bread);
        toaster.insert(bagel);
        toaster.pushLever();
        System.out.println(bread.getToastyness());
        System.out.println(toaster);
        toaster.pushLever();
        System.out.println(bread.getToastyness());
        toaster.remove(bread);
        toaster.pushLever();

        System.out.println("----------------------");

        DoubleToaster toaster2 = new DoubleToaster();
        Item bread2 = new Bread();
        Item bread3 = new Bread();
        Item bagel2 = new Bagel();

        toaster2.insert(bread2);
        toaster2.insert(bread3);
        toaster2.insert(bagel2); // this shows that the toaster is full

        toaster2.setToastyness(ToastLevels.DARK_TOAST);
        System.out.println(toaster2);
        toaster2.pushLever();

        System.out.println(toaster2);


        System.out.println("----------------------");
        ComplexToaster toaster3 = new ComplexToaster();
        toaster3.insert(bread2);
        toaster3.insert(bread3);
        toaster3.setToastyness(ToastLevels.DARK_TOAST);
        toaster3.setSecondaryToastyness(ToastLevels.LIGHTLY_TOASTED);
        toaster3.insert(bagel2); // this shows that the toaster is full
        toaster3.secondaryInsert(bagel);
        toaster3.secondaryInsert(bagel2);
        System.out.println(toaster3);
        toaster3.secondaryPushLeverAsync();
        System.out.println(toaster3);


    }

}
