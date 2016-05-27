package data.web;

import data.entity.Customer;
import data.entity.Dictionary;
import data.entity.DictionaryItem;
import data.entity.User;
import data.helper.NullHelper;
import data.query.QCustomer;
import data.query.QDictionary;
import data.query.QDictionaryItem;
import data.repository.DictionaryItemRepository;
import data.repository.DictionaryRepository;
import data.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author 刘佳兴
 */
@RestController
public class DictionaryController {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    DictionaryItemRepository dictionaryItemRepository;

    @Autowired
    DictionaryService dictionaryService;

    @RequestMapping(value = "/dictionaries", method = RequestMethod.POST)
    Dictionary create(@RequestBody Dictionary dictionary) {
        return dictionaryService.saveOrUpdate(dictionary);
    }

    @RequestMapping(value = "/dictionaries/{id}", method = RequestMethod.GET)
    Dictionary findOne(@PathVariable Long id) {
        return dictionaryRepository.findOne(id);
    }

    @RequestMapping(value = "/dictionaries/{id}", method = RequestMethod.POST)
    Dictionary update(@RequestBody Dictionary dictionary, @PathVariable Long id) {
        Dictionary old = dictionaryRepository.findOne(id);
        BeanUtils.copyProperties(dictionary, old, NullHelper.getNullPropertyNames(dictionary));
        return dictionaryService.saveOrUpdate(dictionary);
    }

    @RequestMapping(value = "/dictionaries/{id}", method = RequestMethod.DELETE)
    void deleteDictionary(@PathVariable Long id) {
        dictionaryService.delete(id);
    }

    @RequestMapping(value = "/dictionaries", method = RequestMethod.GET)
    Page<Dictionary> page(QDictionary qDictionary, Pageable pageable) {
        return dictionaryRepository.findAll(qDictionary, pageable);
    }

    @RequestMapping(value = "/dictionaries/{code}/items", method = RequestMethod.GET)
    List<DictionaryItem> dictionaryItems(@PathVariable String code) {
        QDictionaryItem qDictionaryItem = new QDictionaryItem();
        qDictionaryItem.setEqualCode(code);
        return dictionaryItemRepository.findAll(qDictionaryItem);
    }

    @RequestMapping(value = "/dictionaries/{code}/items/{id}", method = RequestMethod.DELETE)
    void deleteDictionaryItem(@PathVariable String code, @PathVariable Long id) {
        dictionaryItemRepository.delete(id);
    }

}
