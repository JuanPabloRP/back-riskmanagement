package com.riskmanagement.back_riskmanagement.exception.codes;

import lombok.Getter;

@Getter
public enum ExceptionCodesRiskManagementDatabase {
    DB_RISK_MANAGEMENT_000( "Error al crear la tabla"),
    DB_RISK_MANAGEMENT_001("Error al consultar"),
    DB_RISK_MANAGEMENT_002( "Error al insertar"),
    DB_RISK_MANAGEMENT_003( "Error al editar"),
    DB_RISK_MANAGEMENT_004( "Error al eliminar"),
    DB_RISK_MANAGEMENT_005( "Error al obtener la información"),

    // Errores para los usuarios que vienen de la base de datos
    DB_RISK_MANAGEMENT_006( "Error al crear la tabla de usuarios"),
    DB_RISK_MANAGEMENT_007("Error al consultar los usuarios"),
    DB_RISK_MANAGEMENT_008( "Error al crear un usuario"),
    DB_RISK_MANAGEMENT_009( "Error al modificar un usuario"),
    DB_RISK_MANAGEMENT_010( "Error al eliminar un usuario"),
    DB_RISK_MANAGEMENT_011( "Error al obtener la información de un usuario"),

    //Errores para los roles que vienen de la base de datos
    DB_RISK_MANAGEMENT_012( "Error al crear la tabla de roles"),
    DB_RISK_MANAGEMENT_013("Error al consultar los roles"),
    DB_RISK_MANAGEMENT_014( "Error al crear un rol"),
    DB_RISK_MANAGEMENT_015( "Error al modificar un rol"),
    DB_RISK_MANAGEMENT_016( "Error al eliminar un rol"),
    DB_RISK_MANAGEMENT_017( "Error al obtener la información de un rol"),

    //Errores para los controles que vienen de la base de datos
    DB_RISK_MANAGEMENT_018( "Error al crear la tabla de controles"),
    DB_RISK_MANAGEMENT_019("Error al consultar los controles"),
    DB_RISK_MANAGEMENT_020( "Error al crear un controles"),
    DB_RISK_MANAGEMENT_021( "Error al modificar un controles"),
    DB_RISK_MANAGEMENT_022( "Error al eliminar un controles"),
    DB_RISK_MANAGEMENT_023( "Error al obtener la información de un control"),


    //Plan de tratamiento
    DB_RISK_MANAGEMENT_018( "Error al listar plan de tratamiento"),
    DB_RISK_MANAGEMENT_019("Error al listar plan por Id"),
    DB_RISK_MANAGEMENT_020( "Error al crear plan"),
    DB_RISK_MANAGEMENT_021( "Error al actualizar plan"),
    DB_RISK_MANAGEMENT_022( "Error al eliminar plan"),
    DB_RISK_MANAGEMENT_023( "Error al listar riesgos"),
    ;


    private final String description;

    ExceptionCodesRiskManagementDatabase(String description) {
        this.description = description;
    }
}
