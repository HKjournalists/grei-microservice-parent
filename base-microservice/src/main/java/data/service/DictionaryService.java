package data.service;

import data.entity.Dictionary;
import data.entity.DictionaryItem;
import data.query.QDictionaryItem;
import data.repository.DictionaryItemRepository;
import data.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 刘佳兴
 */
@Transactional
@Service
public class DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    DictionaryItemRepository dictionaryItemRepository;

    public Dictionary saveOrUpdate(Dictionary dictionary) {
        dictionaryRepository.save(dictionary);
        dictionary.getDictionaryItems().forEach(dictionaryItem -> {
            if(StringUtils.isEmpty(dictionaryItem.getCode())) dictionaryItem.setCode(dictionary.getCode());
            dictionaryItemRepository.save(dictionaryItem);
        });
        return dictionary;
    }

    public void delete(Long id) {
        Dictionary dictionary = dictionaryRepository.findOne(id);
        QDictionaryItem qDictionaryItem = new QDictionaryItem();
        qDictionaryItem.setEqualCode(dictionary.getCode());
        List<DictionaryItem> dictionaryItem = dictionaryItemRepository.findAll(qDictionaryItem);
        dictionaryItemRepository.deleteInBatch(dictionaryItem);
        dictionaryRepository.delete(dictionary);
    }


}
