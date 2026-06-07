package com.github.kevinnowak.design_patterns.factory_method.buttons;

public class HtmlButton implements Button {

    @Override
    public void render() {
        IO.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        IO.println("Click! Button says - 'Hello World!'");
    }
}
