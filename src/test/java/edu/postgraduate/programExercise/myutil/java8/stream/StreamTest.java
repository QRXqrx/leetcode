package edu.postgraduate.programExercise.myutil.java8.stream;

import edu.postgraduate.programExercise.bean.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用Stream的三个步骤：
 * 1.创建一个Stream对象
 * 2.对Stream执行一系列中间操作
 * 3.终端操作，获取结果
 */
public class StreamTest {
    private List<Person> persons = Arrays.asList(
            new Person[] {
                    new Person("QRX", 22),
                    new Person("XX", 8),
                    new Person("XX", 9),
                    new Person("XX", 10),
                    new Person("LXY", 250),
                    new Person("LWK", 100),
                    new Person("Adian", 13),
                    new Person("Adian", 12),
                    new Person("Adian", 11),
                    new Person("Adian", 8)
            }
    );

    // 终止操作

    /*
        collect - 收集
     */

    // 对收集结果进行汇总
    @Test
    public void test13() {
        // 对不同样的名字进行汇总
        String nameSum = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining());
        System.out.println(nameSum);
        System.out.println("---------------------------------------------------------------------------------------");

        // 在名字中间加上分隔符
        String nameSum1 = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(nameSum1);
        System.out.println("---------------------------------------------------------------------------------------");

