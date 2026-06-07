package com.github.kevinnowak.design_patterns.factory_method;

import com.github.kevinnowak.design_patterns.factory_method.factory.Dialog;
import com.github.kevinnowak.design_patterns.factory_method.factory.HtmlDialog;
import com.github.kevinnowak.design_patterns.factory_method.factory.WindowsDialog;

public class Demo {

    private static Dialog dialog;

    static void main() {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 11")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
