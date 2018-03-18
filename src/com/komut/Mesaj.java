/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

/**
 *
 * @author MEHTAP
 */
public class Mesaj  extends Komut{
     public String mesaj;

    public Mesaj(String kimden, String kime, String mesaj) {
        super(kimden, kime);
        this.mesaj = mesaj;
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.mesajKomutuYonet(this);
    }

    @Override
    public String toString() {
        return kimden + "\t:" + mesaj + "\n";
    }

    
}
