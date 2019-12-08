public class MainMLL {
    public static void main(String[] args) {
        Employee emp = new Employee("Ivan","Smirnov");

        long startTimeA = System.nanoTime();
        MyLinkedList<Employee> myLL = new MyLinkedList<Employee>();
       // MyLinkedList<Integer> myLL2 = new MyLinkedList<Integer>();
        for(int i=0;i<50000;i++){
            myLL.add(i,emp);
        }
        long estimatedTimeA = System.nanoTime() - startTimeA;
        System.out.println("LinkedList`s time: "+estimatedTimeA);

        long startTimeR = System.nanoTime();
        for(int i=0;i<10000;i++){
            myLL.remove(i);
        }
        //LinkedList linE = new LinkedList();
        long estimatedTimeR = System.nanoTime() - startTimeR;

        System.out.println("LinkedList`s time: "+estimatedTimeR);

       /* for (  Integer i : myLL2) {

        }*/

    }
}
