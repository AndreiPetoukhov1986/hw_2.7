public class Employee {
    private final String fullName;
    private int department;     //отдел 1-5
    private double salary;     //зарплата
    private static int counterId=1;

   private int id;

    public Employee (String fullName, int department, double salary){
        this.fullName=fullName;
        this.department=department;
        this.salary=salary;
        this.id=counterId++;
    }

    public String getFullName(){
        return this.fullName;
    }

    public int getDepartment (){
        return this.department;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getId(){
        return this.id;
    }

    public void setDepartment(int department){
        this.department=department;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }

    @Override
    public String toString(){
        return "Ф.И.О. "+fullName+" отдел - "+department+" зарплата "+salary+" рублей ";

    }

}
