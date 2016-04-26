/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.upro.winfoo.web.pgm;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author beaufils
 */
public class PgmFile {

    MultipartFile file;

    public MultipartFile getFile() {    
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
