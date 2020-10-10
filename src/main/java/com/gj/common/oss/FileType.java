package com.gj.common.oss;

public enum FileType {
    /**
     * JEPG.
     */
    JPEG("FFD8FF"),
    JPEG_STR("JPEG"),
    JPG_STR("JPG"),

    /**
     * PNG.
     */
    PNG("89504E47"),
    PNG_STR("PNG"),

    /**
     * GIF.
     */
    GIF("47494638"),
    GIF_STR("GIF"),

    /**
     * TIFF.
     */
    TIFF("49492A00"),
    TIFF_STR("TIFF"),

    /**
     * Windows Bitmap.
     */
    BMP("424D"),
    BMP_STR("BMP"),

    /**
     * CAD.
     */
    DWG("41433130"),
    DWG_STR("DWG"),

    /**
     * Adobe Photoshop.
     */
    PSD("38425053"),
    PSD_STR("PSD"),

    /**
     * Rich Text Format.
     */
    RTF("7B5C727466"),
    RTF_STR("RTF"),

    /**
     * XML.
     */
    XML("3C3F786D6C"),
    XML_STR("XML"),

    /**
     * HTML.
     */
    HTML("68746D6C3E"),
    HTML_STR("HTML"),
    /**
     * CSS.
     */
    CSS("48544D4C207B0D0A0942"),
    CSS_STR("CSS"),
    /**
     * JS.
     */
    JS("696B2E71623D696B2E71"),
    JS_STR("JS"),
    /**
     * Email [thorough only].
     */
    EML("44656C69766572792D646174653A"),
    EML_STR("EML"),

    /**
     * Outlook Express.
     */
    DBX("CFAD12FEC5FD746F"),
    DBX_STR("DBX"),

    /**
     * Outlook (pst).
     */
    PST("2142444E"),
    PST_STR("PST"),

    /**
     * MS Word/Excel.
     */
    XLS_DOC("D0CF11E0"), XLSX_DOCX("504B030414000600080000002100"),
    XLS_STR("XLS"), XLSX_STR("XLSX"),

    DOC_STR("DOC"), DOCX_STR("DOCX"),
    PPT_STR("PPT"), PPTX_STR("PPTX"),
    /**
     * Visio
     */
    VSD("d0cf11e0a1b11ae10000"),
    /**
     * MS Access.
     */
    MDB("5374616E64617264204A"),
    /**
     * WPS文字wps、表格et、演示dps都是一样的
     */
    WPS("d0cf11e0a1b11ae10000"),
    /**
     * torrent
     */
    TORRENT("6431303A637265617465"),
    /**
     * WordPerfect.
     */
    WPD("FF575043"),

    /**
     * Postscript.
     */
    EPS("252150532D41646F6265"),

    /**
     * Adobe Acrobat.
     */
    PDF("255044462D312E"),
    PDF_STR("PDF"),

    /**
     * Quicken.
     */
    QDF("AC9EBD8F"),

    /**
     * Windows Password.
     */
    PWL("E3828596"),

    /**
     * ZIP Archive.
     */
    ZIP("504B0304"),
    ZIP_STR("ZIP"),

    /**
     * RAR Archive.
     */
    RAR("52617221"),
    RAR_STR("RAR"),
    /**
     * JSP Archive.
     */
    JSP("3C2540207061676520"),
    /**
     * JAVA Archive.
     */
    JAVA("7061636B61676520"),
    /**
     * CLASS Archive.
     */
    CLASS("CAFEBABE0000002E00"),
    /**
     * JAR Archive.
     */
    JAR("504B03040A000000"),
    /**
     * MF Archive.
     */
    MF("4D616E69666573742D56"),
    /**
     *EXE Archive.
     */
    EXE("4D5A9000030000000400"),
    /**
     *CHM Archive.
     */
    CHM("49545346030000006000"),
    /*
     * INI("235468697320636F6E66"), SQL("494E5345525420494E54"), BAT(
     * "406563686F206f66660D"), GZ("1F8B0800000000000000"), PROPERTIES(
     * "6C6F67346A2E726F6F74"), MXP(
     * "04000000010000001300"),
     */
    /**
     * Wave.
     */
    WAV("57415645"),
    WAV_STR("WAV"),

    /**
     * AVI.
     */
    AVI("41564920"),
    AVI_STR("AVI"),

    /**
     * Real Audio.
     */
    RAM("2E7261FD"),
    RAM_STR("RAM"),

    /**
     * Real Media.
     */
    RM("2E524D46"),
    RM_STR("RM"),

    /**
     * MPEG (mpg).
     */
    MPG("000001BA"),
    MPG_STR("MPG"), MPEG_STR("MPEG"),

    /**
     * Quicktime.
     */
    MOV("6D6F6F76"),
    MOV_STR("MOV"),

    /**
     * Windows Media.
     */
    ASF("3026B2758E66CF11"),
    ASF_STR("ASF"),

    /**
     * MIDI.
     */
    MID("4D546864"),
    MID_STR("MID"), MIDI_STR("MIDI"),
    /**
     * MP4.
     */
    MP4("00000020667479706d70"),
    MP4_STR("MP4"),
    /**
     * MP3.
     */
    MP3("49443303000000002176"),
    MP3_STR("MP3"),
    /**
     * FLV.
     */
    FLV("464C5601050000000900"),
    FLV_STR("FLV");

    private String value = "";

    FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
