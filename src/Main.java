public class Main {
    static Employee[] employee = new Employee[10];

    public static <employee> void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee andrei = new Employee("Петухов Андрей Леонидович", 1, 99_000);
        employeeBook.addEmployee("Сухова Кристина Сергеевна", 2, 109_000);
        employeeBook.addEmployee("Марьенко Александр Сергеевич", 3, 89_000);
        employeeBook.addEmployee("Ожиганова Наталья Юрьевна", 4, 79_000);
        employeeBook.addEmployee(andrei);

        employeeBook.changeSalary(andrei, 115_000);

        employeeBook.printEmployeesByDepartment();

        employeeBook.printAllEmployes();
        double totalSalaries = employeeBook.totalSalaries();
        System.out.println("Сумма ЗП всех сотрудников за месяц: "+totalSalaries);
        Employee employeeWithMinSalary = employeeBook.findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: "+employeeWithMinSalary);
        Employee employeeWithMaxSalary = employeeBook.findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: "+employeeWithMaxSalary);
        double averageSalary=employeeBook.averageSalary();
        System.out.println("Средняя ЗП всех сотрудников за месяц: "+employeeWithMaxSalary);
        employeeBook.printFullNameEmployees();

        employeeBook.indexSalaries(10);
        System.out.println("После индексации");
        employeeBook.printAllEmployes();

        System.out.println("Сотрудник с минимальной ЗП из 1 отдела "+  employeeBook.findEmployeeWithMinSalaryFromDepartment(1));
        System.out.println("Сотрудник с  максимальной ЗП из 4 отдела "+  employeeBook.findEmployeeWithMaxSalaryFromDepartment(4));
        System.out.println("Сумма ЗП всех сотрудникв за месяц из отдел 3 "+employeeBook.totalSalariesForDepartment(3));
        System.out.println("Средняя ЗП всех сотрудникв за месяц из отдел 5 "+employeeBook.averageSalaryForDepartment(3));

        employeeBook.indexSalariesForDepartment(5,1);
        System.out.println("После индексации для отдела " + 1);
        employeeBook.printAllEmployesForDepartment(1);
        employeeBook.printEmployeesWithSalaryLessThan(55_000);
        }
    }