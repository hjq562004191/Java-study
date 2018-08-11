package StudentServer.server;

public class TeacherDemo {
    private String  id;
    private String pwd;
    private int classid;

    public TeacherDemo(String id, String pwd, int classid) {
        this.id = id;
        this.pwd = pwd;
        this.classid = classid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
