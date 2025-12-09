package com.example.przepisy;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    private static ArrayList<Przepis> przepisy;

    private static void generujPrzepisy(){
        przepisy = new ArrayList<>();
        przepisy.add(new Przepis("wymieszac upiec zjesc", "czekolada, maka, mleko, jajka, maslo, cukier", R.drawable.murzynek, "ciasta", "Murzynek",1));
        przepisy.add(new Przepis("upiec udekorowac zjesc", "maka, mleko, jajka, cukier", R.drawable.pieeniki, "ciasteczka", "Pierniczki", 2));
        przepisy.add(new Przepis("ciasto z makiem", "mak, jajka, mleko, cukier", R.drawable.makowiec, "ciasta", "Makowiec", 3));
        przepisy.add(new Przepis("przepis2"));
        przepisy.add(new Przepis("przepis3"));
        przepisy.add(new Przepis("przepis4"));

    }

    public static ArrayList<Przepis> getPrzepisy(){
        generujPrzepisy();
        return przepisy;
    }

    public static Przepis zwrocPrzepisoId(int id){
        generujPrzepisy();
        for (Przepis przepis:przepisy){
            if(przepis.getIdPrzepisy() == id){
                return przepis;
            }
        }
        return przepisy.get(0);
    }
    public static ArrayList<Przepis> zwrocPrzepisyZKategorii(String kategoria){
        ArrayList<Przepis> przepisyZKategorii = new ArrayList<>();
        getPrzepisy();

        for (Przepis przepis:przepisy) {
            if (przepis.getKategoria().equals(kategoria)) {
                przepisyZKategorii.add(przepis);
            }

        }
        return przepisyZKategorii;
    }
}
