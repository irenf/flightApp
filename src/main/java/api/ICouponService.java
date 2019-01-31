package api;

import dtos.CouponResponse;

public interface ICouponService {

    CouponResponse calculateCoupon(final long couponId, final double price);

}
