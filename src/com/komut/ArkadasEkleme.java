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
public class ArkadasEkleme extends Komut {

    
    public boolean isEklenecek;
    public String islemYapilacakKullaniciAdi; 
    public ArkadasEkleme(String kimden, String yeniArkadas, boolean isEklenecek) {
        super(kimden, null);
        this.islemYapilacakKullaniciAdi = yeniArkadas;
        this.isEklenecek = isEklenecek; 
               
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.arkadasEklemeYonet(this);
    
}
}