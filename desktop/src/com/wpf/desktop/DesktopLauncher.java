package com.wpf.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wpf.presentation.WPF;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "WPF";
        config.width = 640;
        config.height = 360;
        config.resizable = false;

        new LwjglApplication(new WPF(), config);
    }
}