package lambda_functional_programming;

import java.util.ArrayList;
import java.util.List;

public class Fp_04 {
    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);
        System.out.println("uzunlugu12denAzMi(liste) = " + uzunlugu12denAzMi(liste));
        System.out.println("xIleBaslamiyorMu(liste) = " + xIleBaslamiyorMu(liste));
        System.out.println("rIleBitiyorMu(liste) = " + rIleBitiyorMu(liste));


    }

//9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.

public static boolean uzunlugu12denAzMi(List<String>list){


        return list.stream().allMatch(t->t.length()<12);
    }


    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

    public static boolean xIleBaslamiyorMu(List<String>list){

        return list.stream().noneMatch(t->t.startsWith("X"));
    }

    //11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitiyorMu(List<String>list){

        return list.stream().anyMatch(t->t.endsWith("r"));
    }
}