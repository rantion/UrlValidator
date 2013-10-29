package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<URL> validUrls= new ArrayList<URL>();
    public static void main(String[] args) {

        Scanner read = null;
        String text = null;
        try {
            read = new Scanner(new File("/Users/Rachel/Documents/Fish.html"));
            read.useDelimiter("$"); //Regex pattern for end of file.
            text = read.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally{
            read.close();
        }
        findUrls(text);
    }

    public static void findUrls(String text){
        Pattern regex = Pattern.compile("\\\"(http[s]??:\\//)([a-z]{1,3}?){0,1}?((\\.[\\w-]*?){2,3}?)((\\/[\\w-]*?\\.??)*?)([a-z]{1,4}?)\\\"", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(text);
        int count = 0;
        while (search.find()) {
            if(search.group() != null){
            validUrls.add(new URL(search.group()));
            }
        }

    }

}

