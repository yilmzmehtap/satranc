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
public class Dosya extends Komut{
        String dosyaAdi;
    String dosyaTuru;
    byte[] data;

    public Dosya(String kimden, String kime, String dosyaAd, String dosyaTuru, byte[] data) {
        super(kimden, kime);
        this.dosyaTuru = dosyaTuru;
        this.dosyaAdi = dosyaAd;
        this.data = data;
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

