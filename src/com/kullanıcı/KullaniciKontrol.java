/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kullanıcı;

import com.komut.ArkadasEkleme;
import com.komut.Komut;
import com.komut.Mesaj;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.komut.KomutYorumla;
import com.satranc.sohbet;


/**
 *
 * @author MEHTAP
 */
public class KullaniciKontrol {
     String sunucuIP;
    int sunucuPort;
    ObjectOutputStream cikis;
    ObjectInputStream giris;
    boolean isDurduruldu = false;
    sohbet ekran;
    public String kullaniciAdi;
    
    KomutYorumla yorumlayici;

    public KullaniciKontrol(sohbet frame, String sunucuIP, int sunucuPort) throws IOException {
        this.ekran = frame;
        this.sunucuIP = sunucuIP;
        this.sunucuPort = sunucuPort;
        yorumlayici = (KomutYorumla) new KullaniciKomutYorumla(this);
        Socket socket = new Socket(sunucuIP, sunucuPort);
        this.cikis = new ObjectOutputStream(socket.getOutputStream());
        this.giris = new ObjectInputStream(socket.getInputStream());
        //todo
        
    }

    public void komutuGonder(ArkadasEkleme arkadasEkleme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isAlive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
