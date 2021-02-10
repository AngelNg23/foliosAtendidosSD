/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.repository;

import java.util.List;
import com.telcel.dashboard.entity.FoliosSD;

/**
 *
 * @author Angel
 */
public interface FoliosSDRepository {

    public List<FoliosSD> findAllFoliosAttended(String fechaFin);
    
}