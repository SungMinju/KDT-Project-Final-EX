package kr.swu.book_rental.rental.dto;

import lombok.Getter;
import lombok.Setter;
public class RentalReqDto {

    @Getter
    @Setter
    public static class RentalBook { // 대여
        private Long bookNum;
    }

    @Getter
    @Setter
    public static class Renew { // 연장
        private Long bookNum;
    }

    @Getter
    @Setter
    public static class ReturnBook { // 반납
        private Long bookNum;
    }
}
