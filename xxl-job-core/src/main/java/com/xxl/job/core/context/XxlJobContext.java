package com.xxl.job.core.context;

/**
 * xxl-job context
 *
 * @author xuxueli 2020-05-21
 * [Dear hj]
 * 新增任务属性 "XxlJobContent" ，统一维护任务上下文信息，包括任务ID、分片参数等，方便运行时存取任务相关信息；
 */
public class XxlJobContext {

    /**
     * job id
     */
    private final long jobId;

    /**
     * job log filename
     */
    private final String jobLogFileName;

    /**
     * shard index
     */
    private final int shardIndex;

    /**
     * shard total
     */
    private final int shardTotal;


    public XxlJobContext(long jobId, String jobLogFileName, int shardIndex, int shardTotal) {
        this.jobId = jobId;
        this.jobLogFileName = jobLogFileName;
        this.shardIndex = shardIndex;
        this.shardTotal = shardTotal;
    }

    public long getJobId() {
        return jobId;
    }

    public String getJobLogFileName() {
        return jobLogFileName;
    }

    public int getShardIndex() {
        return shardIndex;
    }

    public int getShardTotal() {
        return shardTotal;
    }


    // ---------------------- tool ----------------------

    private static InheritableThreadLocal<XxlJobContext> contextHolder = new InheritableThreadLocal<XxlJobContext>(); // support for child thread of job handler)

    public static void setXxlJobContext(XxlJobContext xxlJobContext){
        contextHolder.set(xxlJobContext);
    }

    public static XxlJobContext getXxlJobContext(){
        return contextHolder.get();
    }

}