package com.telcel.dashboard.controller;

import com.telcel.dashboard.entity.FoliosSD;
import com.telcel.dashboard.excel.FoliosSDExcelExporter;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.telcel.dashboard.service.FoliosSDService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Angel Nuñez
 */
@Controller
@Slf4j
public class DashboardController {

    @Autowired
    private FoliosSDService foliosSDService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "dashboard";
    }

    @RequestMapping(path = "/getAllFolios", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FoliosSD> getFolios() {
        return foliosSDService.getAllFoliosAttended();
    }

    @RequestMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public void descargaExcel(HttpServletResponse response, @RequestParam String fechaFinal) throws IOException {
        System.out.println("FECHA FINAL: " + fechaFinal);
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=reporteSDAtendidos_del: " + fechaFinal + " al: " + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        foliosSDService.getDetalleXLSX(response, fechaFinal);
    }

    @RequestMapping(path = "/pruebas")
    @ResponseBody
    public void descargaExcel1() {
        Calendar fecha = Calendar.getInstance();
//        int anio = fecha.get(Calendar.YEAR);
//        int mes = fecha.get(Calendar.MONTH) + 1;
//        System.out.println("MES ACTUAL: " + mes + " Año actual: " + anio);
//        fecha.add(Calendar.MONTH, -2);
//        int anioMenos = fecha.get(Calendar.YEAR);
//        int mesMenos = fecha.get(Calendar.MONTH) + 1;
//        System.out.println("MES ACTUAL: " + mesMenos + " Año actual: " + anioMenos);
        for (int i = 0; i < 3; i++) {
            int mesMenos1 = fecha.get(Calendar.MONTH) + 1;
            System.out.println("MES: " +mesMenos1);
            fecha.add(Calendar.MONTH, -1);
        }
    }
}
