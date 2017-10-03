package utils.DAO;

import utils.DBhelper;
import utils.Girl.Girls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by faithpercious on 2017/10/2.
 */
public class GirlDAO {

    public ArrayList<Girls> getAllGirls() throws SQLException {//得到所有女孩的数据
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = DBhelper.getconnection();
            String sql = "select * from beautygirls.sexgirl";
             preparedStatement = connection.prepareStatement(sql);
             rs = preparedStatement.executeQuery();
            ArrayList<Girls> glist = new ArrayList<>();
            while (rs.next()) {
                Girls girl = new Girls();
                girl.setId(rs.getInt("id"));
                girl.setImg(rs.getString("img"));
                girl.setMoney(rs.getInt("money"));
                girl.setName(rs.getString("name"));
                glist.add(girl);
            }
            return glist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement=null;
                    preparedStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public  Girls getGirlsById(int id) throws SQLException {
        //通过id查询到girl
//        GirlDAO girlDAO=new GirlDAO();
//        ArrayList<Girls>girls=girlDAO.getAllGirls();
//        Girls girl=new Girls();
//        while (girls!=null&&girls.size()>0){
//            for (int i=0;i<girls.size();i++){
//        if (girl.getId()==id){
//            return girl;
//        }
//        else {
//
//        }
//            }
//        }
        //用连接的方式更为节省资源
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection=DBhelper.getconnection();
            String sql="select * from sexgirl where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            rs=preparedStatement.executeQuery();
            if (rs.next()){
                Girls girl=new Girls();
                girl.setId(rs.getInt("id"));
                girl.setName(rs.getString("name"));
                girl.setMoney(rs.getInt("money"));
                girl.setImg(rs.getString("img"));
                return girl;
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement=null;
                    preparedStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public ArrayList<Girls> getViewList(String list) throws SQLException {
        System.out.println("list"+list);//只显示五条数据
        ArrayList<Girls> vgirls=new ArrayList<>();
        int count=5;
        if (list!=null&&list.length()>0){
            String arr[]=list.split(",");
            if (arr.length>5) {//从最新的开始加，只加五个
                for (int i = arr.length - 1; i >= arr.length - count; i--) {
                    vgirls.add(getGirlsById(Integer.parseInt(arr[i])));//没有对象直接调用方法，这神奇的操作，要复习一下
                }
            }
                else{
                    for (int i=arr.length-1;i>=0;i--){
                        vgirls.add(getGirlsById(Integer.parseInt(arr[i])));
                    }
                }
                return vgirls;
            }
           else {
            return null;
        }
    }
}
