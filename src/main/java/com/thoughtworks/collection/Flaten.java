package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> temp = new ArrayList<>();
        for(Integer[] list : array){
            for(Integer integer : list){
                temp.add(integer);
            }
        }
        return temp;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
       return transformToOneDimesional()
               .stream().distinct().collect(Collectors.toList());
    }
}
