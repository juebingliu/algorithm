package com.util;

import org.apache.commons.lang.StringUtils;

import java.net.NetworkInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;


/** 
 * @Description: 时间(毫秒)+机器码+pid+自增
 * 	100W/毫秒 不会重复
 * @author FuMingJun
 * @date 2016-5-20 下午3:33:11 
 */
public class GenerateUniqueId {

	private static final int LOW_ORDER_THREE_BYTES = 0x00ffffff;
	
    private static final int MACHINE_IDENTIFIER;
    private static final int PROCESS_IDENTIFIER;
	  
    private static final AtomicLong NEXT_COUNTER_62 = new AtomicLong(0l);
    private static final AtomicLong NEXT_COUNTER_36 = new AtomicLong(0l);
    
    static {
        try {
            MACHINE_IDENTIFIER = createMachineIdentifier();
            PROCESS_IDENTIFIER = createProcessIdentifier();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 注意:生成唯一串,每耗秒999999并发不重复
     * @return
     */
    public static String getUniqueIdFormat(){
    	long counter     = NEXT_COUNTER_62.getAndIncrement()%1000000l;
    	StringBuilder sb = new StringBuilder();
    	sb.append(getCurrentDateStr("yyMMddHHmmssSSS"));
    	sb.append(HexUtil._10_to_62(Long.valueOf(MACHINE_IDENTIFIER).longValue()));
    	sb.append(HexUtil._10_to_62(Long.valueOf(PROCESS_IDENTIFIER).longValue()));
    	sb.append(StringUtils.leftPad(HexUtil._10_to_62(counter),4,"0"));
    	
    	return sb.toString();
    }
    
    /**
     * 生成62位超短串,每耗秒9999999并发不重复
     * 每台机器单个线程不重复
     * 
     * @return
     */
    public static String getUniqueIdSingleShort(){
    	long timestamp   = System.currentTimeMillis();
    	long counter     = NEXT_COUNTER_62.getAndIncrement()%10000000l;
    	StringBuilder sb = new StringBuilder();
    	sb.append(HexUtil._10_to_62(timestamp));
    	sb.append(HexUtil._10_to_62(Long.valueOf(MACHINE_IDENTIFIER).longValue()));
    	sb.append(StringUtils.leftPad(HexUtil._10_to_62(counter),4,"0"));
    	
    	return sb.toString();
    }
    
    /**
     * 生成36位超短串,每耗秒9999999并发不重复
     * 每台机器单个应用不重复
     * 
     * @return
     */
    public static String getUniqueIdSingleShort36(){
    	long timestamp   = System.currentTimeMillis();
    	long counter     = NEXT_COUNTER_36.getAndIncrement()%100000l;
    	StringBuilder sb = new StringBuilder();
    	sb.append(HexUtil._10_to_36(timestamp));
    	sb.append(HexUtil._10_to_36(Long.valueOf(MACHINE_IDENTIFIER).longValue()));
    	sb.append(StringUtils.leftPad(HexUtil._10_to_36(counter),4,"0"));
    	
    	return sb.toString();
    }
    
    /**
     * 生成62位超短串,每耗秒999999并发不重复
     * @return
     */
    public static String getUniqueIdShort(){
    	long timestamp   = System.currentTimeMillis();
    	long counter     = NEXT_COUNTER_62.getAndIncrement()%1000000l;
    	StringBuilder sb = new StringBuilder();
    	sb.append(HexUtil._10_to_62(timestamp));
    	sb.append(HexUtil._10_to_62(Long.valueOf(MACHINE_IDENTIFIER).longValue()));
    	sb.append(HexUtil._10_to_62(Long.valueOf(PROCESS_IDENTIFIER).longValue()));
    	sb.append(StringUtils.leftPad(HexUtil._10_to_62(counter),4,"0"));
    	
    	return sb.toString();
    }
    
    public static int getGeneratedMachineIdentifier() {
        return MACHINE_IDENTIFIER;
    }

    public static int getGeneratedProcessIdentifier() {
        return PROCESS_IDENTIFIER;
    }
    
	private static String getCurrentDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
    
	/**
	 * 获取机器码
	 * 
	 * @return
	 */
	private static int createMachineIdentifier() {
	        // build a 2-byte machine piece based on NICs info
	        int machinePiece;
	        try {
	            StringBuilder sb = new StringBuilder();
	            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
	            while (e.hasMoreElements()) {
	                NetworkInterface ni = e.nextElement();
	                sb.append(ni.toString());
	                byte[] mac = ni.getHardwareAddress();
	                if (mac != null) {
	                    ByteBuffer bb = ByteBuffer.wrap(mac);
	                    try {
	                        sb.append(bb.getChar());
	                        sb.append(bb.getChar());
	                        sb.append(bb.getChar());
	                    } catch (BufferUnderflowException shortHardwareAddressException) { //NOPMD
	                        // mac with less than 6 bytes. continue
	                    }
	                }
	            }
	            machinePiece = sb.toString().hashCode();
	        } catch (Throwable t) {
	            // exception sometimes happens with IBM JVM, use random
	            machinePiece = (new SecureRandom().nextInt());
	        }
	        machinePiece = machinePiece & LOW_ORDER_THREE_BYTES;
	        return machinePiece;
	    }

	    /**
	     * 获取进程ID
	     * 
	     * @return
	     */
	    private static int createProcessIdentifier() {
	        int processId;
	        try {
	            String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
	            if (processName.contains("@")) {
	                processId = Integer.parseInt(processName.substring(0, processName.indexOf('@')));
	            } else {
	                processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
	            }

	        } catch (Throwable t) {
	            processId = new SecureRandom().nextInt();
	        }

	        return processId;
	    }
	
	    public static void main(String[] args) {
			System.out.println(GenerateUniqueId.getUniqueIdFormat());
			System.out.println(GenerateUniqueId.getUniqueIdShort());
			System.out.println(GenerateUniqueId.getUniqueIdSingleShort());
			System.out.println(GenerateUniqueId.getUniqueIdSingleShort36());
			System.out.println(GenerateUniqueId.getUniqueIdSingleShort36());
		}
}

