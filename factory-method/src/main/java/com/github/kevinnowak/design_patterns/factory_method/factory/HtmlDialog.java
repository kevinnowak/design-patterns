package com.github.kevinnowak.design_patterns.factory_method.factory;

import com.github.kevinnowak.design_patterns.factory_method.buttons.Button;
import com.github.kevinnowak.design_patterns.factory_method.buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
