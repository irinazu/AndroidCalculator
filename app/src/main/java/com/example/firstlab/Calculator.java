package com.example.firstlab;

import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class Calculator {

    //private Integer firstArgI=null;
    //private Integer secondArgI=null;

    private Double firstArgF=null;
    private Double secondArgF=0.0;
    private Double argForInput=null;
    private Double res=null;
    private Integer idPst=null;
    private Integer idNew=0;



    private Integer act;

    private StringBuilder stringBuilderSet=new StringBuilder();
    private StringBuilder stringBuilderGet=new StringBuilder();


    public void numTrigger(int id){
        if(idNew==R.id.result){
            stringBuilderSet.setLength(0);
            stringBuilderGet.setLength(0);
            idNew=0;
        }

        switch (id){
            case R.id.zero:
                stringBuilderSet.append("0");
                break;
            case R.id.one:
                stringBuilderSet.append("1");
                break;
            case R.id.two:
                stringBuilderSet.append("2");
                break;
            case R.id.three:
                stringBuilderSet.append("3");
                break;
            case R.id.four:
                stringBuilderSet.append("4");
                break;
            case R.id.five:
                stringBuilderSet.append("5");
                break;
            case R.id.six:
                stringBuilderSet.append("6");
                break;
            case R.id.seven:
                stringBuilderSet.append("7");
                break;
            case R.id.eight:
                stringBuilderSet.append("8");
                break;
            case R.id.nine:
                stringBuilderSet.append("9");
                break;
            case R.id.comma:
                stringBuilderSet.append(".");
                break;
        }

    }

    public void actionTrigger(int id) {
        if (id == R.id.c) {
            stringBuilderGet.setLength(0);
            stringBuilderSet.setLength(0);
            firstArgF = null;
            secondArgF = null;
        }else if(id==R.id.change){
            if(stringBuilderSet.lastIndexOf("-")>-1){
                stringBuilderSet.replace(0,1,"");

            }else{
                stringBuilderSet.insert(0,"-");

            }
        }

        if(stringBuilderSet.length()!=0&&id!=R.id.change&&id!=R.id.c||id==R.id.result) {
            if (id == R.id.result) {
                idNew = R.id.result;
                /*if(stringBuilderSet.length()==0){

                }*/
            }
            if(id==R.id.x){
                if(stringBuilderSet.length()!=0){
                    Double del;
                    del = 1/Double.parseDouble(stringBuilderSet.toString());
                    if (del % 1 == 0.0) {
                        String arr[] = Double.toString(del).split("\\.");
                        stringBuilderSet.setLength(0);
                        stringBuilderSet.append(arr[0]);
                    } else {
                        stringBuilderSet.setLength(0);
                        stringBuilderSet.append(del);
                    }

                }
            }else if(id==R.id.sqrt){
                if(stringBuilderSet.length()!=0){
                    Double del;
                    del = Math.sqrt(Double.parseDouble(stringBuilderSet.toString()));
                    if (del % 1 == 0.0) {
                        String arr[] = Double.toString(del).split("\\.");
                        stringBuilderSet.setLength(0);
                        stringBuilderSet.append(arr[0]);
                    } else {
                        stringBuilderSet.setLength(0);
                        stringBuilderSet.append(del);
                    }

                }
            }
            else {
            if (firstArgF == null) {
                firstArgF = Double.parseDouble(stringBuilderSet.toString());
                stringBuilderSet.setLength(0);
                idPst = id;
                switch (id) {
                    case R.id.x:
                        firstArgF = 1 / firstArgF;
                        stringBuilderGet.append(firstArgF);
                        break;
                }
            } else {
                //stringBuilderSet.setLength(0);
                if(stringBuilderSet.length()!=0){
                    secondArgF = Double.parseDouble(stringBuilderSet.toString());

                }
                stringBuilderSet.setLength(0);

                switch (idPst) {
                    case R.id.plus:
                        //stringBuilderSet.setLength(0);

                        res = firstArgF + secondArgF;
                        secondArgF = 0.0;

                        if (res % 1 == 0.0) {
                            String arr[] = Double.toString(res).split("\\.");
                            firstArgF = Double.parseDouble(arr[0]);
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(arr[0]);
                        } else {
                            firstArgF = res;
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(res);
                        }

                        break;
                    case R.id.minus:
                        //stringBuilderSet.setLength(0);

                        res = firstArgF - secondArgF;
                        secondArgF = 0.0;

                        if (res % 1 == 0.0) {
                            String arr[] = Double.toString(res).split("\\.");
                            firstArgF = Double.parseDouble(arr[0]);
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(arr[0]);
                        } else {
                            firstArgF = res;
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(res);
                        }

                        break;
                    case R.id.division:
                        //stringBuilderSet.setLength(0);
                        res = firstArgF / secondArgF;
                        secondArgF = 0.0;
                        if (res % 1 == 0.0) {
                            String arr[] = Double.toString(res).split("\\.");
                            firstArgF = Double.parseDouble(arr[0]);
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(arr[0]);
                        } else {
                            firstArgF = res;
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(res);
                        }
                        break;
                    case R.id.multipl:
                        //stringBuilderSet.setLength(0);
                        res = firstArgF * secondArgF;
                        secondArgF = 0.0;
                        if (res % 1 == 0.0) {
                            String arr[] = Double.toString(res).split("\\.");
                            firstArgF = Double.parseDouble(arr[0]);
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(arr[0]);
                        } else {
                            firstArgF = res;
                            stringBuilderGet.setLength(0);
                            stringBuilderGet.append(res);
                        }
                        break;

                }
                idPst = id;
                if (idNew!=0){
                    stringBuilderGet.setLength(0);
                    stringBuilderSet.setLength(0);
                    if (firstArgF % 1 == 0.0) {
                        String arr[] = Double.toString(firstArgF).split("\\.");
                        stringBuilderSet.append(arr[0]);
                    } else {
                        stringBuilderSet.append(firstArgF);
                    }
                    firstArgF = null;
                    secondArgF=null;
                }

            }
        }
    }
    }

    public String setTextFromInput(String s){

        return stringBuilderSet.toString();
    }
    //
    public String getTextForInpRes(){
        //stringBuilderGet.append(text);
        return stringBuilderGet.toString();
    }
    public String getText(){
        //stringBuilderGet.append(text);
        return stringBuilderSet.toString();
    }
}
