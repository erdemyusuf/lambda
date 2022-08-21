package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp03 {
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

        tekrarsizCiftElemanlarinKareToplami(liste);
        tekrarsizCiftElemanlarinKareToplami02(liste);
        tekrarsizCiftElemanlarinKareToplami03(liste);
        tekrarsizCiftElemanlarinKuplerininCarpimi(liste);
        getMaxEleman(liste);
        yedidenBuyukCiftMin(liste);
        tersSiralamaylaTekrarsizElemanlarinYarisi(liste);




    }


    //5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.


    //1.yol
    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {

        Integer toplam =list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::karesiniAl).reduce(0,Math::addExact);

        System.out.println(toplam);


    }


    //2.yol
    public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer> list) {

        Integer toplam =list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::karesiniAl).reduce(Math::addExact).get();

        System.out.println(toplam);


    }

    //3.yol
    public static void tekrarsizCiftElemanlarinKareToplami03(List<Integer> list) {

        Integer toplam =list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::karesiniAl).reduce(0,Integer::sum);

        System.out.println(toplam);


    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.


    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list) {  // list yerine elma armut da yazabiliriz (dinamik yapi)

        Integer carpim =list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::kupunuAl).reduce(1,Math::multiplyExact);

        // reduce ile tek degere dusurecegiz. carpimi tek sonuc olarak verecek
        System.out.println(carpim);


    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.


    public static void getMaxEleman(List<Integer> list) {

        Integer max = list.stream().distinct().reduce(Math::max).get();

         System.out.println(max);
    }

    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.



    public static void yedidenBuyukCiftMin(List<Integer> list) {

        Integer min = list.stream().distinct().filter(t -> t > 7).filter(Utils::ciftElemanSec).reduce(Math::min).get();

        System.out.println("yediden buyuk cift min = "+min);


    }


//10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

    public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list){


        List<Double> sonuc=list
                .stream()// gerekli metotlari kullnamaya yarar
                .distinct()// tekrarli alanlari almaz
                .filter(t->t>5)// kosula gore filtreleme yapar
                .map(Utils::yarisiniAl) //Her bir elemanın değerini değiştirmeye yarar
                .sorted(Comparator.reverseOrder())// Sıralama yapar
                .collect(Collectors.toList()); // Elamanları collection'a çevirir.


        // collect metodunu soruda list donmesi stendigi icin toplayici olarak kullandık.

        System.out.print("sonuc = " + sonuc);
    }

}