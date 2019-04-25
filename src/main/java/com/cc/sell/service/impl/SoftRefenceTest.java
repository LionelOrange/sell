package com.cc.sell.service.impl;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chencheng
 * @date 2019/4/23
 */
public class SoftRefenceTest {

    public static void main(String[] args) {
        House house = new House();
        WeakReference<House> seller = new WeakReference<>(house);
        house = null;
        while (true) {
            if (seller.get() == null) {
                System.out.println("hh");
                break;
            } else {
                System.out.println("seller still has");
            }

        }
    }

    private static void test4() {
        List<SoftReference> list = new ArrayList<>();
        SoftReference<House> buyer;
        int i = 0;
        while (true) {
            buyer = new SoftReference<House>(new House());
            list.add(buyer);
            System.out.println("i=" + (++i));
        }
    }

    private static void test2() {
        House house = new House();
        List<House> list = new ArrayList<>();
        list.add(house);
        house = null;
        while (true) {
            if (list.get(0) == null) {
                System.out.println("house is null");
                break;
            } else {
                System.out.println("house still there");
            }
        }
    }

    private static void test1() {
        House house = new House();
        SoftReference<House> buyer = new SoftReference<House>(house);
        house = null;

        while (true) {
            System.gc();
            System.runFinalization();
            if (buyer.get() == null) {
                System.out.println("house is null");
                break;
            } else {
                System.out.println("house still there");
            }
        }
    }
}

class House {
    private static final Integer DOOR_NUmber = 1000;

    public Door[] doors = new Door[DOOR_NUmber];

    class Door {

    }


}
