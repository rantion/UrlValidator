package com.company;

import java.util.Formatter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 10/17/13
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class FormatReceipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private String ItemWidth,OriginalSpacing, PrintItemSpacing, TotalSpacing;
    private final String QtyWidth = "10";
    private final String PriceWidth = "10";
    private ArrayList <InvoiceItems> items = new ArrayList<InvoiceItems>();
    private InvoiceItems item1, item2, item3;
    private int tempLength,longestLength;


    public FormatReceipt(){
        createAndAddItems();
        findLongest();
        setWidths();
        printTitle();
        print(item1.getDescription(),item1.getQuantity(),item1.getPrice());
        print(item2.getDescription(),item2.getQuantity(),item2.getPrice());
        print(item3.getDescription(),item3.getQuantity(),item3.getPrice());
        printTotal();
    }
    public void printTitle(){
        f.format(OriginalSpacing, "Description", "Quantity", "Price");
        f.format(OriginalSpacing, "-----------", "--------", "-----");
    }

    public void print(String name, int qty, double price){
        f.format(PrintItemSpacing, name, qty, price);
        total += price * qty;
    }

    public void printTotal(){
        f.format(TotalSpacing, "Tax", "", total * 0.06);
        f.format(OriginalSpacing, "", "", "-----");
        f.format(TotalSpacing, "Total", "", total*1.06);

    }

    public void setWidths(){
        OriginalSpacing = ("%-"+ItemWidth+"s %"+QtyWidth+"s %"+PriceWidth+"s\n");
        PrintItemSpacing = ("%-" +ItemWidth+ "." +ItemWidth+ "s %" +QtyWidth+ "d %" +PriceWidth+ ".2f\n");
        TotalSpacing =  ("%-"+ItemWidth+"s %"+QtyWidth+"s %"+PriceWidth+".2f\n");
    }

    public String findLongest(){
        longestLength = 0;
        for(InvoiceItems item:items){
           tempLength = item.getDescription().length();
            if(tempLength > longestLength){
                longestLength = tempLength;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(longestLength);
                ItemWidth = sb.toString();
            }
        }
        return ItemWidth;
    }

    public void createAndAddItems(){

        item1 = new InvoiceItems("Hard Drive Enclosure", 3,19.99);
        item2 = new InvoiceItems("SATA Cable", 10, 11.50);
        item3 = new InvoiceItems("1 TB HD",1,145.80);
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }

    public static void main(String[] args) {
        FormatReceipt receipt = new FormatReceipt();








    }
}
