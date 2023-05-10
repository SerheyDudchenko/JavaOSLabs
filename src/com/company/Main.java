package com.company;
import java.io.File;
import static com.company.DirectoryLister.listDirectory;

public class Main {
    public static void main(String[] args) {

        String directory = System.getProperty("user.dir");
        System.out.println(String.format("current dir = %s", directory));

        File file[] = new File(directory).listFiles();

        listDirectory(file);
    }
}
