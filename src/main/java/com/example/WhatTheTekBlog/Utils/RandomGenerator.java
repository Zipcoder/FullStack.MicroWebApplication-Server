package com.example.WhatTheTekBlog.Utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//All credit to Ignatius on SoloLearn
//https://code.sololearn.com/c5g1ONqa324P/#java
public class RandomGenerator {
    public static String generateSentence(int times) {

        String[] greeting={"Hello","Hey","Good morning","Good evening","Welcome","Hi","Good day"};
        String[] pref={"you","they","i'm","I","he","she","it","we"};
        String[] verb={"swam","ran","said","heard","jumped","bought","drank","buying","read","ate","pet","kissed", "sang","helped","drove","hugged","slaped","drew","held","called","messaged","knew","saw"};
        String[] advrb={"had","have","did","was","am","are","is"};
        String[] obj={"car","boat","street","house","town","food","burger","shop","book","clothes","code","java","beer","bank","bed","window","glass","tea","person","family","plane","bed","fish","man","chair","cup","coffee","dog","math","c++","something"};

        String[] ref={"some","a","the"};
        String[] adjtv={"beautiful","red","tall","big","small","awesome","huge","stupid","delicious","smart","sexy","great","masive","ugly","colorful","yellow","blue","cool","dumb","intilegent","crazy","tiny"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(greeting[radgrt()]).append(",").append(" ").append(pref[radpref()]).append(" ").append(verb[radverb()]).append(" ").append(ref[radref()]).append(" ").append(adjtv[radadjtv()]).append(" ").append(obj[radobj()]).append(" ").append("and").append(" ").append(pref[radpref()]).append(" ").append(verb[radverb()]).append(" ").append(ref[radref()]).append(" ").append(adjtv[radadjtv()]).append(" ").append(obj[radobj()]).append(",").append(" ").append("because").append(" ").append(pref[radpref()]).append(" ").append(verb[radverb()]).append(" ").append(ref[radref()]).append(" ").append(adjtv[radadjtv()]).append(" ").append(obj[radobj()]).append(".");
        }
        return stringBuilder.toString();
    }
    public static int radgrt()
    {
        int x=(int)Math.ceil(Math.random()*6);
        return x;
    }
    public static int radpref()
    {
        int y=(int)Math.ceil(Math.random()*7);
        return y;
    }
    public static int radverb()
    {
        int z=(int)Math.ceil(Math.random()*16);
        return z;
    }
    public static int radobj()
    {
        int a=(int)Math.ceil(Math.random()*30);
        return a;
    }
    public static int radadjtv()
    {
        int b=(int)Math.ceil(Math.random()*21);
        return b;
    }
    public static int radref()
    {
        int l=(int)Math.ceil(Math.random()*2);
        return l;
    }

    public static String generateWord() {
        List<String> words = new ArrayList<>();
        File file = new File("src/RandomWords.txt");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                words.add(line);
            }
        } catch (IOException e) {
            // handle exception
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
