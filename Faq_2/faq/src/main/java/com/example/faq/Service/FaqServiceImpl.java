package com.example.faq.Service;

import com.example.faq.dao.FaqDao;
import com.example.faq.model.Faq;
import com.example.faq.paging.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService{

    @Autowired
    private FaqDao faqDao;

    @Override
    public Optional<Faq> detailFaq(Long id) {
        return faqDao.findById(id);
    }

    @Override
    public Optional<Faq> findById(long id) {
        return faqDao.findById(id);
    }



    @Override
    public List<Faq> findByTitleContaining(Criteria criteria) {
        List<Faq> faqs = Collections.emptyList();

        Optional<String> optionalCriteria = Optional.ofNullable(criteria.getTitle());

        int totalCount = faqDao.selectTotalCount(optionalCriteria.orElse(""));

        criteria.setTotalItems(totalCount);
        criteria.setTotalPages(totalCount/ criteria.getSize());

        if(criteria.getTitle() == null){
            faqs = faqDao.findAll(criteria);
        }
        else{
            faqs = faqDao.findByTitleContaining(criteria);
        }
        return faqs;
    }

    @Override
    public List<Faq> findAll(Criteria criteria) {
        return faqDao.findAll(criteria);
    }

    @Override
    public Optional<Faq> save(Faq faq) {
        long seqId = 0;

        if(faq.getId() == null ){
            faqDao.insertFaq(faq);
        }
        else{
            faqDao.updateFaq(faq);
        }

        seqId = faq.getId();

        return faqDao.findById(seqId);
    }

    @Override
    public boolean deleteById(Long id) {
        long queryResult=0;
        queryResult = faqDao.deleteFaq(id);
        return queryResult >= 1;

    }

    @Override
    public boolean deleteAll() {
        long queryResult = 0;

        queryResult= faqDao.deleteAll();

        return queryResult >= 1;
    }
}
