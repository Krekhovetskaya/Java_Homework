
package ru.geekbrains.homework6;
/*/
Задание
Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. Поместите в него некоторое количество объектов.
Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. Убедитесь, что все они сохранились во множество.
Создайте метод
public boolean equals(Object o)
Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
Создайте метод
public int hashCode()
который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
/*/
import java.util.Objects;

public class Cat {

    String name;
    String color;
    int age;
    String gender;

    public Cat(String name, String color, int age, String gender){
        this.name = name; 
        this.color = color;
        this.age = age;
        this.gender = gender;

    }

    public String toString() {
        return String.format("%s: %s, %d years, %s \n", name, color, age, gender);
    }

   
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name) && Objects.equals(color, cat.color) && Objects.equals(gender, cat.gender);
    }

    public int hashCode() {
        return Objects.hash(name, color, age, gender);
    }
}