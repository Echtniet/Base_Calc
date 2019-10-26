package com.example.basecalc;

public class HitModel {
    private static HitModel myHitModel= null;

    public static HitModel getModel(){
        if (myHitModel == null){
            myHitModel = new HitModel();
        }
        return myHitModel;
    }

    public CalcHitory myHitory;

    private HitModel(){
        myHitory = new CalcHitory();
    }

    private void loadHitModel(){

    }
}
