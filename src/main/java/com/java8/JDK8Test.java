package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/15 14:44
 * @description
 */
public class JDK8Test {
    public static void main(String[] args) {
        //找到一个目录中所有的隐藏文件
        //谓词
//        File[] files = new File(".").listFiles(File::isHidden);

        //lambda&stream
//        JDK8Test.createList().stream().filter((Apple a) -> a.getWeight() > 1).map(Apple::getColor).forEach(System.out::println);
        //并行处理
        //list.parallelStream().filter((Apple a) -> a.getWeight() > 1).map(Apple::getColor).forEach(System.out::println);

        //比较
//        JDK8Test.createList().sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
//        JDK8Test.createList().sort(Comparator.comparing(Apple::getWeight));

        //runnable
//        new Thread(() -> System.out.println("this is a lambda test")).start();
//        Runnable r1 = () -> System.out.println("ok");

        //GUI
//        Button button = new Button("Send");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//                System.out.println("ok");
//            }
//        });
//        button.setOnAction((ActionEvent e) -> System.out.println("ok"));

        //泛型只能绑定到引用类型
//        IntPredicate nums = (int i) ->l i%2 == 0;
//        System.out.println(nums.test(1000));//不装箱
//        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 0;
//        System.out.println(oddNumbers.test(1000));//自动装箱

        //方法引用
//        Supplier<Product> supplier = Product::new;
//        BiFunction<String,Integer,Product> bf = Product::new;
//        bf.apply("aaa",123);

        //集合流式处理
//        JDK8Test.createList().stream()
//                .filter(a -> a.getWeight()>1)
//                .sorted(Comparator.comparing(Apple::getWeight).reversed())
//                .map(Apple::getColor)
//                .collect(Collectors.toList());
        //筛选 toSet()直接也可以去重
//        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 6, 8);
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .skip(1)
//                .limit(2)
//                .forEach(System.out::println);
        //映射
//        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
//        List<Integer> wordLengths = words.stream()
//                .map(String::length)
//                .collect(Collectors.toList());
//        wordLengths.stream().forEach(System.out::println);

        //flatMap
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<int[]> pairs =
//                numbers1.stream()
//                        .flatMap(i -> numbers2.stream()
//                                .map(j -> new int[]{i, j})
//                        )
//                        .collect(Collectors.toList());
        //查找
//        JDK8Test.createList().stream()
//                .findAny()
//                .ifPresent(a -> System.out.println(a.getColor()));
        //归约
//        List<Integer> numbers = Arrays.asList(1, 2, 3);
//        System.out.println(numbers.stream().reduce(0,(a,b) -> a+b));
//        System.out.println(numbers.stream().reduce(0,Integer::sum));
//        System.out.println(numbers.stream().reduce(Integer::sum).get());
//        System.out.println(JDK8Test.createList().stream().mapToInt(Apple::getWeight).sum());

        //数值流
//        IntStream.rangeClosed(1,100).boxed()
//                .flatMap(a -> IntStream.rangeClosed(a,100)
//                .mapToObj(b -> new double[]{a,b,  Math.sqrt(a*a + b*b)}))
//                .filter(t -> t[2] % 1 == 0 )
//                .limit(5)
//                .forEach(t -> System.out.println(t[0]+","+t[1]+","+t[2]));

        //文件流
//        try {
//            long count = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())
//                    .flatMap(line -> Arrays.stream(line.split("")))
//                    .distinct()
//                    .count();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //函数流
//        Stream.iterate(0,n -> n+2)
//                .limit(5)
//                .forEach(System.out::println);
//
//        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1],t[0]+t[1]})
//                .limit(10)
//                .map(t -> t[0])
//                .forEach(System.out::println);
//
//        Stream.generate(Math::random)
//                .limit(5)
//                .forEach(System.out::println);

        //连接
        System.out.println(JDK8Test.createList().stream().map(Apple::getColor).collect(Collectors.joining(",")));
        //分组,可以是枚举
        Map<String,List<Apple>> map1 = JDK8Test.createList().stream().collect(Collectors.groupingBy(Apple::getColor));
        //多级分组
        Map<String,Map<String,List<Apple>>> map2 = JDK8Test.createList()
                .stream()
                .collect(Collectors.groupingBy(Apple::getColor,
                        Collectors.groupingBy((Apple a) -> {if(a.getWeight() > 3) return "big"; else return "small";})));

        JDK8Test.createList().stream().collect(Collectors.groupingBy(Apple::getColor,Collectors.counting()));
    }

    public static List<Apple> createList() {
        Apple a1 = new Apple("red",1);
        Apple a2 = new Apple("green",2);
        Apple a3 = new Apple("blue",3);
        Apple a4 = new Apple("blue",5);
        Apple a5 = new Apple("green",8);
        List<Apple> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        return list;
    }

}