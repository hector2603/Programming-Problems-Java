package org.example.designProblem.Toaster;

import org.example.designProblem.ToastLevels;
import org.example.designProblem.item.Item;

public class SimpleToaster implements Toaster{

    private Item item;
    private boolean leverDown;

    private final ToastLevels toastyness;

    public SimpleToaster() {
        this.item = null;
        this.leverDown = false;
        toastyness = ToastLevels.TOASTY;
    }

    @Override
    public void insert(Item item) {
        if(!leverDown){
            if(this.item != null) {
                System.out.println("the slot is full");
            }else{
                this.item = item;
                System.out.println("the item is inserted");
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    @Override
    public void remove(Item item) {
        if(!leverDown) {
            if(this.item == null) {
                System.out.println("the slot is empty");
            }else{
                if(this.item != item) {
                    System.out.println("the item is not in the slot");
                }else{
                    this.item = null;
                    System.out.println("the item is removed");
                }
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    @Override
    public void pushLever() {
        if(this.item == null) {
            System.out.println("the slot is empty");
        }else{
            this.leverDown = true;
            System.out.println("the lever is down");
            for (int i = 0; i < toastyness.getLevel(); i++) {
                this.item.cook();
            }
            pullLever();
        }
    }

    @Override
    public void pullLever() {
        this.leverDown = false;
        System.out.println("the lever is up");
    }

    @Override
    public String toString() {
        return "SimpleToaster{" +
                "item=" + item.toString() +
                ", leverDown=" + leverDown +
                ", toastyness=" + toastyness +
                '}';
    }
}
