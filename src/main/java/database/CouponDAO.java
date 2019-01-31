package database;

import datalayer.Coupon;

import java.util.HashMap;
import java.util.Map;

public class CouponDAO {

    private final Map<Long, Coupon> coupons = new HashMap<>();

    public void addCoupon(final Coupon coupon) {
        coupons.put(coupon.getId(), coupon);
    }

    public Coupon findCouponById(long couponId) {
        return coupons.get(couponId);
    }
}
