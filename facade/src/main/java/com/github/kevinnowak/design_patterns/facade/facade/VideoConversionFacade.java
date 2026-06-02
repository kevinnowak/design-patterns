package com.github.kevinnowak.design_patterns.facade.facade;

import com.github.kevinnowak.design_patterns.facade.some_complex_media_library.*;

import java.io.File;

public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        IO.println("VideoConversionFacade: conversion started.");

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;

        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediaResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediaResult);

        IO.println("VideoConversionFacade: conversion completed.");

        return result;
    }
}
