package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(x->x*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(x->letters[x-1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
      return   array.stream().map(x->convertNumberTOLetterStr(x,letters)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List<Integer> listTemp = array.stream().sorted().collect(Collectors.toList());
        Collections.reverse(listTemp);
        return listTemp;
    }

    public List<Integer> sortFromSmall() {
        return  array.stream().sorted().collect(Collectors.toList());
    }
    public String convertNumberTOLetterStr(int number, String[]letterCellection) {
        StringBuilder tmp = new StringBuilder();
        while (number>0){
            tmp.append(letterList.get((number-1)%26));
            number = (number-1)/26;
        }
        tmp.reverse();
        return String.valueOf(tmp);
    }
}
