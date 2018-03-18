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
public class OturumAcma extends Komut{

   public String kullaniciAdi;
    public String parola;
    public boolean isAcma;

    public OturumAcma(String kullaniciAdi, String parola, boolean acma) {
      super(kullaniciAdi,null);
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.isAcma = isAcma; 
    }

    @Override
    public void calistir(KomutYorumla kmt) {
         kmt.oturumAcmaKomutuYonet(this);
    }
    
}
