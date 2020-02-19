package edu.postgraduate.programExercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-17
 */
public class CollectionTest {

    @Test
    public void test7() {

    }


    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
        list.add(112);
        list.add(12);
        list.add(132);
        list.add(62);
        list.add(-90);
        list.add(-12);

        // copy
        List<Integer> copyList = Arrays.asList(new Integer[list.size()]);
        Collections.copy(copyList, list);
        System.out.println(copyList);

        // 真正意义上的copy，不是直接把地址值传给dest
        System.out.println(copyList == list);
        System.out.println(copyList.equals(list));
    }


    @Test
    public void test5() {
        List<Integer> list = new ArrayList<>();
        list.add(112);
        list.add(12);
        list.add(132);
        list.add(62);
        list.add(-90);
        list.add(-12);

        System.out.println(list);

        // 翻转
        Collections.reverse(list);
        System.out.println(list);

        // 洗牌（随机排序）
        Collections.shuffle(list);
        System.out.println(list);


    }

    // map的遍历
    @Test
    public void test4() {
        Map<String, Integer> map = new HashMap<>();
        map.put("AAA", 123);
        map.put("BBB", 1323);
        map.put("CCC", 143);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        System.out.println();
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        System.out.println();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry);
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }



    }

    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("AAA", 123);
        map.put("BBB", 1323);
        map.put("CCC", 143);

        System.out.println(map.containsKey("AAA"));
        System.out.println(map.containsKey("A"));
        System.out.println(map.containsValue(123));
        System.out.println(map.containsValue(13));
    }

    @Test
    public void test2() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(6);
        hashSet.add(8);
        hashSet.add(2);

        System.out.println(hashSet);
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);

        System.out.println(list);
//        list.remove(1); // 删除index为1的元素
//        list.remove(new Integer(1)); // 删除内容是1的元素
        System.out.println(list);
    }

    @Test
    public void test0() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = Arrays.asList(2, 3, 5);
        System.out.println(list1);
        System.out.println(list2);

//        list1.removeAll(list2);
        list1.retainAll(list2);
        System.out.println(list1);

    }
}
