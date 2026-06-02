package com.github.kevinnowak.design_patterns.facade.some_complex_media_library;

import java.io.File;

public class AudioMixer {

    public File fix(VideoFile result) {
        IO.println("AudioMixer: fixing audio...");

        return new File("tmp");
    }
}
