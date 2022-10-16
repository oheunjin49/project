package com.example.faq.Service;

import com.example.faq.model.Faq;
import com.example.faq.paging.Criteria;

import java.util.List;
import java.util.Optional;

public interface FaqService {

    public Optional<Faq> findById(long id);

    public Optional<Faq> detailFaq(Long id);

    public List<Faq> findByTitleContaining(Criteria criteria);

    public List<Faq> findAll(Criteria criteria);


    public Optional<Faq> save(Faq faq);

    public boolean deleteById(Long id);

    public boolean deleteAll();
}
