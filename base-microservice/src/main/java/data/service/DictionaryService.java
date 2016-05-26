package data.service;

import data.entity.Dictionary;
import data.entity.DictionaryItem;
import data.query.QUser;
import data.repository.DictionaryItemRepository;
import data.repository.DictionaryRepository;
import data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        dictionary.getDictionaryItems().forEach(dictionaryItem -> {
            dictionaryItemRepository.save(dictionaryItem);
        });
        dictionaryRepository.save(dictionary);
        return dictionary;
    }


}
