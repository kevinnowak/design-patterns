package com.github.kevinnowak.design_patterns.facade.some_complex_media_library;

public class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();

        if (type.equals("mp4")) {
            IO.println("CodecFactory: extracting mpeg audio...");

            return new MPEG4CompressionCodec();
        } else {
            IO.println("CodecFactory: extracting ogg audio...");

            return new OggCompressionCodec();
        }
    }
}
