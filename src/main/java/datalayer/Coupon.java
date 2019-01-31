package datalayer;

import java.util.Objects;

public class Coupon {

    private final long id;

    private final ECouponDiscount couponDiscount;

    public Coupon(long id, ECouponDiscount couponDiscount) {
        this.id = id;
        this.couponDiscount = couponDiscount;
    }

    public long getId() {
        return id;
    }

    public ECouponDiscount getCouponDiscount() {
        return couponDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return id == coupon.id &&
                couponDiscount == coupon.couponDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, couponDiscount);
    }

    public enum ECouponDiscount {
        P10(0.1f, "10%"),
        P50(0.5f, "50%"),
        P60(0.6f, "60%");

        private final float discount;

        private final String displayName;

        ECouponDiscount(float discount, String displayName) {
            this.discount = discount;
            this.displayName = displayName;
        }

        public float getDiscount() {
            return discount;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
