/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.serviceImpl;

import com.telcel.dashboard.entity.FoliosSD;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.telcel.dashboard.repository.FoliosSDRepository;
import com.telcel.dashboard.service.FoliosSDService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;

@Service
@Transactional
@Slf4j
public class FoliosSDServiceImpl extends GenericReportingService implements FoliosSDService {

    @Autowired
    private FoliosSDRepository ttRepo;

    @Override
    public List<FoliosSD> getAllFoliosAttended() {
        return ttRepo.findAllFoliosAttended("2021-01-28");
    }

    @Override
    public void getDetalleXLSX(HttpServletResponse response, String fechaFin) throws IOException {
        try {
            InputStream is = new ClassPathResource("templates/excelPrueba.xlsx")
                    .getInputStream();
            ServletOutputStream outputStream = response.getOutputStream();
            List<FoliosSD> foliosList = ttRepo.findAllFoliosAttended(fechaFin);
            
            Context context = new Context();
            context.putVar("foliosList", foliosList);
            JxlsHelper.getInstance().processTemplateAtCell(is, outputStream, context, "Result!A1");
            if (is != null) {
                is.close();
            }
            if (outputStream != null) {
                is.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FoliosSDServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
