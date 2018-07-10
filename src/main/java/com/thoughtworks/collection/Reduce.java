package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer.MIN_VALUE, Integer::max);    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingInt(x->x));    }

    public double getOrderedMedian() {
        List<Integer> list =  arrayList.stream().sorted().collect(Collectors.toList());
        if (list.size() % 2 == 0)
            return (list.get((list.size()-1)/2)+list.get(list.size()/2))/2.0;
        else
            return 1.0*list.get(list.size() / 2);
    }
    public int getFirstEven() {
        return arrayList.stream().filter(x->x%2==0).findFirst().get();    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream().filter(x->x%2==0).findFirst().get());    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        List<Integer> listTemp = arrayList.stream().sorted().collect(Collectors.toList());
        double middle;
        int size = arrayList.size();
        if(size %2 == 0){
            middle = ((arrayList.get(size/2-1)+arrayList.get(size/2))/2.0);
        }else{
            int inx = size/2;
            middle = arrayList.get(inx);
        }
        return  middle;
    }
    public int getLastOdd() {
        List<Integer> list = arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        return list.get(list.size()-1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> list = arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        return arrayList.indexOf(list.get(list.size()-1));
    }
}
