package kr.swu.book_rental.rental.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import kr.swu.book_rental.rental.dto.RentalReqDto;
import kr.swu.book_rental.rental.service.RentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

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

    /*final private RentService rentService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myrent")
    public String myrentList(Model model , Principal principal, @RequestParam(value = "page",defaultValue = "0")int page){
        SiteUser siteUser = this.userService.getUser(principal.getName());

        Page<Rent> paging = this.rentService.getMyList(page,siteUser);

        model.addAttribute("paging",paging);

        return "my_rent_list";

    }
    @GetMapping("/rent/return/{id}")
    public String reviewReturn(@PathVariable("id") int id, Model model , Principal principal){

        Book book = this.rentService.returnRent(id);
        this.bookService.returnBook(book);

        return "redirect:/myrent";
    } */

}
