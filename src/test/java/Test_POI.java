import entity.ExcelOrderDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Test_POI {
    //使用excel读取数据
    @Test
    public void test()throws Exception{
        //将来指定文件，创建一个excel对象(工作)
        XSSFWorkbook sheets = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\10298\\Desktop\\poi.xlsx")));
        XSSFSheet sheet = sheets.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i=1;i<lastRowNum;i++){
            XSSFRow row = sheet.getRow(i);
            ExcelOrderDto excelOrderDto = new ExcelOrderDto();
            ArrayList<String> strings = new ArrayList<>();
            for (Cell cell : row) {
                String stringCellValue = cell.getStringCellValue();
                strings.add(stringCellValue);
            }

//            excelOrderDto.setNumber(strings.get(0));
//            excelOrderDto.setStatus(Integer.valueOf(strings.get(1)));
//            excelOrderDto.setUserId(Long.valueOf(strings.get(2)));
//            excelOrderDto.setAddressBookId();
//            excelOrderDto.setOrderTime();
//            excelOrderDto.setCheckoutTime();
//            excelOrderDto.setPayMethod();
//            excelOrderDto.setAmount();
//            excelOrderDto.setRemark();
//            excelOrderDto.setUserName();
//            excelOrderDto.setPhone();
//            excelOrderDto.setAddress();
//            excelOrderDto.setConsignee();

        }

        sheets.close();
    }

}
