package TestAnnotation;


@Table("tb_student")
public class Student {

    @SxtField(columnName = "id",type = "int",lenth = 10)
    private int id;
    @SxtField(columnName = "sname",type = "varchar",lenth = 10)
    private String Name;
    @SxtField(columnName = "age",type = "int",lenth = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
