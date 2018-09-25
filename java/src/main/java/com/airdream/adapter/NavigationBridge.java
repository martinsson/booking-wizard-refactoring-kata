package com.airdream.adapter;

import com.airdream.booking.Step;
import com.sdk.ui.NavigationController;

public class NavigationBridge {

    public NavigationController navigation;

    public NavigationBridge(NavigationController navigation) {
        this.navigation = navigation;
    }

    public void nextStepBridge(Step step) {
        StepBridge viewController = new StepBridge(step);
        navigation.pushViewController(viewController);
    }
}
