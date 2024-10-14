package com.riskmanagement.back_riskmanagement.exception.codes;

import lombok.Getter;

@Getter
public enum ExceptionCodes {
    RM_0000(200, "RM-0000", "Archivo procesado correctamente"),
    RM_1000(400, "RM-1000", "El archivo está vacio"),
    RM_1100(404, "RM-1100", "No se encontró información"),
    RM_1200(400, "RM-1200", "No fue posible obtener la información"),
    RM_1201(400,"RM-1201", "No es posible obtener otra info"),
    RM_1400(413, "RM-1400", "Tamaño de archivo demasiado grande"),
    RM_7000(500, "RM-7000", "Error desconocido");
    private int statusResponseCode;
    private String code;
    private String description;

    ExceptionCodes(int statusResponseCode, String code, String description) {
        this.statusResponseCode = statusResponseCode;
        this.code = code;
        this.description = description;
    }

}
