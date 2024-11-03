package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map <Integer,Employee> employeeMap;
    private static List <Employee> duplicatedEmployees;


    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "Nurcan Banu", "Gümüş"));
        employeeList.add(new Employee(2, "Berkay", "Şenyıldız"));
        employeeList.add(new Employee(2, "Merve", "Yılar"));
        employeeList.add(new Employee(3, "Saadet", "Avcıkızı"));
        employeeList.add(new Employee(4, "Tuğba", "Köksalmaz"));
        employeeList.add(new Employee(5, "Pelin", "Özmanoğlu"));
        employeeList.add(new Employee(6, "Berfin", "Ülüfek"));
        employeeList.add(new Employee(2, "Sema Nur", "Durmaz"));
        employeeList.add(new Employee(7, "Nazlı Nur", "Alpkurt"));
        employeeList.add(new Employee(8, "Hilal", "Dursan"));
        employeeList.add(new Employee(5, "Ekin", "Sağaklı"));
        employeeList.add(new Employee(1, "Aslı", "Eril"));
        employeeList.add(new Employee(9, "Hilal", "Dursan"));

        System.out.println(findDuplicates(employeeList).size());
        System.out.println(findUniques(employeeList).size());
        System.out.println(removeDuplicates(employeeList).size());

        System.out.println(WordCounter.calculatedWord());

    }
    public static List <Employee> findDuplicates(List <Employee> employees ) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("There is a null record!");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map <Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("There is a null record!");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
    }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List <Employee> justUnique = new LinkedList<>(uniques.values());
        justUnique.removeAll(duplicates);
        return justUnique;
    }
}