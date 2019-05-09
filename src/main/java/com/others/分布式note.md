分布式限流的几种算法：信号量Semaphore，漏桶，令牌桶

请求拒绝策略：失效转移模式

ACID，CAP，BASE

分布式事务：两段提交，三段提交，TCC协议（try，catch，cancel）

全局唯一ID，调用链跟踪

另外，通过对比Log4j 2 和Log4j 、Logback 等，我们发现它们在异步记录日志功能方面的
差异。异步Appender 的性能随着线程数的增加基本保持不变，而Log4j 2 的异步Logger 随着线
程数的增加其吞吐量也持续增加，在多核CPU 系统中能够达到更好的性能。