        // 在汇总的头尾加上头尾符号
        String nameSum2 = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "###", "###"));
        System.out.println(nameSum2);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // 通过收集分类
    @Test
    public void test12() {
        // 分组 groupingBy
        Map<String, List<Person>> nameGroup = persons.stream().collect(Collectors.groupingBy(Person::getName));
        nameGroup.forEach((k, v) -> {
            System.out.println(k + ": ");
            v.forEach((person) -> System.out.println("\t" + person));
        });
        System.out.println("---------------------------------------------------------------------------------------");

        // 多级分组
        Map<String, Map<String, List<Person>>> mulMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.groupingBy((Person p) -> {
                                int age = p.getAge();
                                if(age <= 25) {
                                    return "少年";
                                }
                                if(age < 100) {
                                    return "中老年";
                                }
                                return "老妖精";
                            })
                        )
                );
        mulMap.forEach((k, v) -> {
            System.out.println(k + ": ");
            v.forEach((kk, vv) -> {
                System.out.println("\t{" + kk + ": ");
                vv.forEach((person -> System.out.println("\t\t" + person)));
                System.out.println("\t}");
            });

        });
        System.out.println("---------------------------------------------------------------------------------------");

        // 分片 partitioningBy
        Map<Boolean, List<Person>> agePartition = persons.stream()
                .collect(Collectors.partitioningBy((p) -> p.getAge() < 100));
        agePartition.forEach((k, v) -> {
            if(k) {
                System.out.println("正常人: ");
            } else {
                System.out.println("老妖精！: ");
            }
            v.forEach(System.out::println);
        });
    }


    // 收集成各种数值
    @Test
    public void test11() {
        // 总数
//        long cnt = persons.stream().collect(Collectors.counting());
//        long cnt = persons.stream().count();
        long cnt = (long) persons.size();
        System.out.println("cnt: " + cnt);
        System.out.println("-------------------------------------------------------");

        // 总和
//        int sum = persons.stream().collect(Collectors.summingInt(Person::getAge));
        int sum = persons.stream().mapToInt(Person::getAge).sum();
        System.out.println("sum: " + sum);
        System.out.println("-------------------------------------------------------");

        // 平均值
        double avg = persons.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("avg: " + avg);
        System.out.println("-------------------------------------------------------");

        // 最大值
//        Optional<Person> max = persons.stream().collect(Collectors.maxBy((p1, p2) -> p1.getName().compareTo(p2.getName())));
//        Optional<Person> max = persons.stream().max((p1, p2) -> p1.getName().compareTo(p2.getName()));
        Optional<Person> max = persons.stream().max(Comparator.comparing(Person::getName));
        System.out.println("max: " + max.get());
        System.out.println("-------------------------------------------------------");

        // 最小值
//        Optional<Person> min = persons.stream().collect(Collectors.minBy((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge())));
//        Optional<Person> min = persons.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        Optional<Person> min = persons.stream().min(Comparator.comparing(Person::getName));
        System.out.println("max: " + max.get());
        System.out.println("-------------------------------------------------------");
    }

    // 收集成各种集合
    @Test
    public void test10() {
        // Collectors工具类
        List<String> nameList = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList()); // -> 以某种方式进行收集
        System.out.println(nameList);

        System.out.println("-------------------------------------------------------");

        Set<String> nameSet = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println(nameSet);

        System.out.println("-------------------------------------------------------");

        HashSet<String> nameHashSet = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(nameHashSet);

    }

    /*
        reduce - 规约
     */
    @Test
    public void test9() {
        // reduce求和
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = intList.stream().reduce(0, (x, y) -> x + y);
        System.out.println("sum: " + sum);
        // map-reduce模式
        Optional<Integer> sumAge = persons.stream().map(Person::getAge).reduce(Integer::sum);
        double avgAge = (double)(sumAge.get()/persons.size());
        System.out.println("avgAge: " + avgAge);
    }



    /*
        查找与匹配
        allMatch - 检查流中的所有元素是不是都匹配同一个条件
        anyMatch - 检查流中是不是存在匹配条件的元素
        nonMatch - 检查流中是不是所有的元素都不匹配
        findFirst - 返回找到的第一个元素
        findAny - 返回找到的任意一个符合条件的元素（通过parallelStream）
        count - 返回流中元素的总个数
        max - 返回流中最大值   \
                             包装类Optional
        min - 返回流中最小值   /
     */

    @Test
    public void test8() {
        // allMatch
        boolean result1 = persons.stream().allMatch((p) -> p.getAge() < 50);
        System.out.println("allMatch: " + result1);
        System.out.println("-----------------------------------------");
        // anyMatch
        boolean result2 = persons.stream().anyMatch((p) -> p.getAge() < 50);
        System.out.println("anyMatch: " + result2);
        System.out.println("-----------------------------------------");
        // nonMatch
        boolean result3 = persons.stream().noneMatch((p) -> p.getAge() < 50);
        System.out.println("nonMatch: " + result3);
        System.out.println("-----------------------------------------");
        // findFirst Optional是一个包装类。有可能为空的类就封装到Optional中去
        Optional<Person> op1 = persons.stream().filter((p) -> p.getAge() > 18).findFirst();
        System.out.println("op1: " + op1.get());
        System.out.println("-----------------------------------------");
        // findAny
        Optional<Person> op2 = persons.parallelStream().filter((p) -> p.getAge() < 30).findAny();
        System.out.println("op2: " + op2.get());
        System.out.println("-----------------------------------------");
        // count
        long cnt = persons.stream().filter((p) -> p.getName().equals("Adian")).count();
        System.out.println("cnt: " + cnt);
        System.out.println("-----------------------------------------");
        // max
        Optional<Person> op3 = persons.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println("op3: " + op3);
        System.out.println("-----------------------------------------");
        // min
        Optional<Person> op4 = persons.stream().min(Comparator.comparingInt(Person::getAge));
        System.out.println("op4: " + op4);
        System.out.println("-----------------------------------------");
    }



   // 中间操作
    /*
        排序操作
        sorted():自然排序 -> 利用Comparable中的compareTo函数
        sorted(Comparator com):定制排序 -> 利用Comparator定制排序
    */

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(4, 9, 1, -7, 2, 9, 5, 7, -1, 0, -9, 2, 4);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------------------------------");
        list.stream().sorted((num1, num2) -> num2 - num1).forEach(System.out::println);
        System.out.println("-----------------------------------------");
