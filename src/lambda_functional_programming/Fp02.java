package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);


        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        getMaxEleman2(liste);
        System.out.println();
        minValue(liste);
        System.out.println();
        getMinEleman02(liste);
        System.out.println();
        yedidenBuyukMin(liste);
        System.out.println();
        getYedidenBuyukCiftMin2(liste);
        System.out.println();
        getTersSiralamaylaTekrarsizElemanlarinYarisi(liste);

    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.


    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {  // list yerine elma armut da yazabiliriz (dinamik yapi)

        Integer carpim = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        // reduce ile tek degere dusurecegiz. carpimi tek sonuc olarak verecek
        System.out.println(carpim);


    }


    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    ///1.yol
    public static void getMaxEleman(List<Integer> list) {

        Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);  // recuce ile cok elemani teke dusurduk

        //    soruda en buyuk deger soruldugu icin Integer.MIN_VALUE ile biz alacagı en kucuk degeri t ye atadık

        // Integer max =  list.stream().distinct().reduce(list.get(0),(t,u)->t>u ? t: u);

        System.out.println(max);
    }

    //2 .yol

    public static void getMaxEleman2(List<Integer> list) {

        Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);
        System.out.println("max = " + max);

        // sorted ile en kucukten sıralama yapıldıgı icin ilk deger olan Integer.MIN_VALUE  t den baslayacak bu yuzden u degerine atama yaptık
        //   soruda en buyuk deger soruldugu icin Integer.MIN_VALUE ile biz alacagı en kucuk degeri t ye atadık u donecek

    }


    //Ödev
    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)

  //1.yol
    public  static void minValue( List<Integer> liste) {
        Integer min =liste.stream().distinct().reduce(liste.get(0),(t, u) -> t<u ? t : u);
        System.out.print("min value = " + min);
    }

    //2.yol
    public static void getMinEleman02(List<Integer> list) {

        Integer min2= list.stream().distinct().reduce(Integer.MAX_VALUE,(t,u)-> u);
        System.out.print(min2);
    }

    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.


    //1.yol
    public static void yedidenBuyukMin(List<Integer> list) {

        Integer min = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);  //ternary kullnadık
        // bu soruda da Integer.MAX_VALUE ile en buyuk dgeri aldık

        System.out.println("yediden buyuk min = "+min);


    }

    //2.yol

    public static void getYedidenBuyukCiftMin2(List<Integer> list){

        Integer min= list.stream().distinct().filter(t->t%2==0).filter(t->t>7).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u);

        System.out.print(min);


    }


    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

        public static void getTersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list){


        List<Double> sonuc=list.stream().distinct().filter(t->t>5).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        // 2.0 ile double yapmıs olduk auto widening
        // collect metodunu soruda list donmesi stendigi icin toplayici olarak kullandık.

            System.out.print("sonuc = " + sonuc);
        }

}
