package utils.Girl;

/**
 * Created by faithpercious on 2017/10/2.
 */
public class Girls {
    private int id;
    private String img;
    private String name;
    private int money;

    public Girls() {
    }

    public int getId() {
        return id;

    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();//去重
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
            if (obj instanceof Girls) {
                Girls g=(Girls)obj;
                if (this.getId()==g.getId()&&this.getName().equals(g.getName())){
                    return true;
                }
                else {
                    return false;
                }
            } else {
                return false;
            }

    }

    public Girls(int id, String img, String name, int money) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "图片编号：" + id
                +
                ", 美女名称：" + name +
                ", money：" + money
                ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
