```
public class Bugatti {
    private String color = "BLACK";
    private int year = 2020;
    private String body = "Coupe";

    public void setBody(String body)
    {
        this.body = body;
    }
    public String getBody()
    {
        return body;
    }
}
```
public class Programmer {
    private int salary = 1000;

    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        this.salary=this.salary>salary?this.salary:salary;
    }

}
```
