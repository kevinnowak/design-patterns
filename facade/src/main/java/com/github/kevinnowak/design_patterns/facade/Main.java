package com.github.kevinnowak.design_patterns.facade;

import com.github.kevinnowak.design_patterns.facade.facade.VideoConversionFacade;

import java.io.File;

public class Main {

    static void main() {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
