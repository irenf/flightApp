package services;

import data.DataSampleCreator;
import database.CouponDAO;
import dtos.CouponResponse;
import org.junit.Assert;
import org.junit.Test;

public class CouponServiceTest {

    @Test
    public void testCalculateCoupon() {
        CouponDAO couponDAO = DataSampleCreator.createCouponDAO(1000);
        CouponService couponService = new CouponService(couponDAO);
        final int couponId = 10;
        final int priceWithoutDiscount = 100;
        float discount = couponDAO.findCouponById(couponId).getCouponDiscount().getDiscount();
        CouponResponse response = couponService.calculateCoupon(couponId, priceWithoutDiscount);
        Assert.assertTrue("Coupon 10 expected to be valid", response.isCouponValid());
        Assert.assertTrue("Discount is not as expected",
                Math.abs(response.getPriceAfterDiscount() - priceWithoutDiscount * (1f - discount)) < 0.0001);

        Assert.assertEquals(
                "Discount ID should not be found",
                CouponResponse.noCoupon(),
                couponService.calculateCoupon(5000, priceWithoutDiscount)
        );
    }
}
