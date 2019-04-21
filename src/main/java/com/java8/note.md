lambda&stream
1、函数式编程(值)(行为参数化)(无状态)(并行).
    1.0、类&类型参数化->泛型.
    1.1、行为参数化->predicate,谓词.
    1.2、匿名函数.
    1.3、lambda,(parameters) -> (expression) or (parameters) -> { statement },(函数签名).
    1.4、c#&scala.
    1.5、函数式接口(接口中有一个抽象方法)(@FunctionalInterface).
    1.6、Predicate<T>,Consumer<T>,Supplier<T>,Function<T,R>
    1.7、类型推断&局部变量捕获一次.
    1.8、方法引用::&&复合引用&&流水线.
    
2、stream.
    2.1、从支持数据处理操作的源生成的元素序列(集合、数组或输入/输出资源)(有序).
    2.2、集合&流,实时创建&延迟创建.
    2.3、流水线&内部迭代.
    2.4、中间操作&终端操作.
    2.5、筛选(filter,distinct,limit,skip)、切片、映射(map,flatMap-拆分&合并)、查找、匹配(allMatch、anyMatch、noneMatch、findFirst和findAny)和归约(reduce).
    2.6、有状态操作(reduce,sorted,distinct)&无状态操作(filter,map)
    2.7、数值->流(装箱boxed,拆箱mapToxxx,OptionalXXX,range/rangeClose),Arrays.stream()
    2.8、文件->流,Files.line(Path)
    2.9、函数->流(Stream.iterate & Stream.generate ,避免装箱IntSupplier)
    2.10、收集器
        2.10.1、收集器(Collector)(sunming,summarizing,averaging)(joining 连接字符串).
        2.10.2、reducing某种程度上来说相当于收集器,但性能不如收集器,收集器嵌套使用.
        2.10.3、分组(groupingBy)&分区(partitioningBy)(需要一个谓词predicate)
        2.10.4、自定义collector.

3、并行流parallelStream.
    3.1、分块->合并
    3.2、Runtime.getRuntime().availableProcessors() & System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
    3.3、并行流不总是比顺序流要快-(装箱/拆箱,分配子流,在多个内核之间移动数据)
    3.4、优化准则-单一内核的工作时间>内核之间传输数据的时间 & 针对性流
    3.5、共享状态
    3.6、优化-原始类型流,考虑操作本身性能,单个元素通过流水线的粗略成本,数据量,快速分块,中间操作&终端操作
    3.7、fork&join
        3.7.1、RecursiveTask<R>-拆分子任务(分治)(递归)
        3.7.2、合并
        3.7.3、优化类比并行流
        3.7.4、工作窃取
    3.8、Spliterator
3、Optional<T>避免空指针.
