package com.gj.common.oss;

import java.io.IOException;
import java.io.InputStream;

public class FileTypeHelper {

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static String getFileContent(InputStream is) throws IOException {
        byte[] b = new byte[28];

        InputStream inputStream = null;

        try {
            is.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }

    public static FileType getType(InputStream is) throws IOException {
        String fileHead = getFileContent(is);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }

    public static boolean isFileType(String fileType, String[] fileTypes) {
        if (fileType == null) {
            return false;
        }
        for (String tmpFileType : fileTypes) {
            if (tmpFileType.equals(fileType)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isVideo(String fileType) {
        String[] videos = {"AVI", "RAM", "RM", "MPG", "MPEG", "MOV", "ASF", "MP4", "FLV", "MID", "MIDI"};
        return isFileType(fileType, videos);
    }

    public static boolean isPic(String fileType) {
        String[] pics = {"JPG", "JPEG", "PNG", "GIF", "TIFF", "BMP", "DWG", "PSD"};
        return isFileType(fileType, pics);
    }

    public static boolean isDoc(String fileType) {
        String[] docs = {
                "RTF", "XML", "HTML", "CSS", "JS", "EML", "DBX", "PST", "VSD", "ZIP", "RAR", "JSP", "JAVA", "CLASS",
                "JAR", "CHM", "DOC", "DOCX", "XLS", "XLSX", "PPT", "PPTX", "PDF"};
        return isFileType(fileType, docs);
    }

    public static boolean isAudio(String fileType) {
        String[] audios = { "WAV", "MP3",  };
        return isFileType(fileType, audios);
    }

}
