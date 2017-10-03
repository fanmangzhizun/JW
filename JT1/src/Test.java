import utils.DAO.GirlDAO;
import utils.Girl.Girls;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by faithpercious on 2017/10/3.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        GirlDAO girlDAO=new GirlDAO();
        ArrayList<Girls> list=girlDAO.getAllGirls();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
    }
}
