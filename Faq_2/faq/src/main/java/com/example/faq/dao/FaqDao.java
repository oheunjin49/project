package com.example.faq.dao;

import com.example.faq.model.Faq;
import com.example.faq.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FaqDao {

    public Optional <Faq> findById(Long id);

    public List<Faq> findByTitleContaining(Criteria criteria);

    public List<Faq> findAll(Criteria criteria);

    public int selectTotalCount(String title);

    public long insertFaq(Faq faq);

    public long updateFaq(Faq faq);

    public long deleteFaq(Long id);

    public long deleteAll();
}
