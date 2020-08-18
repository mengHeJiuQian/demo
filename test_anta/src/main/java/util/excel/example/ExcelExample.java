package util.excel.example;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import util.excel.read.Excel2007HeadRead;
import util.excel.write.Excel2007Write;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/6/11 15:49
 */
public class ExcelExample {

    public static void main(String[] args) throws Exception {

        File jsonfile = ResourceUtils.getFile("D:\\code\\idea201807301255\\demo\\test_anta\\src\\main\\java\\util\\excel\\example\\target.json");
        String json = FileUtils.readFileToString(jsonfile);

        // System.out.println("#-" + json + "-#");

        Gson gson = new Gson();
        OuterObject outerObject = gson.fromJson(json, OuterObject.class);
        List<Field> fields = outerObject.getFields();

        List<List<String>> dataList = fields.stream().map(f -> {
            String Field = f.getName();

            String fqn = f.getFieldType().getFqn();
            String Type;
            if (!StringUtils.isEmpty(fqn)) {
                Type = fqn.substring(fqn.lastIndexOf(".") + 1);

                if (!StringUtils.isEmpty(f.getFieldType().getType())) {
                    Type = f.getFieldType().getType() + " # " + Type;
                }
            } else {
                Type = f.getFieldType().getType();
                String elem_fqn = f.getFieldType().getElementType().getFqn();
                String type2 = elem_fqn.substring(elem_fqn.lastIndexOf(".") + 1);

                Type = Type + " # " + type2;
            }

            String Key = "";

            String Null = "No";

            String Comment = f.getDescription();

            List<String> field = Lists.newArrayList(Field, Type, Key, Null, Comment);

            return field;
        }).collect(Collectors.toList());


        List<String> headList = Lists.newArrayList("Field", "Type", "Key", "Null", "Comment");


        Excel2007Write excel = new Excel2007Write();
        excel.addHead(headList);
        excel.addAllLastRow(dataList);

        excel.write("E:\\a.xlsx");

    }

}
