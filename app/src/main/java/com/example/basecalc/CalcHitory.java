package com.example.basecalc;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.LinkedList;

public class CalcHitory implements Serializable {
    private LinkedList<Integer> history;
    private int size;
    public CalcHitory(){
        history =  new LinkedList<>();
        size = 0;
    }

    public void add(Integer element){
        if(size == 10){
            history.removeFirst();
            history.add(element);
        }else{
            history.add(element);
            size++;
        }
    }

    public void get(int i){
        history.get(i);
    }

    public void clear(){
        history.clear();
        size = 0;
    }
}