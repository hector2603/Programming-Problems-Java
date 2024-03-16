package org.example.designProblem.Toaster;

import org.example.designProblem.ToastLevels;
import org.example.designProblem.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ComplexToaster extends DoubleToaster{
    private List<Item> secondaryItems;
    private boolean secondaryLeverDown;
    private ToastLevels secondaryToastyness;

    public ComplexToaster() {
        super();
        this.secondaryItems = new ArrayList<Item>();
        this.secondaryLeverDown = false;
        this.secondaryToastyness = ToastLevels.TOASTY;
    }

    public void setSecondaryToastyness(ToastLevels toastyness) {
        if (!secondaryLeverDown){
            this.secondaryToastyness = toastyness;
        }else{
            System.out.println("the lever is down");
        }
    }

    public void secondaryInsert(Item item) {
        if(!secondaryLeverDown){
            if(this.secondaryItems.size() == numberOfSlots) {
                System.out.println("the slot is full");
            }else{
                this.secondaryItems.add(item);
                System.out.println("the item is inserted");
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    public void secondaryRemove(Item item) {
        if(!secondaryLeverDown) {
            if(this.secondaryItems.isEmpty()) {
                System.out.println("the slot is empty");
            }else{
                if(this.secondaryItems.contains(item)) {
                    System.out.println("the item is not in the slot");
                }else{
                    this.secondaryItems.remove(item);
                    System.out.println("the item is removed");
                }
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    public void secondaryPushLever() {
        if(this.secondaryItems.isEmpty()) {
            System.out.println("the Secondary slots is empty");
        }else{
            this.secondaryLeverDown = true;
            System.out.println("the Secondary lever is down");
            for (int i = 0; i < secondaryToastyness.getLevel(); i++) {
                secondaryItems.forEach(Item::cook);
            }
            secondaryPullLever();
        }
    }

    public void secondaryPushLeverAsync() {
        CompletableFuture.runAsync(this::secondaryPushLever).thenAccept((v) -> System.out.println("the secondary toaster finished"));
    }

    public void secondaryPullLever() {
        this.secondaryLeverDown = false;
        System.out.println("the secondary lever is up");
    }

    @Override
    public String toString() {
        return "ComplexToaster{" +
                "primaryItems=" + super.toString() +
                "secondaryItems=" + secondaryItems +
                ", secondaryLeverDown=" + secondaryLeverDown +
                ", secondaryToastyness=" + secondaryToastyness +
                ", numberOfSlots=" + numberOfSlots +
                '}';
    }
}
