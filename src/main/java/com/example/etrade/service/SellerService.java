package com.example.etrade.service;

import com.example.etrade.dto.SellerDto;
import com.example.etrade.dto.converter.SellerConverter;
import com.example.etrade.dto.request.CreateSellerRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.model.ConfirmCode;
import com.example.etrade.model.Seller;
import com.example.etrade.repository.ConfirmCodeRepository;
import com.example.etrade.repository.SellerRepository;
import com.example.etrade.util.MailSendService;
import org.springframework.stereotype.Service;

import static com.example.etrade.util.MailConstant.CONFIRM_CODE_DESCRIPTION;
import static com.example.etrade.util.MailConstant.CONFIRM_CODE_TITLE;

@Service
public class SellerService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final ConfirmCodeRepository confirmCodeRepository;
    private final SellerConverter sellerConverter;
    private final SellerRepository sellerRepository;

    public SellerService(MailSendService mailSendService, ConfirmCodeService confirmCodeService,
                         ConfirmCodeRepository confirmCodeRepository, SellerConverter sellerConverter,
                         SellerRepository sellerRepository) {
        this.mailSendService = mailSendService;
        this.confirmCodeService = confirmCodeService;
        this.confirmCodeRepository = confirmCodeRepository;
        this.sellerConverter = sellerConverter;
        this.sellerRepository = sellerRepository;
    }

    public SellerDto save(CreateSellerRequest request){
        var saved = sellerConverter.toEntity(request);
        if (sellerRepository.existsSellerByMail(saved.getMail())){
            throw new GenericExistException("Seller already exist, mail: " + saved.getMail());
        }
        sellerRepository.save(saved);
        return sellerConverter.convertToDto(saved);
    }

    public void delete(String mail){
        var fromSeller = getSellerByMail(mail);
        sellerRepository.delete(fromSeller);
    }

    public Seller getSellerByMail(String mail){
        return sellerRepository.findSellerByMail(mail)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public SellerDto getByMail(String mail){
        var fromDbSeller = sellerRepository.findSellerByMail(mail)
                .orElseThrow(() -> new NotFoundException("Mail not found: " + mail));
        return sellerConverter.convertToDto(fromDbSeller);
    }

    public SellerDto activeSeller(String mail,int code){
        var seller = getSellerByMail(mail);

        if (seller.getConfirmCode().getCode() == code) {
            return null;
        }
        seller.setActive(true);
        confirmCodeRepository.deleteById(seller.getConfirmCode().getId());
        sellerRepository.save(seller);
        return sellerConverter.convertToDto(seller);
    }

    public SellerDto deActivateSeller(String mail) {
        var fromDbSeller = getSellerByMail(mail);
        fromDbSeller.setActive(false);
        sellerRepository.save(fromDbSeller);

        return sellerConverter.convertToDto(fromDbSeller);
    }

    public void sendConfirmCode(String mail){
        var seller = getSellerByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        seller.setConfirmCode(confirmCode);
        sellerRepository.save(seller);

        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());
        mailSendService.sendMail(seller.getMail(),CONFIRM_CODE_TITLE,description);
    }

}