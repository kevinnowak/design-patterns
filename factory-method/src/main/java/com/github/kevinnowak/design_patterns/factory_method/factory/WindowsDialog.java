package com.github.kevinnowak.design_patterns.factory_method.factory;

import com.github.kevinnowak.design_patterns.factory_method.buttons.Button;
import com.github.kevinnowak.design_patterns.factory_method.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
