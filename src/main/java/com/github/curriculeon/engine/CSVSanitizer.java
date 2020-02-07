package com.github.curriculeon.engine;

import com.github.curriculeon.tests.excel.ExcelSpreadSheet;
import com.github.curriculeon.tests.excel.tabledata.ExcelSpreadSheetRow;
import com.github.curriculeon.utils.Transposer;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leonhunter
 * @created 01/24/2020 - 11:58 PM
 * The purpose of this class is to be the engine which
 * 1. parses the ugly canvas CSV
 * 2. converts ugly CSV data to pretty CSV
 * (this process is later followed by extracting data from the pretty CSV to a XLSX file)
 */
public class CSVSanitizer {
    private final CSVWriter writer;
    private final CSVInterpreter csvInterpreter;
    private List<List<String>> rows;

    public CSVSanitizer(File source, File destination) {
        try {
            this.csvInterpreter = new CSVInterpreter(source);
            this.rows = csvInterpreter.getRows();
            this.writer = new CSVWriter(new FileWriter(destination.getAbsolutePath()));
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    // TODO
    public List<List<String>> parseRows() {
        write();
        return rows;
    }

    public void write() {
        writer.writeAll(standardize());
    }

    private List<String[]> standardize() {
        List<String[]> result = new ArrayList<>();
        for (List<String> column : csvInterpreter.getRows()) {
            result.add(column.toArray(new String[0]));
        }
        return result;
    }

    public List<List<Cell>> parseToSheet(Sheet newSheet) {
        ExcelSpreadSheet newExcelSpreadSheet = new ExcelSpreadSheet(newSheet);
        List<List<String>> rows = this.parseRows();
        List<List<Cell>> cellList = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < rows.size(); rowNumber++) {
            List<String> stringListData = rows.get(rowNumber);
            List<Cell> cellListData = new ArrayList<>();
            for (int columnNumber = 0; columnNumber < stringListData.size(); columnNumber++) {
                String cellValue = stringListData.get(columnNumber);
                Cell cell = newExcelSpreadSheet.getCell(rowNumber, columnNumber);
                cell.setCellValue(cellValue);
                cellListData.add(cell);
            }
            ExcelSpreadSheetRow row = new ExcelSpreadSheetRow(newSheet, rowNumber, cellListData);
            newExcelSpreadSheet.addRow(row, row.getDimensionIndex());
        }
        return cellList;
    }
}

