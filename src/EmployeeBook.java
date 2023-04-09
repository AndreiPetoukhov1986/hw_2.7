import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getFullName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String fullName, double salary, int department) {
        addEmployee(new Employee(fullName, (int) salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            String key = entry.getKey();
            if (employee.getId() == id) {
                employees.remove(key);
                break;
            }
        }

    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудник из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                    System.out.println(employee.getFullName());
                }
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double bound) {
        System.out.println("Сотрудники с ЗП меньшей, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() < bound) {
                System.out.println(employee.getId() + " " + "ФИО: " + employee.getFullName() + " ЗП: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryGreaterOrEqualThan(double bound) {
        System.out.println("Сотрудники с ЗП большей или равной, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() >= bound) {
                System.out.println(employee.getId() + " " + "ФИО: " + employee.getFullName() + " ЗП: " + employee.getSalary());
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                count++;
            }
        }
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void printAllEmployes() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployesForDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                System.out.println("ID: " + employee.getId() + "ФИО: " + employee.getFullName() + "ЗП: " + employee.getSalary());
            }
        }
    }
}

