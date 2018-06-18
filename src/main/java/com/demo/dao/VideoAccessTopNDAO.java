package com.demo.dao;

import com.demo.model.VideoAccessTopN;
import com.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/17.
 */
public class VideoAccessTopNDAO {

    public List<VideoAccessTopN> query() {
        System.out.println("query方法");
        List<VideoAccessTopN> list = new ArrayList<VideoAccessTopN>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection= MysqlUtil.getConnection();
            String sql="select cms_id,times from day_video_access_topn_stat where day=20161110  order by times DESC limit 5";
            pstmt=connection.prepareStatement(sql);
            rs=pstmt.executeQuery();
            VideoAccessTopN model=null;
            while (rs.next()){
                model =new VideoAccessTopN();
                model.setName(rs.getString("cms_id"));
                model.setValue(rs.getLong("times"));
                list.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
            MysqlUtil.release(connection);
        }

        return list;
    }

    public static void main(String[] args) {
        VideoAccessTopNDAO dao = new VideoAccessTopNDAO();
        List<VideoAccessTopN> list = dao.query();
        for(VideoAccessTopN result: list) {
            System.out.println(result.getName() + " , " + result.getValue());
        }
    }
}
