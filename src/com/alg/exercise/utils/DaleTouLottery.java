package com.alg.exercise.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author ben.gu
 */
public class DaleTouLottery {


    //前区 1~35，选5个，后区 1~12 选2个
    public static void main(String[] args) {
        Set<Integer> fronts = new HashSet<>();
        Set<Integer> behinds = new HashSet<>();
        Random random = new Random();
        while (fronts.size() < 5) {
            fronts.add(random.nextInt(36));
        }
        Random random1 = new Random();
        while (behinds.size() < 2) {
            behinds.add(random1.nextInt(13));
        }
        fronts.forEach(n -> {
                    System.out.print(String.format("%02d", n)+" ");
                }
        );
        System.out.println("");
        System.out.println("==============");
        behinds.forEach(n -> {
                    System.out.print(String.format("%02d", n)+" ");
                }
        );

    }
}
