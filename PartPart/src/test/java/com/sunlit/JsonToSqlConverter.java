package com.sunlit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonToSqlConverter {
    public static String jsonToSql(String jsonFilePath, String tableName) {
        StringBuilder sqlStatement = new StringBuilder();
        try {
            // 读取JSON文件内容
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonContent);

            // 构建批量插入的SQL语句
            if (jsonArray.length() > 0) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                List<String> columns = new ArrayList<>();
                for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
                    String key = (String) it.next();
                    columns.add("`" + key + "`");
                }
                sqlStatement.append("INSERT INTO `")
                        .append(tableName)
                        .append("` (")
                        .append(String.join(", ", columns))
                        .append(") VALUES ");

                List<String> rows = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    List<String> values = new ArrayList<>();
                    for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
                        String key = (String) it.next();
                        values.add("'" + jsonObject.getString(key) + "'");
                    }
                    rows.add("(" + String.join(", ", values) + ")");
                }
                sqlStatement.append(String.join(", ", rows)).append(";");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return sqlStatement.toString();
    }

    public static void main(String[] args) {
        // 指定JSON文件名和数据库表名
        String jsonFilePath = "C:/Users/sunlit/Desktop/data.json"; // 请替换为您的JSON文件名
        String tableName = "trash";     // 请替换为您的数据库表名

        // 转换并输出SQL语句
        String sqlStatements = jsonToSql(jsonFilePath, tableName);
        System.out.println(sqlStatements);
    }
}
