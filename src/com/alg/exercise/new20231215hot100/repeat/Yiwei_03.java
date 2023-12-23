package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/19 下午9:02
 */
public class Yiwei_03 {
    public static void main(String[] args) {
        String s  = "cbaebabacd";
        String p= "abc";
        Yiwei_03 t = new Yiwei_03();
        List<Integer> res = t.findAnagrams(s, p);
        CollectionPrintUtils.printList(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int i =0 ,j =0 ;
        int len = s.length();
        int winsize = p.length();
        String encoded= endcode(p);
        for(;i<len;i++){
            if(i-j+1 == winsize){
                if(yiwei(s,j,i,encoded)){
                    res.add(j);
                }
                j++;
            }
        }
        return res;

    }

    private boolean yiwei(String s,int start,int end,String encoded){
        char[] count = new char[26];

        for(int i = start ;i <= end ;i++){
            char  cur = s.charAt(i);
            int pos = cur - 'a';
            count[pos] ++;
        }
        String ens = new String(count);

        return ens.equals(encoded);
    }

    private String endcode(String p){
        char[] count1 = new char[26];
        for(int i = 0 ;i < p.length() ;i++){
            char  cur = p.charAt(i);
            int pos = cur - 'a';
            count1[pos] ++;
        }
        return new String(count1);
    }
}
