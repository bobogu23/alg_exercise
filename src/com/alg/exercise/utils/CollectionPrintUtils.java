package com.alg.exercise.utils;

import java.util.Arrays;
import java.util.List;

public class CollectionPrintUtils {

    public static void printList(List l){
        StringBuilder sb = new StringBuilder("[");
        l.forEach(e-> sb.append(e.toString()).append(","));
        String res = (sb.length() > 1 ? sb.substring(0,sb.length()-1):sb.toString()) +"]" ;
        System.err.println(res);
    }
    public static void printNestedIntArray(List<List<Integer>> l){
        l.forEach(CollectionPrintUtils::printList);
    }
    public static void printNestedIntArray(int[][] l){
        Arrays.asList(l).forEach(CollectionPrintUtils::printArray);
    }

    public static void printArray(int[] l){
        StringBuilder sb = new StringBuilder("[");
        for(int el:l){
            sb.append(el).append(",");
        }
        String res = (sb.length() > 1 ? sb.substring(0,sb.length()-1):sb.toString()) +"]" ;
        System.err.println(res);
    }

}
