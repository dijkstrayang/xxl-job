package com.xxl.job.core.enums;

/**
 * Created by xuxueli on 17/5/10.
 * 执行器与数据库彻底解耦，但是执行器需要配置调度中心集群地址。
 * 调度中心提供API供执行器回调和心跳注册服务，取消调度中心内部jetty，心跳周期调整为30s，心跳失效为三倍心跳；
 */
public class RegistryConfig {

    public static final int BEAT_TIMEOUT = 30;
    public static final int DEAD_TIMEOUT = BEAT_TIMEOUT * 3;

    public enum RegistType{ EXECUTOR, ADMIN }

}
