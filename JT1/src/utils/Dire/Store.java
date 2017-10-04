package utils.Dire;

import utils.Girl.Girls;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by faithpercious on 2017/10/4.
 */
public class Store {
    private HashMap<Girls,Integer> learn;
    private int totalprice;//表示总价格

    public Store() {
        learn=new HashMap<Girls, Integer>();
        totalprice=0;
    }

    public HashMap<Girls, Integer> getLearn() {
        return learn;
    }

    public void setLearn(HashMap<Girls, Integer> learn) {
        this.learn = learn;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public  boolean addlearnthings(Girls girls,int i){
        if (learn.containsKey(girls)){
            learn.put(girls,learn.get(girls)+i);
        }
        else {
            learn.put(girls,i);
        }
        TotalPrice();//每次增减重新算总价
        return true;
    }
    public  boolean removelearnthings(Girls girls){
        learn.remove(girls);
        TotalPrice();
        return true;
    }
    public int TotalPrice(){
        int sum=0;
        Set<Girls>keysets=learn.keySet();//拿到键的集合
        Iterator<Girls> g=keysets.iterator();//拿到迭代器对象
        while (g.hasNext()){
            Girls h=g.next();
            sum += h.getMoney()*learn.get(h);//拿到单价乘数量，map键值对，g为键，xxx.get(g)为值
        }
        this.setTotalprice(sum);
        return this.getTotalprice();
    }

    public static void main(String[] args) {
      Girls g1=new Girls(1,"5.jpg","尘霜",20);
        Girls g2=new Girls(2,"7.jpg","雪霜",20);
        Store store=new Store();
        store.addlearnthings(g1,2);
        store.addlearnthings(g2,4);
        store.addlearnthings(g1,4);
        Set<Map.Entry<Girls,Integer>> gh=store.getLearn().entrySet();
        for (Map.Entry<Girls,Integer> obj:gh){
            System.out.println(obj);
        }
        System.out.println(store.getTotalprice());
    }
}
