package kr.swu.book_rental.rental.service;

public class RentalService {
    public Long returnBook(Long bookNum){ // 책 반납
        rentalRepository.deleteById(bookNum); // Rental Table에 저장된 컬럼을 지움으로써 반납
        return bookNum;
    }
    //해당 하는 도서의 번호를 입력 또는 클릭 후,
    // 외래 키 bookNum을 -> retalRepository에 대입
    // 반납할 때, rentalRepository에서 삭제.
}
