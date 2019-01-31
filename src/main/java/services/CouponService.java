package services;

import api.ICouponService;
import cache.InMemoryCache;
import database.CouponDAO;
import datalayer.Coupon;
import dtos.CouponResponse;

public class CouponService implements ICouponService {

    private final CouponDAO couponDAO;

    private final InMemoryCache<Long, Coupon> couponsCache;

    public CouponService(CouponDAO couponDAO) {
        this.couponDAO = couponDAO;
        couponsCache = new InMemoryCache<>(15);
    }

    public CouponResponse calculateCoupon(long couponId, double price) {
        Coupon coupon = couponsCache.get(couponId);
        if (coupon == null) {
            coupon = couponDAO.findCouponById(couponId);
            if (coupon != null) {
                couponsCache.set(couponId, coupon);
            }
        }
        if (coupon == null) {
            return CouponResponse.noCoupon();
        }

        return new CouponResponse(true, price * (1 - coupon.getCouponDiscount().getDiscount()));
    }
}
