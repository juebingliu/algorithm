package com.java8;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author juebing
 * @description 计算字数的stream
 * @date 13:29 2019/4/21
 */
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    final static String SENTENCE =
            " Nel mezzo del cammin di nostra vita " +
                    "mi ritrovai in una selva oscura" +
                    " ché la dritta via era smarrita ";

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public int getCounter() {
        return counter;
    }

    WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ?
                    this :
                    new WordCounter(counter, true);
        } else {
            return lastSpace ?
                    new WordCounter(counter + 1, false) :
                    this;
        }
    }
    WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter,
                wordCounter.lastSpace);
    }

    //stream形式
    public static int countWordsByStream(Stream<Character> stream) {
        WordCounter counter = stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);
        return counter.getCounter();
    }

    //普通迭代统计
    public  static int countWords(String s) {
        int count = 0;
        boolean isWhiteSpace = true;
        for (char c : s.toCharArray()) {
            if(Character.isWhitespace(c)) {
                isWhiteSpace = true;
            }else {
                if (isWhiteSpace) count++;
                isWhiteSpace  = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Stream<Character> stream = IntStream.range(0,WordCounter.SENTENCE.length()).mapToObj(WordCounter.SENTENCE::charAt);

        //顺序流
//        System.out.println("count:" + WordCounter.countWordsByStream(stream));

        //并行流
//        System.out.println("count:" + WordCounter.countWordsByStream(stream.parallel()));

        //自定义Spliterator,处理并行流
        Spliterator<Character> spliterator = new WordCounterSpliterator(WordCounter.SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator,true);
        System.out.println("count:" + WordCounter.countWordsByStream(stream1));
    }
}
