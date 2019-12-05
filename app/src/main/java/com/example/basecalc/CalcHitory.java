package com.example.basecalc;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.LinkedList;

public class CalcHitory implements Serializable {
    private LinkedList<CalcObject> history;
    private int size;
    public CalcHitory(){
        history =  new LinkedList<>();
        size = 0;
    }

    public void add(CalcObject element){
        if(size == 10){
            history.removeFirst();
            history.add(element);
        }else{
            history.add(element);
            size++;
        }
    }

    public int size(){
        return size;
    }

    public CalcObject get(int i){
        return history.get(i);
    }

    public void clear(){
        history.clear();
        size = 0;
    }
}

class CalcObject{
    public String value;
    public String base;

    public CalcObject(){
        value = "1";
        base = "2";
    }
    public CalcObject(String value, String base){
        this.value = value;
        this.base = base;
    }
}