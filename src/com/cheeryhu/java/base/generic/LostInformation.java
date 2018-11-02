package com.cheeryhu.java.base.generic;

import java.util.*;

public class LostInformation {
    public static void main(String[] args){
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkie> map = new HashMap<>();
        Quark<Fnorkie> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}

class Frob{}
class Fnorkie{}
class Quark<Q>{}
class Particle<P,M>{}
