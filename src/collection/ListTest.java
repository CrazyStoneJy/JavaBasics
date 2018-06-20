package collection;

import rxjava.*;

import java.util.*;

/**
 * Created by crazystone on 18-5-23.
 */
public class ListTest {

    public static void main(String... args) {

        PersonList list1 = genList(5);
        PersonList list2 = genList(10);
        PersonList list3 = list1.retainAll2(list2);

        printList(list1);
        printList(list2);
        printList(list3);

    }

    private static void printList(List<Person> list) {
        StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            sb.append(p.toString()).append("\n");
        }
        System.out.println(sb);
    }

    private static PersonList genList(int threshold) {
        Random random = new Random();
        PersonList list = new PersonList();
        for (int i = 0; i < threshold; i++) {
            int pos = random.nextInt(100);
            Person p = new Person();
            p.setAge(pos)
                    .setName("name" + pos);
            if (list.contains(p)) {
                continue;
            }
            list.add(p);
        }
        return list;
    }

    public static class PersonList extends ArrayList<Person>{

        public PersonList retainAll2(Collection<Person> collection){
            Iterator<Person> iterator = iterator();
            PersonList list = new PersonList();
            while (iterator.hasNext()){
                Person person = iterator.next();
                if(!collection.contains(person)){
                    list.add(person);
                }
            }
            return list;
        }

    }

}
