import com.example.qichengmall.service.OrderService;
import entity.ExcelOrderDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t {
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    @Autowired
    private OrderService orderService;
    //使用excel读取数据
    @Test
    public void test() throws Exception {
        try {
            File file = new File("C:\\Users\\10298\\Desktop\\poi.xlsx");
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), null, new FileInputStream(file));
            multipartFile.transferTo(file);
            List<String[]> strings = POIUtils.readExcel(multipartFile);
            for(int i=1;i<strings.size();i++){
                String[] stringArray = strings.get(i);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime stringArray4 = LocalDateTime.parse(stringArray[4], formatter);
                LocalDateTime stringArray5 = LocalDateTime.parse(stringArray[5], formatter);
                ExcelOrderDto excelOrderDto = new ExcelOrderDto();
                excelOrderDto.setOrderId(stringArray[0]);
                excelOrderDto.setStatus(Integer.valueOf(stringArray[1]));
                excelOrderDto.setUserId(Long.valueOf(stringArray[2]));
                excelOrderDto.setAddressBookId(Long.valueOf(stringArray[3]));
                excelOrderDto.setOrderTime(stringArray4);
                excelOrderDto.setCheckoutTime(stringArray5);
                excelOrderDto.setPayMethod(Integer.valueOf(stringArray[6]));
                excelOrderDto.setAmount(new BigDecimal(stringArray[7]));
                excelOrderDto.setRemark(stringArray[8]);
                excelOrderDto.setPhone(stringArray[9]);
                excelOrderDto.setAddress(stringArray[10]);
                excelOrderDto.setUserName(stringArray[11]);
                excelOrderDto.setConsignee(stringArray[12]);
                excelOrderDto.setImage(stringArray[13]);
                excelOrderDto.setProductId(Long.valueOf(stringArray[14]));
                excelOrderDto.setNumber(Long.valueOf(stringArray[15]));
                System.out.println(excelOrderDto);
            }

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
