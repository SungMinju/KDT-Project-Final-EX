package kr.swu.book_rental.rental;

//import kr.swu.book_rental.book.Book; ->책 관련 정보
//import kr.swu.book_rental.user.User; ->개인정보
import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;


import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDate; //날짜 정보를 나타내는 클래스

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Rental {
    @Id @GenerateValue
    @Column(name = "id")  //유저 아이디
    private Long id;

    @OneToOne
    @JoinColum(name = "bookNum") //책 번호
    private Book number;

    @OneToOne //일대일 관계 표시
    @JoinColumn(name = "bookName") //bookName 열을 외래 키로 사용
    private Book book; //외래 키가 멤버 변수 book에 대입 -> book 변수 사용

    @ManytoOne
    @JoinColum(name = "author") // 책 저자 -> 외래 키 사용
    private Book author;

    @Column(name = "RENTAL_DATE")
    private LocalDate rental_date;

    @Column(name = "RETURN_DATE")
    private LocalDate return_date;

    //대여 중인 상태 ..??
}
