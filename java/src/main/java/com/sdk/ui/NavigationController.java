package com.sdk.ui;

import java.util.Scanner;

public class NavigationController extends ViewController {

    public void pushViewController(ViewController viewController) {
        viewController.show();
        viewController.parent = this;
    }

    @Override
    public void show() {

    }
}