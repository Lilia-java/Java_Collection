import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        //exercise 2 A
        Employee emp = new Employee("Ivan","Smirnov");
        long startTime1 = System.nanoTime();
        ArrayList<Employee> arrE = new ArrayList<Employee>();
        for(int i=0;i<50000;i++){
            arrE.add(i,emp);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("ArrayList`s time: "+estimatedTime1);

        long startTime2 = System.nanoTime();
        LinkedList<Employee> linkE = new LinkedList<Employee>();
        for(int i=0;i<50000;i++){
            linkE.add(i,emp);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("LinkedList`s time: "+estimatedTime2);

        if (estimatedTime1>estimatedTime2){
            System.out.println("ArrayList is slower than LinkedList");
        }
        else if (estimatedTime1 == estimatedTime2){
            System.out.println("ArrayList`s time equals LinkedList`s");
        }
            else if (estimatedTime1<estimatedTime2){
            System.out.println("LinkedList is slower than ArrayList");
        }
        long startTime3 = System.nanoTime();
        for(int i=0;i<10000;i++){
            arrE.remove(i);
        }
        long estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println(" ");
        System.out.println("ArrayList`s time: "+estimatedTime3);

        long startTime4 = System.nanoTime();
        for(int i=0;i<10000;i++){
            linkE.remove(i);
        }
        //LinkedList linE = new LinkedList();
        long estimatedTime4 = System.nanoTime() - startTime4;

        System.out.println("LinkedList`s time: "+estimatedTime4);

        if (estimatedTime3>estimatedTime4){
            System.out.println("ArrayList is slower than LinkedList");
        }
        else if (estimatedTime3 == estimatedTime4){
            System.out.println("ArrayList`s time equals LinkedList`s");
        }
        else if (estimatedTime3<estimatedTime4){
            System.out.println("LinkedList is slower than ArrayList");
        }
        System.out.println(" ");
        //exercise 2 B
        long startTimeS1 = System.nanoTime();
        HashSet<Integer> hashS = new HashSet<Integer>();
        for(int i=0;i<50000;i++){
            hashS.add(i);
        }
        long estimatedTimeS1 = System.nanoTime() - startTimeS1;
        System.out.println("HashSet`s time: "+estimatedTimeS1);

        long startTimeS2 = System.nanoTime();
        LinkedHashSet<Integer> linkedHS = new LinkedHashSet<Integer>();
        for(int i=0;i<50000;i++){
            linkedHS.add(i);
        }
        long estimatedTimeS2 = System.nanoTime() - startTimeS2;
        System.out.println("LinkedHashSet`s time: "+estimatedTimeS2);

        long startTimeS3 = System.nanoTime();
        TreeSet<Integer> treeS = new TreeSet<Integer>();
        for(int i=0;i<50000;i++){
            treeS.add(i);
        }
        long estimatedTimeS3 = System.nanoTime() - startTimeS3;
        System.out.println("TreeSet`s time: "+estimatedTimeS3);

        if (estimatedTimeS2>estimatedTimeS1 && estimatedTimeS3>estimatedTimeS1){
            System.out.println("HashSet is faster than both");
        }
        else if (estimatedTimeS1>estimatedTimeS2 && estimatedTimeS3>estimatedTimeS2){
            System.out.println("LinkedHashSet is faster than both");
        }
        else if (estimatedTimeS1>estimatedTimeS3 && estimatedTimeS2>estimatedTimeS3){
            System.out.println("TreeSet is faster than both");
        }
        long startTimeS4 = System.nanoTime();
        for(int i=0;i<10000;i++){
            hashS.remove(i);
        }
        long estimatedTimeS4 = System.nanoTime() - startTimeS4;
        System.out.println(" ");
        System.out.println("HashSet`s time: "+estimatedTimeS4);

        long startTimeS5 = System.nanoTime();
        for(int i=0;i<10000;i++){
            linkedHS.remove(i);
        }
        //LinkedList linE = new LinkedList();
        long estimatedTimeS5 = System.nanoTime() - startTimeS5;

        System.out.println("LinkedHashSet`s time: "+estimatedTimeS5);

        long startTimeS6 = System.nanoTime();
        for(int i=0;i<10000;i++){
            treeS.remove(i);
        }

        long estimatedTimeS6 = System.nanoTime() - startTimeS6;

        System.out.println("TreeSet`s time: "+estimatedTimeS6);

        if (estimatedTimeS5>estimatedTimeS4 && estimatedTimeS6>estimatedTimeS4){
            System.out.println("HashSet is faster than both");
        }
        else if (estimatedTimeS4>estimatedTimeS5 && estimatedTimeS6>estimatedTimeS5){
            System.out.println("LinkedHashSet is faster than both");
        }
        else if (estimatedTimeS4>estimatedTimeS6 && estimatedTimeS5>estimatedTimeS6){
            System.out.println("TreeSet is faster than both");
        }
        //exercise 2 C
        System.out.println("");
        long startTimeM1 = System.nanoTime();
        HashMap<Integer,Employee> hashME = new HashMap<Integer, Employee>();
        for(int i=0;i<50000;i++){
            hashME.put(i,emp);
        }
        long estimatedTimeM1 = System.nanoTime() - startTimeM1;
        System.out.println("HashMap`s time: "+estimatedTimeM1);

        long startTimeM2 = System.nanoTime();
        LinkedHashMap<Integer,Employee> linkedHME = new LinkedHashMap<Integer, Employee>();
        for(int i=0;i<50000;i++){
            linkedHME.put(i,emp);
        }
        long estimatedTimeM2 = System.nanoTime() - startTimeM2;
        System.out.println("LinkedHashMap`s time: "+estimatedTimeM2);

        long startTimeM3 = System.nanoTime();
        TreeMap<Integer,Employee> treeM = new TreeMap<Integer, Employee>();
        for(int i=0;i<50000;i++){
            treeM.put(i,emp);
        }
        long estimatedTimeM3 = System.nanoTime() - startTimeM3;
        System.out.println("TreeMap`s time: "+estimatedTimeM3);

        if (estimatedTimeM2>estimatedTimeM1 && estimatedTimeM3>estimatedTimeM1){
            System.out.println("HashMap is faster than both");
        }
        else if (estimatedTimeM1>estimatedTimeM2 && estimatedTimeM3>estimatedTimeM2){
            System.out.println("LinkedHashMap is faster than both");
        }
        else if (estimatedTimeM1>estimatedTimeM3 && estimatedTimeM2>estimatedTimeM3){
            System.out.println("TreeMap is faster than both");
        }
        long startTimeM4 = System.nanoTime();
        for(int i=0;i<10000;i++){
            hashME.remove(i);
        }
        long estimatedTimeM4 = System.nanoTime() - startTimeM4;
        System.out.println(" ");
        System.out.println("HashMap`s time: "+estimatedTimeM4);

        long startTimeM5 = System.nanoTime();
        for(int i=0;i<10000;i++){
            linkedHME.remove(i);
        }
        //LinkedList linE = new LinkedList();
        long estimatedTimeM5 = System.nanoTime() - startTimeM5;

        System.out.println("LinkedHashMap`s time: "+estimatedTimeM5);

        long startTimeM6 = System.nanoTime();
        for(int i=0;i<10000;i++){
            treeM.remove(i);
        }

        long estimatedTimeM6 = System.nanoTime() - startTimeM6;

        System.out.println("TreeMap`s time: "+estimatedTimeM6);

        if (estimatedTimeM5>estimatedTimeM4 && estimatedTimeM6>estimatedTimeM4){
            System.out.println("HashMap is faster than both");
        }
        else if (estimatedTimeM4>estimatedTimeM5 && estimatedTimeM6>estimatedTimeM5){
            System.out.println("LinkedHashMap is faster than both");
        }
        else if (estimatedTimeM4>estimatedTimeM6 && estimatedTimeM5>estimatedTimeM6){
            System.out.println("TreeMap is faster than both");
        }

    }
}
