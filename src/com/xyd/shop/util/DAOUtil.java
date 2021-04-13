package com.xyd.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOUtil {
    private static final String CLASSNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf-8";
    private static final String USER = "B";
    private static final String PASSWORD = "1234";
    private static Connection conn=null;
    private static PreparedStatement ps=null;
    private static ResultSet set=null;
    static {
        try {
            Class.forName(CLASSNAME);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static Connection getConnection(){
        try {
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        }catch (Exception e){
             e.printStackTrace();
        }
        return null;
    }
    public static List<Map<String,Object>> executeQuery(String sql,Object...data){
        try {
             conn = DAOUtil.getConnection();
             ps = conn.prepareStatement(sql);
            for (int i = 0; i < data.length; i++) {
                ps.setObject(i+1,data[i]);
            }
            set = ps.executeQuery();
            List<Map<String,Object>> list = new ArrayList<>();
            while (set.next()){
                Map<String,Object> map = new HashMap<>();
                for (int i = 0; i < set.getMetaData().getColumnCount(); i++) {
                    String k = set.getMetaData().getColumnName(i+1);
                    Object v = set.getObject(k);
                    map.put(k,v);
                }
                list.add(map);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
      return null;
    }
    public static int executeUpdate(String sql,Object...data){
        try {
            conn = DAOUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < data.length; i++) {
                ps.setObject(i+1,data[i]);
            }
            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }
    private static void close(){
        try {
            if (set!=null){
                set.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (conn!=null){
                        conn.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }



}
