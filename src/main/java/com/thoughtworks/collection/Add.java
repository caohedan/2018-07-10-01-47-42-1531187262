package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> list = getNumToArray(leftBorder,rightBorder);
        return  list.stream().filter((x)->x%2==0).reduce(Integer::sum).get();

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> list = getNumToArray(leftBorder,rightBorder);
        return  list.stream().filter((x)->x%2==1).reduce(Integer::sum).get();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = arrayList.stream()
                .mapToInt(w -> w*3+2)
                .sum();
        return  sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return  arrayList.stream().map((x)->{
            if(x%2!=0)
                return 3*x+2;
            else
                return x;

        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return  arrayList.stream()
                .filter((x)->x%2==1)
                .map(x->x*3+5)
                .reduce((sum, x) -> sum + x)
                .get();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
          int count = (int) arrayList.stream().count();
                return arrayList.get(count/2);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
         return  arrayList.stream().
                filter(x->x%2 == 0)
                . reduce((sum, x) -> sum + x)
                .get()/2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return  arrayList.stream().
                filter((x)->x%2==0).
                collect(Collectors.toList()).
                contains(specialElment);

    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream()
                .filter((x)->x%2==0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens =  arrayList.stream().filter((x)->x%2==0).sorted().collect(Collectors.toList());
        List<Integer> odds = arrayList.stream().filter((x)->x%2!=0).sorted((a,b)->a>b?-1:1).collect(Collectors.toList());
        evens.addAll(odds);
        return  evens;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        AtomicInteger temp = new AtomicInteger(0);
        arrayList =   arrayList.stream().map((x)->{
            int result = (x+ temp.get())*3;
            temp.set(x);
            return result;
        }).collect(Collectors.toList());
        arrayList.remove(0);
        return arrayList;
    }


    public List<Integer> getNumToArray(int rightBorder,int leftBorder){
        if(rightBorder < leftBorder)
        {
            int temp;
            temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        List<Integer> list = IntStream.range(leftBorder,rightBorder+1).boxed().collect(Collectors.toList());
        return  list;
    }
}
