package com.company;
import java.io.File;

public class DirectoryLister {

    public static void listDirectory(File[] file)
    {
        for (File value : file) {
            if (value.isDirectory()) {
                printDirectory("->",value);
            } else {
                printFile("->", value);
            }
        }
    }

    public static void listFiles(File fileList, String separator)
    {
        File file[] = fileList.listFiles();
        for(int i = 0 ; i < file.length ; i++)
        {
            if(file[i].isDirectory())
            {
                printDirectory(separator, file[i]);
            }
            else
            {
                printFile(separator, file[i]);
            }
        }
    }

    private static void printDirectory(String separator, File file) {
        printFile(separator, file);
        listFiles(file,"--"+ separator);
    }
    private static void printFile(String separator, File value) {
        System.out.println(separator + value.getName());
    }


}
