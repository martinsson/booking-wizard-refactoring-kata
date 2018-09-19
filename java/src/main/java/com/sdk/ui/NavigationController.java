package com.sdk.ui;

public abstract class NavigationController extends ViewController {

    public void pushViewController(ViewController viewController) {
        viewController.show();
        viewController.parent = this;
    }
}