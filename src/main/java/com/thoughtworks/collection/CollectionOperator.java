package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {

        List<Integer> list = getNumToArray(left,right);
        if (right < left) {
            Collections.reverse(list);
        }
        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> list = getNumToArray(left,right);
        return (List<Integer>) list.stream()
                .filter(x-> x%2 == 0);
    }

    public List<Integer> popEvenElments(int[] array) {
        throw new NotImplementedException();
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list1 = Arrays.stream( firstArray ).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream( secondArray ).boxed().collect(Collectors.toList());
        List<Integer> list=list1.stream().filter(t->list2.contains(t)).collect(Collectors.toList());
        return  list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
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
