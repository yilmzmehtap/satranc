/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;
import java.util.Vector;
/**
 *
 * @author MEHTAP
 */
public class Goruntu extends Komut{
        public Vector<byte[]> images = new Vector<>(10);

    public Goruntu(String kimden, String kime) {
        super(kimden, kime);
    }

    public void add(byte[] img) {
        images.add(img);
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.goruntuKomutuYonet(this);
    }

    public int size() {
        return images.size();
    }

    public void clear() {
        images.clear();
    }

}
