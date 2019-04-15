package com.example.WhatTheTekBlog.Utils;


//All credit to Ignatius on SoloLearn
//https://code.sololearn.com/c5g1ONqa324P/#java
public class Random {
    public static void main(String[] args) {

        String[] greeting={"Hello","Hey","Good morning","Good evening","Welcome","Hi","Good day"};
        String[] pref={"you","they","i'm","I","he","she","it","we"};
        String[] verb={"swam","ran","said","heard","jumped","bought","drank","buying","read","ate","kicked","hit","kissed","f@*%3d","shot","killed","drove","hugged","slaped","murdered","held","called","messaged","knew","saw"};
        String[] advrb={"had","have","did","was","am","are","is"};
        String[] obj={"car","boat","street","house","town","food","burger","shop","book","clothes","code","java","beer","bank","bed","window","glass","tea","person","family","plane","bed","fish","man","chair","cup","coffee","dog","math","c++","something"};

        String[] ref={"some","a","the"};
        String[] adjtv={"beautiful","red","tall","big","small","awesome","huge","stupid","delicious","smart","sexy","great","masive","ugly","colorful","yellow","blue","cool","dumb","intilegent","crazy","tiny"};

        System.out.println(greeting[radgrt()]+","+" "+pref[radpref()]+" "+verb[radverb()]+" "+ref[radref()]+" "+adjtv[radadjtv()]+" "+obj[radobj()]+" "+"and"+" "+pref[radpref()]+" "+verb[radverb()]+" "+ref[radref()]+" "+adjtv[radadjtv()]+" "+obj[radobj()]+","+" "+"because"+" "+pref[radpref()]+" "+verb[radverb()]+" "+ref[radref()]+" "+adjtv[radadjtv()]+" "+obj[radobj()]+".");
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
    public static int radadvrb()
    {
        int j=(int)Math.ceil(Math.random()*6);
        return j;
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
}