//        persons.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).forEach(System.out::println);
        persons.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
        System.out.println("-----------------------------------------");
        persons.stream().sorted((p1, p2) -> {
            if(p1.getAge() != p2.getAge()) {
                return p1.getAge() - p2.getAge();
            }
            return p1.getName().compareTo(p2.getName());
        }).forEach(System.out::println);
    }


    /*
        流映射操作
        map:传入一个Function接口的实例。所有流中的对象将按照这个函数逻辑进行映射
        flatMap:平铺映射。当map返回的是流的流时，flatMap则可以将这些流串起来，成为一个一维流（扁平化）
    */

    @Test
    public void test6() {
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        strList.stream().map((str) -> str.substring(1).toUpperCase()).forEach(System.out::println);

        System.out.println("-----------------------------------------");

        persons.stream().distinct().map(Person::getName).forEach(System.out::println);

        System.out.println("-----------------------------------------");

        Stream<Stream<Character>> stream = strList.stream().map(StreamTest::strToStream);
        stream.forEach((sm) -> sm.forEach(System.out::println));

        System.out.println("-----------------------------------------");

        strList.stream().flatMap(StreamTest::strToStream).forEach(System.out::println);
    }

    private static Stream<Character> strToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return  list.stream();
    }

    // 数据的切片与筛选
    @Test
    public void test5() {
        // distinct:去重流，使用对象内置的hashCode和equals进行去重。需要重写这两个方法才能做到正确去重
        persons.forEach(System.out::println); // Iterable接口定义的抽象方法forEach
//        persons.stream().forEach(System.out::println); // Stream类定义的抽象方法forEach
        System.out.println("----------------------------------");
        persons.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test4() {
        // skip:跳过流，跳过流中的前几个对象。与limit互补
        persons.stream().skip(2).forEach(System.out::println);
        System.out.println("----------------------------------");
        persons.stream().limit(2).forEach(System.out::println);
    }

    @Test
    public void test3() {
        // limit:截断流，仅返回前几个符合条件的对象，是一个具有短路性质的操作。
        persons.stream().limit(2).filter((p) -> {
            System.out.println("ShortCut!");
            return p.getAge() > 18;
        }).forEach(System.out::println); // 只在前两条数据中搜寻符合过滤条件的对象

        System.out.println("---------------------------------------");

        persons.stream().filter((p) -> {
            System.out.println("ShortCut!");
            return p.getAge() > 18;
        }).limit(2).forEach(System.out::println); // 在前五条数据中，一旦发现符合逻辑的对象，就输出。输出两次后终止
    }

    // 中间操作是一种惰性（懒）操作
    @Test
    public void test2() {
        // filter:过滤流，排除掉流中不需要的元素
        Stream<Person> stream = persons.stream().filter((p) -> {
            System.out.println("中间操作");
            return p.getAge() <100;
        });  // 传入一个Predicate的实现

        // forEach是一种内部迭代
//        stream.forEach(System.out::println); // 在执行终端操作时才执行中间操作（有了终端操作流水线才跑得起来）。
            // 注意！执行完终端操作后流就关闭了！

        System.out.println("***************************************");
        // 外部迭代
        Iterator<Person> iterator = stream.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    // 创建Stream对象的四种操作
    @Test
    public void test1() {
        // 1.通过Collection系列集合提供的stream()/parallelStream()（并行流）方法
        List<String> list = new ArrayList<>();
//        Stream stream1 = list.stream();    //类型推断，前面的泛型可以省略
        Stream<String> stream1 = list.stream(); // -> 注意！这里获得的流，与列表中放置的元素类型一致

        // 2.通过Arrays工具类提供的stream()方法，获取数组流
        Person[] persons = new Person[10];
        Stream<Person> stream2 = Arrays.stream(persons);

        // 3.通过Stream类中提供的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
//        Stream<String> stream3_2 = Stream.of(new String[]{"aa", "bb", "cc"});

        // 4.创建无限流
        //  4.1 迭代 -> 迭代出一个有规律的序列，前后项间有关系
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+3); // 传入一个产生无限流的seed（数组第一项）；
                                                                        // UanryOperator一个单元运算符（简单递推公式）
        stream4.limit(10).forEach(System.out::println);
        //  4.2 生成 -> 生成指定类型的变量，序列中各个元素是同一类型。但前后项间没有关系
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
