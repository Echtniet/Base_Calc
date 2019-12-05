package com.example.basecalc;

public class HitModel {
    private static HitModel myHitModel= null;

    public static HitModel getModel(){
        if (myHitModel == null){
            myHitModel = new HitModel();
        }
        return myHitModel;
    }

    public int size(){
        return myHitory.size();
    }

    public CalcHitory myHitory;

    private HitModel(){
        myHitory = new CalcHitory();
    }

    private void loadHitModel(){
        //myHitory.add("10");
    }
}
