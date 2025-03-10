   class Solution {
        public int solution(int chicken) {

            int coupon = chicken;
            int serviceCount = 0;

            while ((coupon / 10) > 0) {

                int serviceChicken = coupon / 10; // 108
                int remainCoupon = coupon % 10; // 1

                serviceCount += serviceChicken;
                coupon = serviceChicken + remainCoupon;
            }

            return serviceCount;
        }
    }