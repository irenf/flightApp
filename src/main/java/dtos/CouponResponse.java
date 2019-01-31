package dtos;

import java.util.Objects;

public class CouponResponse {

    private final boolean couponValid;

    private final double priceAfterDiscount;

    public static CouponResponse noCoupon() {
        return new CouponResponse(false, 0);
    }

    public CouponResponse(boolean couponValid, double priceAfterDiscount) {
        this.couponValid = couponValid;
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public boolean isCouponValid() {
        return couponValid;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponResponse that = (CouponResponse) o;
        return couponValid == that.couponValid &&
                Double.compare(that.priceAfterDiscount, priceAfterDiscount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponValid, priceAfterDiscount);
    }

    @Override
    public String toString() {
        return "CouponResponse{" +
                "couponValid=" + couponValid +
                ", priceAfterDiscount=" + priceAfterDiscount +
                '}';
    }
}
