package com.gj.demo.filepart;

import java.io.File;
import java.util.Comparator;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/24
 */
public class FileComparator implements Comparator<File> {
    public int compare(File o1, File o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
