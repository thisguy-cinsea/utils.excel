package com.github.curriculeon;

import org.apache.poi.ss.usermodel.CellStyle;

import java.util.function.Function;

/**
 * @author leonhunter
 * @created 01/25/2020 - 2:15 AM
 */
public enum ExcelSpreadSheetStyleFactory {
    // TODO - Declare style literals
    STYLE1((cellStyle -> new ExcelSpreadSheetCellStyleBuilder(cellStyle)
            .setAlignment(null)
            .setBorderColorBottom(null)
            .setBorderColorLeft(null)
            .setBorderColorRight(null)
            .setBorderColorTop(null)
            .setBorderBottom(null)
            .setBorderLeft(null)
            .setBorderRight(null)
            .setBorderTop(null)
            .setDataFormat(null)
            .setFillBackgroundColor(null)
            .setFillForegroundColor(null)
            .setFillPattern(null)
            .setFont(null)
            .setIndentation(null)
            .setIsHidden(null)
            .setIsLocked(null)
            .setIsTextWrapped(null)
            .setRotation(null)
            .build())),

    // TODO - Declare style literals
    STYLE2(cellStyle -> new ExcelSpreadSheetCellStyleBuilder(cellStyle)
            .setAlignment(null)
            .setBorderColorBottom(null)
            .setBorderColorLeft(null)
            .setBorderColorRight(null)
            .setBorderColorTop(null)
            .setBorderBottom(null)
            .setBorderLeft(null)
            .setBorderRight(null)
            .setBorderTop(null)
            .setDataFormat(null)
            .setFillBackgroundColor(null)
            .setFillForegroundColor(null)
            .setFillPattern(null)
            .setFont(null)
            .setIndentation(null)
            .setIsHidden(null)
            .setIsLocked(null)
            .setIsTextWrapped(null)
            .setRotation(null)
            .build()),

    // TODO - Declare style literals
    STYLE3(cellStyle -> new ExcelSpreadSheetCellStyleBuilder(cellStyle)
            .setAlignment(null)
            .setBorderColorBottom(null)
            .setBorderColorLeft(null)
            .setBorderColorRight(null)
            .setBorderColorTop(null)
            .setBorderBottom(null)
            .setBorderLeft(null)
            .setBorderRight(null)
            .setBorderTop(null)
            .setDataFormat(null)
            .setFillBackgroundColor(null)
            .setFillForegroundColor(null)
            .setFillPattern(null)
            .setFont(null)
            .setIndentation(null)
            .setIsHidden(null)
            .setIsLocked(null)
            .setIsTextWrapped(null)
            .setRotation(null)
            .build());

    ExcelSpreadSheetStyleFactory(Function<CellStyle, ExcelSpreadSheetCellStyle> cellStyleGenerator) {
    }

    public ExcelSpreadSheetCellStyler create() {
        return null;
    }
}
