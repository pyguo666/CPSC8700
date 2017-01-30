package com.yang.Beans;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.*;
import  java.util.*;
/**
 * Created by GY on 12/1/2016.
 */
public class UserBean {
    private String username;
    private String password;

    public Dish getPref() {
        return pref;
    }

    public void setPref(Dish pref) {
        this.pref = pref;
    }

    private Dish pref;


    public List<Dish> getPrefList() {
        return prefList;
    }

    public void setPrefList(List<Dish> prefList) {
        this.prefList = prefList;
    }

    private List<Dish> prefList = new List<Dish>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Dish> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Dish dish) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Dish> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Dish> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Dish get(int index) {
            return null;
        }

        @Override
        public Dish set(int index, Dish element) {
            return null;
        }

        @Override
        public void add(int index, Dish element) {

        }

        @Override
        public Dish remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Dish> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Dish> listIterator(int index) {
            return null;
        }

        @Override
        public List<Dish> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void test(String u, String p){
        username = u;
        password = p;
        Dish newDish = new Dish();
        newDish.setDishID(23);
        newDish.setDishName("baidu");
        newDish.setDishURL("www.baidu.com");
        pref = newDish;

    }

    public void testList(String u, String p){
        username = u;
        password = p;
        Dish newDish = new Dish();
        newDish.setDishID(23);
        newDish.setDishName("baidu");
        newDish.setDishURL("www.baidu.com");
        pref = newDish;
        prefList.add(newDish);

        Dish newDish1 = new Dish();
        newDish1.setDishID(15);
        newDish1.setDishName("google");
        newDish1.setDishURL("www.gugou.com");

        prefList.add(newDish1);
    }


}
