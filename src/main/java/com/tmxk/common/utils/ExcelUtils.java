package com.tmxk.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

        /**  支持单个图片
         * 获取Excel2003图片
         * @param sheet 当前sheet对象
         * @param workbook 工作簿对象
         * @return Map key:图片单元格索引String，value:图片流PictureData
         */
        public static Map<Integer, PictureData> getSheetPictrues03(HSSFSheet sheet, HSSFWorkbook workbook) {
            Map<Integer, PictureData> map = new HashMap<Integer, PictureData>();
            List<HSSFPictureData> pictures = workbook.getAllPictures();
            if (pictures.size() != 0) {
                for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                    HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                    if (shape instanceof HSSFPicture) {
                        HSSFPicture pic = (HSSFPicture) shape;
                        int pictureIndex = pic.getPictureIndex() - 1;
                        HSSFPictureData picData = pictures.get(pictureIndex);
                        Integer picIndex = anchor.getRow1();
                        map.put(picIndex, picData);
                    }
                }
                return map;
            } else {
                return null;
            }
        }

        /**
         * 获取Excel2007图片
         * @param sheetNum 当前sheet编号
         * @param sheet 当前sheet对象
         * @return Map key:图片单元格索引（0_1_1）String，value:图片流PictureData
         */
        public static Map<Integer, PictureData> getSheetPictrues07(int sheetNum, XSSFSheet sheet) {
            Map<Integer, PictureData> map = new HashMap<Integer, PictureData>();
            for (POIXMLDocumentPart dr : sheet.getRelations()) {
                if (dr instanceof XSSFDrawing) {
                    XSSFDrawing drawing = (XSSFDrawing) dr;
                    List<XSSFShape> shapes = drawing.getShapes();
                    for (XSSFShape shape : shapes) {
                        XSSFPicture pic = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = pic.getPreferredSize();
                        CTMarker ctMarker = anchor.getFrom();
                        Integer picIndex = ctMarker.getRow();
                        map.put(picIndex, pic.getPictureData());
                    }
                }
            }
            return map;
        }
}