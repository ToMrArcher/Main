package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable extends MyArrayList {

    @Override
    public void add(int index, Object value) {
        if(this.size < data.length){
            super.add(index, value);
        }
        else{
            Object[] temp = new Object[size*2];
            for(int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }
            this.data = temp;
            super.add(index, value);
        }

    }
}
