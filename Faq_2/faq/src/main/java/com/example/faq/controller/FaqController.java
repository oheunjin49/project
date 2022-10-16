package com.example.faq.controller;

import com.example.faq.Service.FaqServiceImpl;
import com.example.faq.model.Faq;
import com.example.faq.paging.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class FaqController {
    @Autowired
    private FaqServiceImpl faqService;

    @PostMapping("/faqs")
    public ResponseEntity<Object> createFaq(@RequestBody Faq faq){
        Faq savedFaq = faqService.save(faq).get();

        try{
            return new ResponseEntity<Object>(savedFaq, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
    //상세페이지
    @GetMapping("/faqs/detail/{id}")
    public ResponseEntity<Object>detailFaq(@PathVariable("id") long id){
        Faq detailFaq = faqService.detailFaq(id).get();

        try {
            return new ResponseEntity<Object>(detailFaq, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/faqs/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id")Long id){

        Faq faq = faqService.findById(id).get();

        try{
            if(faq != null){
                return new ResponseEntity<Object>(faq, HttpStatus.OK);
            }else{
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/faqs")
    public ResponseEntity<Map<String, Object>> getAllTitlePage(Criteria criteria){

        List<Faq> faqs = faqService.findByTitleContaining(criteria);

        try{
            if(faqs.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("faqs", faqs);
            response.put("currentPage", criteria.getPage());
            response.put("totalItems", criteria.getTotalItems());
            response.put("totalPage", criteria.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/faqs/{id}")
    public ResponseEntity<Object> updateFaq( @RequestBody Faq faq, @PathVariable("id")Long id){
        try{
            faq.setId(id);
            Faq savedFaq = faqService.save(faq).get();
            return new ResponseEntity<Object>(savedFaq, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/faqs/deletion/{id}")
    public ResponseEntity<HttpStatus> deleteFaq(
            @PathVariable("id") Long id) {
        try{
            faqService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }

}
