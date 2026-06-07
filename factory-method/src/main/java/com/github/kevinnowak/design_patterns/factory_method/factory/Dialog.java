package com.github.kevinnowak.design_patterns.factory_method.factory;

import com.github.kevinnowak.design_patterns.factory_method.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
