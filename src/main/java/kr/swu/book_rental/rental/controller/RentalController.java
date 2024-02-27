package kr.swu.book_rental.rental.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import kr.swu.book_rental.rental.dto.RentalReqDto;
import kr.swu.book_rental.rental.service.RentalService;
import kr.swu.book_rental.global.response.CommonResult;
import kr.swu.book_rental.global.response.ResponseService;
import kr.swu.book_rental.global.response.SingleResult;

@RequestMapping("/api/rental")
@RequiredArgsConstructor
@RestController

public class RentalController {

    private final ResponseService responseService;
    private final RentalService rentalBookService;

    @GetMapping("/{bookNum}") @ApiOperation(value = "대여")
    public CommonResult rental(@PathVariable("bookNum") Long bookNum){
        rentalBookService.rentalBook(bookNum);
        return responseService.getSuccessResult();
    }
    
    @DeleteMapping("/return") @ApiOperation(value = "반납")
    public SingleResult<Long> returnBook(@PathVariable RentalReqDto.ReturnBook book){
        return responseService.getSingleResult(rentalBookService.returnBook(book.getbookNum()));
    }

    @PostMapping("/renew/{bookNum}") @ApiOperation(value = "도서 연장")
    public CommonResult renewBook(@PathVariable Long bookNum){
        rentalBookService.renewBook(bookNum);
        return responseService.getSuccessResult();
    }
}
