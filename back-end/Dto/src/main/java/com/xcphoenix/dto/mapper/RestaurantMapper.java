package com.xcphoenix.dto.mapper;

import com.xcphoenix.dto.bean.Restaurant;
import org.apache.ibatis.annotations.Select;

/**
 * @author xuanc
 * @version 1.0
 * @date 2019/8/12 下午11:00
 */
public interface RestaurantMapper {

    /**
     * 检测用户是否已开店
     *
     * @param userId 用户 id
     * @return <li>用户所开的店铺id</li>
     * <li>null: 用户没有用开店记录</li>
     */
    @Select("SELECT restaurant_id FROM restaurant WHERE user_id = #{userId} ")
    Integer hasRestaurant(Integer userId);

    /**
     * 查找名为 name 的店铺 id
     *
     * @param name 店铺名
     * @return　id
     */
    @Select("SELECT restaurant_id FROM restaurant WHERE restaurant_name = #{name} ")
    Integer sameNameRsId(String name);

    /**
     * 添加店铺
     *
     * @param restaurant 店铺 bean
     */
    void addRestaurant(Restaurant restaurant);

    /**
     * 获取用户的店铺所有细节
     *
     * @param userId 用户 id
     * @return 店铺信息
     */
    Restaurant getUserShopDetail(Integer userId);

    /**
     * 更新店铺信息
     *
     * @param restaurant 店铺信息
     */
    void updateRestaurant(Restaurant restaurant);

    /**
     * 获取店铺信息
     *
     * @param shopId 店铺id
     * @return 店铺信息
     */
    Restaurant getShopDetailById(Integer shopId);

    /**
     * 店铺是否存在
     *
     * @param shopId 店铺id
     * @return 店铺存在否
     */
    @Select("SELECT COUNT(*) FROM restaurant WHERE restaurant_id = #{shopId} ")
    Integer isShopExists(Integer shopId);

}
