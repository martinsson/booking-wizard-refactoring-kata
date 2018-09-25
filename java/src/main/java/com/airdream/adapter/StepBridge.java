package com.airdream.adapter;

import com.airdream.booking.Step;
import com.sdk.ui.ViewController;

public class StepBridge extends ViewController {

    private Step step;

    public StepBridge(Step step) {
        this.step = step;
    }

    @Override
    public void show() {
        this.step.run();

    }
}
