package com.xxl.job.admin.core.scheduler;

import com.xxl.job.admin.core.util.I18nUtil;

/**
 * @author xuxueli 2020-10-29 21:11:23
 * 调度过期策略：调度中心错过调度时间的补偿处理策略，包括：忽略、立即补偿触发一次等
 */
public enum MisfireStrategyEnum {

    /**
     * do nothing
     */
    DO_NOTHING(I18nUtil.getString("misfire_strategy_do_nothing")),

    /**
     * fire once now
     */
    FIRE_ONCE_NOW(I18nUtil.getString("misfire_strategy_fire_once_now"));

    private String title;

    MisfireStrategyEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // 缺省策略 值得借鉴
    public static MisfireStrategyEnum match(String name, MisfireStrategyEnum defaultItem){
        for (MisfireStrategyEnum item: MisfireStrategyEnum.values()) {
            if (item.name().equals(name)) {
                return item;
            }
        }
        return defaultItem;
    }

}
