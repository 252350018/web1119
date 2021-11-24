package com.zhuoyue.action;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MyAction{

    private static final int _4mb=4*1024*1024;

    public static void main(String[] args) throws IOException {

        ArrayList<WeakReference<byte[]>> list = new ArrayList<>();

        for(int i=0;i<10;i++){

            WeakReference<byte[]> weakRef = new WeakReference<byte[]>(new byte[_4mb]);

            list.add(weakRef);//添加到集合

            for(WeakReference<byte[]> w:list){

                System.out.print(w.get()+" ");

            }

            System.out.println();

        }
        System.out.println("循环结束："+list.size());
        /*
        ArrayList<byte[]> list = new ArrayList<>();
        for(int i=0;i<5;i++){

            list.add(new byte[_4mb]);
            //byte b[]=new byte[_4mb];
        }
        */
        //softref();

    }
    public static void softref(){
        ArrayList<SoftReference<byte[]>> list = new ArrayList<>();
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for(int i=0;i<5;i++){
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[_4mb],queue);
            System.out.println(softReference);
            System.out.println(softReference.get());
            list.add(softReference);
            System.out.println(list.size());
        }
        System.out.println("循环结束");
        for(SoftReference<byte[]> ref:list){
            System.out.println(ref.get());
        }
        //
        System.out.println("******************");
        Reference<? extends byte[]> poll = queue.poll();
        while(poll!=null){
            System.out.println(poll);
            poll=queue.poll();
        }
    }
}







