package org.example.designProblem.Toaster;

import org.example.designProblem.ToastLevels;
import org.example.designProblem.item.Item;

import java.util.ArrayList;
import java.util.List;

public class DoubleToaster implements Toaster{

    private List<Item> items;
    private boolean leverDown;
    protected final Integer numberOfSlots;
    private ToastLevels toastyness;

    public DoubleToaster() {
        this.items = new ArrayList<Item>();
        this.leverDown = false;
        toastyness = ToastLevels.TOASTY;
        numberOfSlots = 2;
    }

    public void setToastyness(ToastLevels toastyness) {
        if (!leverDown){
            this.toastyness = toastyness;
        }else{
            System.out.println("the lever is down");
        }
    }

    @Override
    public void insert(Item item) {
        if(!leverDown){
            if(this.items.size() == numberOfSlots) {
                System.out.println("the slot is full");
            }else{
                this.items.add(item);
                System.out.println("the item is inserted");
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    @Override
    public void remove(Item item) {
        if(!leverDown) {
            if(this.items.isEmpty()) {
                System.out.println("the slot is empty");
            }else{
                if(this.items.contains(item)) {
                    System.out.println("the item is not in the slot");
                }else{
                    this.items.remove(item);
                    System.out.println("the item is removed");
                }
            }
        }else{
            System.out.println("the lever is down");
        }
    }

    @Override
    public void pushLever() {
        if(this.items.isEmpty()) {
            System.out.println("the slot is empty");
        }else{
            this.leverDown = true;
            System.out.println("the lever is down");
            for (int i = 0; i < toastyness.getLevel(); i++) {
                items.forEach(Item::cook);
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
        return "DoubleToaster{" +
                "items=" + items +
                ", leverDown=" + leverDown +
                ", numberOfSlots=" + numberOfSlots +
                ", toastyness=" + toastyness +
                '}';
    }
}
