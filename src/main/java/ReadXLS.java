import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;

public class ReadXLS {
    
    public void read() throws Exception {
        
        InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream("read.xml"));
        XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );  
        InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream("departmentdata.xls"));  
        Department department = new Department();  
        Department hrDepartment = new Department();  
        List departments = new ArrayList(); 
        Map beans = new HashMap();
        beans.put("department", department);
        XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
        
        System.out.println(department);
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        ReadXLS readXLS = new ReadXLS();
        readXLS.read();
    }

}
