package com.github.kevinnowak.design_patterns.facade.some_complex_media_library;

public class BitrateReader {

    public static VideoFile read(VideoFile file, Codec codec) {
        IO.println("BitrateReader: reading file...");

        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        IO.println("BitrateReader: writing file...");

        return buffer;
    }
}
