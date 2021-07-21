/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.repositoryImpl;

import com.telcel.dashboard.entity.FoliosSD;

import com.telcel.dashboard.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository
public class FoliosSDRepositoryImpl implements FoliosSDRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<FoliosSD> findAllFoliosAttended(String fechaFin) {   
        
        String query = "SELECT CR.REF_NUM AS NO_INCIDENTE, \n" +
"          cast(CR.DESCRIPTION as VARCHAR(4000)) AS DESCRIPCION,\n" +
"       CRSTAT.SYM AS ESTATUS, \n" +
"       dateadd( ss,CR.OPEN_DATE ,convert( datetime,'12/31/1969 18:00:00',102 ))  AS FECHA_HORA_CREACION,\n" +
"       dateadd( ss,max(LOG.LAST_MOD_DT), convert( datetime,'12/31/1969 18:00:00',102 ))  AS FECHA_HORA_ATENCION, \n" +
"       [LOG_ANALISTA].[FIRST_NAME]+' '+[LOG_ANALISTA].[LAST_NAME] AS ASIGNADO, \n" +
"       CATEG.SYM AS CATEGORIA, \n" +
"       CA_OWNED_RESOURCE.RESOURCE_NAME AS CI_RELACIONADO, \n" +
"       ZA.SYM AS MOTIVO_INCIDENTE, \n" +
"       GRP.LAST_NAME AS GRUPO,\n" +
"       cast(log.DESCRIPTION as VARCHAR(4000)) as LOG_SOLUTION     \n" +
"                FROM CALL_REQ AS CR \n" +
"                LEFT JOIN CR_STAT AS CRSTAT ON CR.STATUS = CRSTAT.CODE \n" +
"                LEFT JOIN CA_CONTACT AS ASSIG ON (CR.ASSIGNEE = ASSIG.CONTACT_UUID AND ASSIG.LAST_NAME IS NOT NULL) \n" +
"                LEFT JOIN PROB_CTG AS CATEG ON (CR.CATEGORY = CATEG.PERSID AND CATEG.DEL = 0) \n" +
"                LEFT JOIN CA_OWNED_RESOURCE ON CR.AFFECTED_RC = CA_OWNED_RESOURCE.OWN_RESOURCE_UUID \n" +
"                LEFT JOIN ZACCION AS ZA ON CR.ZACCION = ZA.ID \n" +
"                LEFT JOIN CRT AS TIPOTICKET ON CR.TYPE=TIPOTICKET.CODE \n" +
"                LEFT JOIN BOOL_TAB AS BOOL ON BOOL.ENUM=CR.ZVOBO \n" +
"                LEFT JOIN CA_CONTACT AS GRP ON (CR.GROUP_ID = GRP.CONTACT_UUID AND GRP.FIRST_NAME IS NULL) \n" +
"                LEFT JOIN CA_CONTACT AS CUSTOMER ON CR.CUSTOMER = CUSTOMER.CONTACT_UUID \n" +
"                LEFT JOIN ACT_LOG AS LOG ON CR.PERSID = LOG.CALL_REQ_ID\n" +
"                LEFT JOIN CA_CONTACT AS LOG_ANALISTA  ON (LOG_ANALISTA.CONTACT_UUID = LOG.analyst )\n" +
"                WHERE \n" +
"                 GRP.LAST_NAME  IN ('Soporte a Usuarios y Ctrl de la Producción TT ') \n" +
"                 AND LOG_ANALISTA.FIRST_NAME IS NOT NULL \n" +
"                  AND LOG_ANALISTA.LAST_NAME IS NOT NULL \n" +
"                AND LOG.TYPE IN('SOLN', 'RE', 'ST')\n" +
"                 AND (DATEADD(SS, CR.OPEN_DATE, CONVERT(DATETIME, '1969-12-31 18:00:00', 102)) > '"+ fechaFin +" 00:00:0' )  \n" +
"                  GROUP BY  CR.REF_NUM ,  CRSTAT.SYM, CR.OPEN_DATE, [LOG_ANALISTA].[FIRST_NAME]+' '+[LOG_ANALISTA].[LAST_NAME], CATEG.SYM,\n" +
"                           CA_OWNED_RESOURCE.RESOURCE_NAME, ZA.SYM , GRP.LAST_NAME,     CR.RESOLVE_DATE,  LOG.LAST_MOD_DT, \n" +
"                           cast(CR.DESCRIPTION as VARCHAR(4000)),\n" +
"                           cast(log.DESCRIPTION as VARCHAR(4000))\n" +
"                           ORDER by  LOG.LAST_MOD_DT desc";
        
        
        List<FoliosSD> ttSinAtencion = namedParameterJdbcTemplate.query(query.toString(),
                new BeanPropertyRowMapper(FoliosSD.class));
        return ttSinAtencion;
    }

}
