package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp04_2 {

    public static void main(String[] args) {
        Fp04_Courses courseTurkishDay = new Fp04_Courses("Summer", "Turkish Day", 97, 128);
        Fp04_Courses courseTurkishNight = new Fp04_Courses("Winter", "Turkish Night", 98, 154);
        Fp04_Courses courseEnglishDay = new Fp04_Courses("Spring", "English Day", 95, 132);
        Fp04_Courses courseEnglishNight = new Fp04_Courses("Winter", "English Night", 93, 144);

        List<Fp04_Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println("ortalamaPuanlarVerilenSayidanBuyukMu: "+ ortalamaPuanlarVerilenSayidanBuyukMu(coursesList,10));
        System.out.println("kelimeKursAdlariIcindeVarMi: "+kelimeKursAdlariIcindeVarMi(coursesList,"X"));
        ortalamasiEnYuksekKursunAdiniYazdir(coursesList);
        System.out.println(ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(coursesList,3));


    }

    //1)Tüm ortalama puanların verilen sayıdan büyük olup olmadığını kontrol etmek için bir method oluşturun.
    public static boolean ortalamaPuanlarVerilenSayidanBuyukMu(List<Fp04_Courses> list, double x){

        return list.stream().allMatch(t->t.getAverageScore()>x);

    }

    //2)Kurs adlarından en az birinin verilen kelimeyi içerip içermediğini kontrol etmek için bir method oluşturun
    public static boolean kelimeKursAdlariIcindeVarMi(List<Fp04_Courses> list, String kelime){

        return list.stream().anyMatch(t->t.getCourseName().contains(kelime));

    }

    //3) Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun
    public static void ortalamasiEnYuksekKursunAdiniYazdir(List<Fp04_Courses> list){

        String sonuc = list.stream().sorted(Comparator.comparing(Fp04_Courses::getAverageScore).reversed()).findFirst().get().getCourseName();

        System.out.println(sonuc);
    }

        //4) List öğelerini artan düzende ortalama puana göre sıralayın ve ilk verilenleri atlayın

    public static List<Fp04_Courses> ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(List<Fp04_Courses> list, int x){

        return list.stream().sorted(Comparator.comparing(Fp04_Courses::getAverageScore)).skip(x).collect(Collectors.toList());

    }
}