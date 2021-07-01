package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ITreeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreeDaoImpl implements ITreeDao {
    @Override
    public List<Tree> getAllTree() {
         /*
        具体的JDBC代码，连接数据库，获取数据
         */
        List<Tree> treeList = new ArrayList<Tree>();
        String url = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            sql = "SELECT * FROM tb_tree";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setTreeId(rs.getString("TREEID"));
                tree.setParentId(rs.getString("PARENTID"));
                tree.setTitle(rs.getString("TITLE"));
                tree.setUrl(rs.getString("URL"));
                tree.setIsParent(rs.getString("ISPARENT"));
                treeList.add(tree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return treeList;
    }
}
