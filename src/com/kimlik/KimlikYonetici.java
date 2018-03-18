/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimlik;
import com.komut.ArkadasEkleme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
/**
 *
 * @author MEHTAP
 */
public class KimlikYonetici {
    
    private static KimlikYonetici kimlikYönetici;
    public static Object getInstance() {
      if (kimlikYönetici==null){
          kimlikYönetici=new KimlikYonetici();   
        }
        return kimlikYönetici; 
    }
    
    private HashMap<String, Kisi> kisiler;
    private KimlikYonetici() 
    {
        kisileriYukle();
        if(kisiler == null)
        {
            kisiler = new HashMap<>();
        }
    }

     public boolean isDogrula(String kullaniciAdi, String parola) {

        Kisi kisi = kisiler.get(kullaniciAdi);
        if(kisi == null || !kisi.parola.equals(parola))
            return false;
        return true;
    }

    
    public void kisiEkle(Kisi kisi)
    {
        kisiler.put(kisi.kullaniciAdi, kisi);
        kisileriKaydet();
    }
    public void kisiSil(String kullaniciAdi)
    {
        kisiler.remove(kullaniciAdi);
        kisileriKaydet();
    }

    private void kisileriYukle() {
        ObjectInputStream girdi;
        try 
        {
            if(!new File("kisiler.obj").exists()) return;
            girdi = new ObjectInputStream(new FileInputStream("kisiler.obj"));
            kisiler = (HashMap<String, Kisi>) girdi.readObject();
            girdi.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void kisileriKaydet() {
        ObjectOutputStream cikti;
        try 
        {
            cikti = new ObjectOutputStream(new FileOutputStream("kisiler.obj"));
            cikti.writeObject(kisiler);
            cikti.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, Kisi> getKisiler() {
        return kisiler;
    }

    public boolean isKisiVar(String kullaniciAdi) {
        return kisiler.containsKey(kullaniciAdi);
    }

    public String arkadasEkleme(ArkadasEkleme ae) {
        if(!kisiler.containsKey(ae.islemYapilacakKullaniciAdi))
        {
            return "Böyle bir kişi bulunamadı";
        }
        Kisi kisi = kisiler.get(ae.kimden);
        if(ae.isEklenecek)
        {
            if(!kisi.hasArkadas(ae.islemYapilacakKullaniciAdi))
            {
                kisi.arkadasiListemeEkle(ae.islemYapilacakKullaniciAdi);
            }
            else
                return "Bu arkadaşa zaten sahipsiniz.";
        }
        else
        {
            if(kisi.hasArkadas(ae.islemYapilacakKullaniciAdi))
            {
                kisi.arkadasiListemdenCikar(ae.islemYapilacakKullaniciAdi);
            }
            else
                return "Bu arkadaşa sahip degilsiniz.";
        }
        return null;
    }

    public Kisi kisiGetir(String kimden) {
        return kisiler.get(kimden);
    }

    public boolean isCevrimici(String kimden) 
    {
        if(kimden == null || kisiler.get(kimden) == null) return false;
        return kisiler.get(kimden).isCevrimici;
    }

    public void setCevrimici(String kullaniciAdi, boolean b) {
        kisiler.get(kullaniciAdi).isCevrimici = b;
    }
    
    

    
    
    
}

