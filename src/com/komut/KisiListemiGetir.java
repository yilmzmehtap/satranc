/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

import java.util.ArrayList;

/**
 *
 * @author Lab
 */
public class KisiListemiGetir extends Komut{

    public ArrayList<String> kisilerim = new ArrayList<>();
    public KisiListemiGetir(String kimden, String kime) {
        super(kimden, kime);
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.kisiListemiGetirYonet(this);
    }
    
}

    

