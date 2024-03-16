package org.example.designProblem.Toaster;

import org.example.designProblem.item.Item;
public interface Toaster {
    void insert(Item item);
    void remove(Item item);
    void pushLever();
    void pullLever();
}
