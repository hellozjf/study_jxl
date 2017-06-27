import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    public void test() throws Exception {

        Map<String, Object> data = new HashMap<>();
        data.put("project", new Project("跨厂跨河大桥", "C20细石混凝土", "行车道铺装混凝土", "C20细石混凝土", "10m3实体", "0.809", "4~6~13~2"));

        List<Part> partList = new ArrayList<>();
        partList.add(new Part("1", "人工", "工日", "49.20", "15.300", "12.378", "609"));
        partList.add(new Part("2", "原木", "m3", "1500.00", "0.001", "0.001", "1"));
        partList.add(new Part("3", "型钢", "t", "9000.00", "0.001", "0.001", "7"));
        partList.add(new Part("4", "32.5级水泥", "t", "600.00", "3.845", "3.111", "1866"));
        partList.add(new Part("5", "水", "m3", "2.00", "15.000", "12.135", "24"));
        partList.add(new Part("6", "中（粗）砂", "m3", "100.00", "4.690", "3.794", "379"));
        partList.add(new Part("7", "碎石（4cm）", "m3", "120.00", "8.470", "6.852", "822"));
        partList.add(new Part("8", "其他材料费", "元", "1.000", "2.900", "2.346", "2"));
        partList.add(new Part("9", "电动混凝土切缝机", "台班", "400.000", "0.840", "0.680", "272"));
        partList.add(new Part("10", "1.0t以内机动翻斗车", "台班", "800.000", "0.850", "0.688", "550"));
        partList.add(new Part("11", "小型机具使用费", "元", "1.00", "16.400", "13.268", "13"));
        partList.add(new Part("12", "定额基价", "元", "1.00", "2988.000", "2417.000", "2417"));
        data.put("partList", partList);

        data.put("directProject", new Fee("", "4547"));
        data.put("otherProject1", new Fee("6.390", "291"));
        data.put("otherProject2", new Fee("12.810", "185"));
        data.put("indirectCharge2", new Fee("5.680", "285"));
        data.put("profitAndTexes", new Fee("7.000/5.180", "666"));
        data.put("install", new Fee("", "5974"));

        //        InputStream in = App.class.getClassLoader().getResourceAsStream("test.xls");
        InputStream in = new FileInputStream("input.xls");
        Workbook workbook = new XLSTransformer().transformXLS(in, data);
        FileOutputStream out = new FileOutputStream("output.xls");
        workbook.write(out);
        out.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {

        App app = new App();
        app.test();
        //        ByteArrayOutputStream output = new ByteArrayOutputStream();
        //        workbook.write(output);
        //        String filename = "output.xls";
        //        response.setContentType(String.format("%s;charset=utf-8", "application/x"));
        //        response.setHeader("Content-Disposition", "attachment;filename=" +
        //                new String(filename.getBytes("utf-8"), "iso8859-1"));
        //        response.setHeader("Content-Length", String.valueOf(output.toByteArray().length));
        //        // Streams.write(output.toByteArray(), response.getOutputStream());
        //        response.getOutputStream().write(output.toByteArray());
    }

    public class Fee {

        public Fee(String quota, String price) {

            this.quota = quota;
            this.price = price;
        }

        public String quota;
        public String price;
    }

    public class Part {

        public Part(String id, String name, String unit, String unitPrice, String quota, String quantity, String price) {

            this.id = id;
            this.name = name;
            this.unit = unit;
            this.unitPrice = unitPrice;
            this.quota = quota;
            this.quantity = quantity;
            this.price = price;
        }

        public String id;
        public String name;
        public String unit;
        public String unitPrice;
        public String quota;
        public String quantity;
        public String price;
    }

    public class Project {

        public Project(String range, String name, String item, String detailItem, String unit, String quantity, String tableId) {

            this.range = range;
            this.name = name;
            this.item = item;
            this.detailItem = detailItem;
            this.unit = unit;
            this.quantity = quantity;
            this.tableId = tableId;
        }

        public String range;
        public String name;
        public String item;
        public String detailItem;
        public String unit;
        public String quantity;
        public String tableId;
    }

}
