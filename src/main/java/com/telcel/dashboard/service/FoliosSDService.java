/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.service;


import com.telcel.dashboard.entity.FoliosSD;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel
 */
public interface FoliosSDService {
    
    public List<FoliosSD> getAllFoliosAttended();
    
    public void getDetalleXLSX(HttpServletResponse response, String fechaFin)throws IOException;
    
}
