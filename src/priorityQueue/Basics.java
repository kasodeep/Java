package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Basics {

    public static void main(String[] args) {

        // DEFAULT: Min Heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(20);

        // Max Heap.
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(10);
        pq.offer(5);
        pq.add(20);

        System.out.println(pq.remove());
        System.out.println(pq.peek());

        PriorityQueue<Student> studentPQ = new PriorityQueue<>(new StudentComparator());
        Student student1 = new Student("Deep", 29, 93);
        Student student2 = new Student("Parth", 30, 85);
        studentPQ.add(student1);
        studentPQ.add(student2);
        int tree = 3;
        System.out.println(studentPQ);
    }

    private static class Student {
        String name;
        Integer rollNo;
        Integer marks;

        Student(String name, Integer rollNo, Integer marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student{ " +
                    "name='" + name + '\'' +
                    ", rollNo=" + rollNo +
                    ", marks=" + marks +
                    '}';
        }
    }

    private static class StudentComparator implements Comparator<Student> {

        // Max Heap: return 1;
        // Min Heap: return -1;
        public int compare(Student s1, Student s2) {
            if (s1.marks > s2.marks) {
                return 1;
            } else if (s1.marks < s2.marks) {
                return -1;
            } else {
                return s1.rollNo.compareTo(s2.rollNo);
            }
        }
    }

}
