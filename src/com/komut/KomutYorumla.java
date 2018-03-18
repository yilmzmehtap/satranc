/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;
import java.io.Serializable;

/**
 *
 * @author MEHTAP
 */
public interface KomutYorumla extends Serializable{
    
    public void OturumAcmaKomutuYonet (OturumAcma login);
    
    public void GoruntuKomutuYonet (Goruntu goruntu);
    
    public  void dosyaKomutuYonet(Dosya dosya);
    
    public void mesajKomutuYonet(Mesaj mesaj);
    
    public void hamleKomutuYonet(Hamle hamle);
    
    public void elsikismaKomutuYonet(ElSikisma elSikisma);
    
   public void kullaniciKayitEkleYonet(KullaniciKayitEkle aThis);
   
    public void kisiListemiGetirYonet(KisiListemiGetir aThis);
    
    public void arkadasEklemeYonet(ArkadasEkleme aThis);

    public void oturumAcmaKomutuYonet(OturumAcma aThis);

    public void goruntuKomutuYonet(Goruntu aThis);

    
}
